package com.mic.project.al.service;

import com.beust.jcommander.internal.Lists;
import com.google.common.base.Joiner;
import com.google.common.collect.Sets;
import com.mic.project.al.model.RelatedDocuments;
import com.mic.project.al.model.UserDocuments;
import com.mic.project.al.repository.RelatedDocumentsRepository;
import com.mic.project.al.service.keyword.CardKeyword;
import com.mic.project.al.service.keyword.KeywordsExtractor;
import com.mic.project.al.service.youtube.YoutubeSearchService;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.BodyContentHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Set;

@Service
public class DocumentParserServiceImpl implements DocumentParserService {
    @Autowired
    private UserDocumentService userDocumentService;
    @Autowired
    private RelatedDocumentsRepository relatedDocumentsRepository;

    @Override
    public String parseDocument(String filePath) throws Exception {
        BodyContentHandler handler = new BodyContentHandler();

        AutoDetectParser parser = new AutoDetectParser();
        Metadata metadata = new Metadata();
        try (InputStream stream = new FileInputStream(filePath)) {
            parser.parse(stream, handler, metadata);
            return handler.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Unable to parse file");
        }
    }

    //@Scheduled(fixedDelay = 10000, initialDelay = 5000)
    public void scheduleProfiling() {
        System.out.println("Started profiling............");
        List<UserDocuments> userDocuments = userDocumentService.findByProfilingDone(false);
        if (userDocuments != null) {
            for (UserDocuments userDocument : userDocuments) {
                try {
                    Set<String> keywords = getKeywords(userDocument.getAbsolutePath());


                    List<RelatedDocuments> relatedDocumentss = Lists.newArrayList();
                    for (String keyword : keywords) {
                        relatedDocumentss.addAll(YoutubeSearchService.search(keyword, userDocument.getId()));
                        relatedDocumentss.addAll(YoutubeSearchService.googleSearch(keyword, userDocument.getId()));
                    }
                    userDocument.setKeywords(Joiner.on(",").join(keywords));
                    //userDocument.setProfilingDone(true);
                    userDocumentService.save(userDocument);
                    relatedDocumentsRepository.save(relatedDocumentss);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Completed profiling............");
    }

    public static void main(String[] args) {
        DocumentParserServiceImpl documentParserService = new DocumentParserServiceImpl();
        try {
            String text = documentParserService.parseDocument("/Users/rchejerla/Documents/ws/adaptive-learning/src/main/webapp/documents/rchejerla/boardingPass.pdf");
            List<CardKeyword> keywordsList = KeywordsExtractor.getKeywordsList(text);
            for (CardKeyword cardKeyword : keywordsList) {
                System.out.println(cardKeyword.getStem());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Set<String> getKeywords(String filePath) {
        Set<String> keywords = Sets.newHashSet();
        try {
            String text = parseDocument(filePath);
            List<CardKeyword> keywordsList = KeywordsExtractor.getKeywordsList(text);
            int i = 0;
            for (CardKeyword cardKeyword : keywordsList) {
                keywords.add(cardKeyword.getStem());
                if (++i == 5) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return keywords;
    }
}
