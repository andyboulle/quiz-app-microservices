package com.boolhead.quizservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.boolhead.quizservice.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer> {

    

}
