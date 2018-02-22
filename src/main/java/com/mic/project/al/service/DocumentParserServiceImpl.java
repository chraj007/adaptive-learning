package com.mic.project.al.service;

import com.mic.project.al.service.keyword.CardKeyword;
import com.mic.project.al.service.keyword.KeywordsExtractor;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.BodyContentHandler;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

public class DocumentParserServiceImpl implements DocumentParserService {
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
}
