package com.mic.project.al.service;

import com.mic.project.al.model.Questionnaire;
import com.mic.project.al.repository.QuesionaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuessionaireServiceImpl implements QuessionaireService {
    @Autowired
    private QuesionaireRepository quesionaireRepository;

    public Questionnaire findByUserName(String userName) {
        return quesionaireRepository.findByUserName(userName);
    }

    @Override
    public void save(Questionnaire questionnaireForm) {
        quesionaireRepository.save(questionnaireForm);
    }

}
