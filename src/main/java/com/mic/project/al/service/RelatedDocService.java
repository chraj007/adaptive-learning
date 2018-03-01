package com.mic.project.al.service;

import com.mic.project.al.model.RelatedDocuments;
import org.springframework.data.util.Pair;

import java.util.List;

/**
 * Created by rchejerla on 02/03/18.
 */
public interface RelatedDocService {

    Pair<List<RelatedDocuments>, List<RelatedDocuments>> findByUserName(String userName, long docId);
}
