package com.example.realpraise.service;

import com.example.realpraise.entity.Quiz;
import com.example.realpraise.repository.QuizRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@NoArgsConstructor
public class QuizService {

  private QuizRepository quizRepository;

  public Quiz getQuizById(Long quizId) {
    Optional<Quiz> quiz = quizRepository.findById(quizId);
    return quiz.orElseThrow(); //exception처리 해주기
  }

}
