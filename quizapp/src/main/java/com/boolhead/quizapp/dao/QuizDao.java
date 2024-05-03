package com.boolhead.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.boolhead.quizapp.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer> {

    

}
