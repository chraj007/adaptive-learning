package com.mic.project.al.repository;

import com.mic.project.al.model.UserDocuments;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by rchejerla on 11/02/18.
 */
public interface UserDocumentsRepository extends CrudRepository<UserDocuments, Long> {
    List<UserDocuments> findByUserName(String userName);
}
