package com.mic.project.al.repository;

import com.mic.project.al.model.Questionnaire;
import com.mic.project.al.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by veena on 28/12/17.
 */
public interface QuesionaireRepository extends CrudRepository <Questionnaire, Long> {
    Questionnaire findByUserName(String userName);
}
