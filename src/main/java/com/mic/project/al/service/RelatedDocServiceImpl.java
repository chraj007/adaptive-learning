package com.mic.project.al.service;

import com.beust.jcommander.internal.Lists;
import com.mic.project.al.model.Questionnaire;
import com.mic.project.al.model.RelatedDocuments;
import com.mic.project.al.repository.QuesionaireRepository;
import com.mic.project.al.repository.RelatedDocumentsRepository;
import com.mic.project.al.repository.UserDocumentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Created by rchejerla on 02/03/18.
 */
@Service
public class RelatedDocServiceImpl implements RelatedDocService {
    @Autowired
    private RelatedDocumentsRepository relatedDocumentsRepository;
    @Autowired
    private QuesionaireRepository quesionaireRepository;

    @Override
    public Pair<List<RelatedDocuments>, List<RelatedDocuments>> findByUserName(String userName, long docId) {
        List<RelatedDocuments> byoriginalDocId = relatedDocumentsRepository.findByoriginalDocId(docId);
        List<RelatedDocuments> yts = Lists.newArrayList();
        List<RelatedDocuments> texts = Lists.newArrayList();

        Questionnaire byUserName = quesionaireRepository.findByUserName(userName);

        for (RelatedDocuments relatedDocuments : byoriginalDocId) {
            switch (byUserName.getLearningStyle()) {
                case "Activist":
                    relatedDocuments.setRank(getActivistRank(relatedDocuments));
                    break;
                case "Pragmatist":
                    relatedDocuments.setRank(getPragmatistRank(relatedDocuments));
                    break;
                case "Reflector":
                    relatedDocuments.setRank(getReflectorRank(relatedDocuments));
                    break;
                case "Theorist":
                    getTheoristRank(relatedDocuments);
                    relatedDocuments.setRank(getTheoristRank(relatedDocuments));
                    break;
            }

            if (relatedDocuments.getType().equalsIgnoreCase("yt")) {
                yts.add(relatedDocuments);
            } else {
                texts.add(relatedDocuments);
            }
        }
        Collections.sort(yts, RelatedDocuments.relatedDocumentsComparator);
        Collections.sort(texts, RelatedDocuments.relatedDocumentsComparator);

        return Pair.of(yts.subList(0, Math.min(9, yts.size())), texts.subList(0, Math.min(9, texts.size())));
    }

    private int getTheoristRank(RelatedDocuments relatedDocument) {
        int score = 0;
        switch (relatedDocument.getInteractivityLevel()) {
            case "Low":
                score += 100;
                break;
            case "Medium":
                score += 50;
                break;
            case "High":
                score += 0;
                break;
        }

        switch (relatedDocument.getDifficultyLevel()) {
            case "Low":
                score += 0;
                break;
            case "Medium":
                score += 50;
                break;
            case "High":
                score += 100;
                break;
        }

        switch (relatedDocument.getLength()) {
            case "TextShort":
                score += 0;
                break;
            case "TextMedium":
                score += 50;
                break;
            case "TextLong":
                score += 100;
                break;

            case "VideoShort":
                score += 25;
                break;
            case "VideoMedium":
                score += 100;
                break;
            case "VideoLong":
                score += 50;
                break;
        }

        return score;
    }

    private int getActivistRank(RelatedDocuments relatedDocument) {
        int score = 0;
        switch (relatedDocument.getInteractivityLevel()) {
            case "Low":
                score += 25;
                break;
            case "Medium":
                score += 100;
                break;
            case "High":
                score += 25;
                break;
        }

        switch (relatedDocument.getDifficultyLevel()) {
            case "Low":
                score += 25;
                break;
            case "Medium":
                score += 100;
                break;
            case "High":
                score += 25;
                break;
        }

        switch (relatedDocument.getLength()) {
            case "TextShort":
                score += 25;
                break;
            case "TextMedium":
                score += 100;
                break;
            case "TextLong":
                score += 25;
                break;


            case "VideoShort":
                score += 25;
                break;
            case "VideoMedium":
                score += 100;
                break;
            case "VideoLong":
                score += 25;
                break;
        }

        return score;
    }

    private int getPragmatistRank(RelatedDocuments relatedDocument) {
        int score = 0;
        switch (relatedDocument.getInteractivityLevel()) {
            case "Low":
                score += 75;
                break;
            case "Medium":
                score += 50;
                break;
            case "High":
                score += 25;
                break;
        }

        switch (relatedDocument.getDifficultyLevel()) {
            case "Low":
                score += 75;
                break;
            case "Medium":
                score += 50;
                break;
            case "High":
                score += 25;
                break;
        }

        switch (relatedDocument.getLength()) {
            case "TextShort":
                score += 75;
                break;
            case "TextMedium":
                score += 50;
                break;
            case "TextLong":
                score += 25;
                break;

            case "VideoShort":
                score += 75;
                break;
            case "VideoMedium":
                score += 50;
                break;
            case "VideoLong":
                score += 25;
                break;
        }

        return score;
    }

    private int getReflectorRank(RelatedDocuments relatedDocument) {
        int score = 0;
        switch (relatedDocument.getInteractivityLevel()) {
            case "Low":
                score += 50;
                break;
            case "Medium":
                score += 75;
                break;
            case "High":
                score += 25;
                break;
        }

        switch (relatedDocument.getDifficultyLevel()) {
            case "Low":
                score += 25;
                break;
            case "Medium":
                score += 100;
                break;
            case "High":
                score += 50;
                break;
        }

        switch (relatedDocument.getLength()) {
            case "TextShort":
                score += 25;
                break;
            case "TextMedium":
                score += 100;
                break;
            case "TextLong":
                score += 50;
                break;

            case "VideoShort":
                score += 25;
                break;
            case "VideoMedium":
                score += 100;
                break;
            case "VideoLong":
                score += 50;
                break;
        }

        return score;
    }
}
