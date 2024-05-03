package com.boolhead.quizservice.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boolhead.quizservice.model.QuestionWrapper;
import com.boolhead.quizservice.model.Response;

@FeignClient(name = "QUESTION-SERVICE")
public interface QuizInterface {
    
    @GetMapping("question/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category, @RequestParam int numQuestions);

    @PostMapping("question/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromIds(List<Integer> questionIds);
    
    @PostMapping("question/getScore")
    public ResponseEntity<Integer> getScore(List<Response> responses);

}
