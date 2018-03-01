package com.mic.project.al.repository;

import com.mic.project.al.model.RelatedDocuments;
import com.mic.project.al.model.UserDocuments;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by rchejerla on 01/03/18.
 */
public interface RelatedDocumentsRepository extends CrudRepository<RelatedDocuments, Long> {

    List<RelatedDocuments> findByoriginalDocId(long originalDocId);
}
