package com.mic.project.al.service;

import com.mic.project.al.model.UserDocuments;

import java.util.List;

public interface UserDocumentService {

    void save(UserDocuments userDocuments);

    List<UserDocuments> findByUserName(String username);

    UserDocuments findOne(long id);

    List<UserDocuments> findByProfilingDone(boolean profilingDone);
}
