package com.mic.project.al.service;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.mic.project.al.model.Questionnaire;
import com.mic.project.al.repository.QuesionaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class QuessionaireServiceImpl implements QuessionaireService {
    @Autowired
    private QuesionaireRepository quesionaireRepository;

    public Questionnaire findByUserName(String userName) {
        return quesionaireRepository.findByUserName(userName);
    }

    @Override
    public void save(Questionnaire questionnaireForm, String userName) {

        int activistCount = questionnaireForm.getActivistCount();
        int pragmaCount = questionnaireForm.getPragmaCount();
        int reflectorCount = questionnaireForm.getReflectorCount();
        int theoristCount = questionnaireForm.getTheoristCount();
        ImmutableMap<Integer, String> immutableMap = ImmutableMap.of(activistCount, "Activist", pragmaCount, "Pragmatist", reflectorCount, "Reflector", theoristCount, "Theorist");
        Integer max = Collections.max(Lists.newArrayList(activistCount, pragmaCount, reflectorCount, theoristCount));
        questionnaireForm.setLearningStyle(immutableMap.get(max));
        quesionaireRepository.save(questionnaireForm);


    }

}
