package com.mic.project.al.service;

import com.beust.jcommander.internal.Lists;
import com.mic.project.al.model.RelatedDocuments;
import com.mic.project.al.repository.RelatedDocumentsRepository;
import com.mic.project.al.repository.UserDocumentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rchejerla on 02/03/18.
 */
@Service
public class RelatedDocServiceImpl implements RelatedDocService {
    @Autowired
    private RelatedDocumentsRepository relatedDocumentsRepository;

    @Override
    public Pair<List<RelatedDocuments>, List<RelatedDocuments>> findByUserName(String userName, long docId) {
        List<RelatedDocuments> byoriginalDocId = relatedDocumentsRepository.findByoriginalDocId(docId);
        List<RelatedDocuments> yt = Lists.newArrayList();
        List<RelatedDocuments> text = Lists.newArrayList();
        for (RelatedDocuments relatedDocuments : byoriginalDocId) {
            if (relatedDocuments.getType().equalsIgnoreCase("yt")) {
                if (yt.size() >= 10) {
                    continue;
                }
                yt.add(relatedDocuments);
            } else {
                text.add(relatedDocuments);
                if (text.size() >= 10) {
                    continue;
                }
            }
        }
        return Pair.of(yt, text);
    }
}
