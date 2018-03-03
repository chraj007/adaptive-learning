package com.mic.project.al.service;

import com.mic.project.al.model.Questionnaire;

public interface QuessionaireService {

    Questionnaire findByUserName(String userName);

    void save(Questionnaire questionnaireForm, String userName);

}
