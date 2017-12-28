package com.mic.project.al.service;

import com.mic.project.al.model.Questionnaire;

/**
 * Created by rchejerla on 28/12/17.
 */
public interface QuessionaireService {

    Questionnaire findByUserName(String userName);

    void save(Questionnaire questionnaireForm);

}
