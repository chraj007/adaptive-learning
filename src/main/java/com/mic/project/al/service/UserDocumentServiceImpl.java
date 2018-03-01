package com.mic.project.al.service;

import com.mic.project.al.model.UserDocuments;
import com.mic.project.al.repository.UserDocumentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDocumentServiceImpl implements UserDocumentService {
    @Autowired
    private UserDocumentsRepository userDocumentsRepository;

    @Override
    public void save(UserDocuments userDocuments) {
        userDocumentsRepository.save(userDocuments);
    }

    @Override
    public List<UserDocuments> findByUserName(String username) {
        return userDocumentsRepository.findByUserName(username);

    }

    @Override
    public UserDocuments findOne(long id) {
        return userDocumentsRepository.findOne(id);
    }

    @Override
    public List<UserDocuments> findByProfilingDone(boolean profilingDone) {
        return userDocumentsRepository.findByProfilingDone(profilingDone);
    }
}
