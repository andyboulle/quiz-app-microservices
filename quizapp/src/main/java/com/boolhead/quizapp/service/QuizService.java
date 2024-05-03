package com.boolhead.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.boolhead.quizapp.dao.QuestionDao;
import com.boolhead.quizapp.dao.QuizDao;
import com.boolhead.quizapp.model.Question;
import com.boolhead.quizapp.model.QuestionWrapper;
import com.boolhead.quizapp.model.Quiz;
import com.boolhead.quizapp.model.Response;

@Service
public class QuizService {
    
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;


    public ResponseEntity<String> createQuiz(String category, int numQuestions, String title) {

        List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQuestions);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questionsFromDB = quiz.getQuestions();
        List<QuestionWrapper> questions = new ArrayList<QuestionWrapper>();

        for (Question question : questionsFromDB) {
            QuestionWrapper questionWrapper = new QuestionWrapper(question);
            questions.add(questionWrapper);
        }

        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(int id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int score = 0;

        for(int i = 0; i < questions.size(); i++) {
            Response response = responses.get(i);
            if(response.getResponse().equals(questions.get(i).getRightAnswer())) {
                score++;
            }
        }

        return new ResponseEntity<>(score, HttpStatus.OK);
    }
}
