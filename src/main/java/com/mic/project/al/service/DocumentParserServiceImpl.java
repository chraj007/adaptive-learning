package com.mic.project.al.service;

import com.beust.jcommander.internal.Lists;
import com.google.common.base.Joiner;
import com.google.common.collect.Sets;
import com.mic.project.al.model.Questionnaire;
import com.mic.project.al.model.RelatedDocuments;
import com.mic.project.al.model.UserDocuments;
import com.mic.project.al.repository.QuesionaireRepository;
import com.mic.project.al.repository.RelatedDocumentsRepository;
import com.mic.project.al.service.contentprofile.ContentLengthUtil;
import com.mic.project.al.service.contentprofile.FleschIndexUtil;
import com.mic.project.al.service.contentprofile.InteractivityLevelUtil;
import com.mic.project.al.service.keyword.CardKeyword;
import com.mic.project.al.service.keyword.KeywordsExtractor;
import com.mic.project.al.service.youtube.YoutubeSearchService;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.BodyContentHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;

import static org.apache.http.protocol.HTTP.USER_AGENT;

@Service
public class DocumentParserServiceImpl implements DocumentParserService {
    @Autowired
    private UserDocumentService userDocumentService;
    @Autowired
    private RelatedDocumentsRepository relatedDocumentsRepository;
    @Autowired
    private QuesionaireRepository quesionaireRepository;

    @Override
    public String parseDocument(String filePath) throws Exception {
        try (InputStream stream = new FileInputStream(filePath)) {
            return parseDocument(stream);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Unable to parse file");
        }
    }

    private String parseDocument(InputStream stream) throws Exception {
        AutoDetectParser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        parser.parse(stream, handler, metadata);
        return handler.toString();

    }

    @Scheduled(fixedDelay = 10000, initialDelay = 5000)
    public void scheduleProfiling() {
        System.out.println("Started profiling............");
        List<UserDocuments> userDocuments = userDocumentService.findByProfilingDone(false);
        if (userDocuments != null) {
            for (UserDocuments userDocument : userDocuments) {
                try {
                    Set<String> keywords = getKeywords(userDocument.getAbsolutePath());
                    String searchSuffix = " Tutorial";
                    List<RelatedDocuments> relatedDocumentss = Lists.newArrayList();

                    List<RelatedDocuments> yts = Lists.newArrayList();
                    List<RelatedDocuments> txts = Lists.newArrayList();
                    for (String keyword : keywords) {
                        yts.addAll(YoutubeSearchService.search(keyword + searchSuffix, userDocument.getId()));
                        txts.addAll(YoutubeSearchService.googleSearch(keyword + searchSuffix, userDocument.getId()));
                    }

                    for (RelatedDocuments txt : txts) {
                        String webContent = getWebContent(txt.getUrl());
                        if (webContent == null) {
                            continue;
                        }
                        txt.setDifficultyLevel(FleschIndexUtil.getDiffLevel(webContent));
                        txt.setInteractivityLevel(InteractivityLevelUtil.getInteractivityLevel(webContent));
                        txt.setLength(ContentLengthUtil.getTextLength(webContent));
                        relatedDocumentss.add(txt);
                    }
                    for (RelatedDocuments yt : yts) {
                        yt.setDifficultyLevel(FleschIndexUtil.getDiffLevel(yt.getDescription()));
                        yt.setInteractivityLevel(InteractivityLevelUtil.getInteractivityLevel(yt.getDescription()));
                        yt.setLength(ContentLengthUtil.getVideoLength(yt.getDuration()));
                        relatedDocumentss.add(yt);
                    }

                    userDocument.setKeywords(Joiner.on(",").join(keywords));
                    userDocument.setProfilingDone(true);
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
            String text = documentParserService.getWebContent("https://www.mkyong.com/java/apache-httpclient-examples/");
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
                if (cardKeyword.getStem().length() < 5) {
                    continue;
                }
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

    public String getWebContent(String url) throws Exception {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        request.addHeader("User-Agent", USER_AGENT);
        try {
            HttpResponse response = client.execute(request);
            return parseDocument(response.getEntity().getContent());
        } catch (Exception ex) {
            System.out.println("Failed to get web content for:" + url);
        }
        return null;
    }
}
