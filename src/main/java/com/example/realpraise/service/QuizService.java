package com.example.realpraise.service;

import com.example.realpraise.entity.Options;
import com.example.realpraise.entity.QuizUser;
import com.example.realpraise.entity.UserResponses;
import com.example.realpraise.repository.OptionRepository;
import com.example.realpraise.repository.QuizRepository;
import com.example.realpraise.repository.QuizUserRepository;
import com.example.realpraise.repository.UserResponsesRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
@NoArgsConstructor
public class QuizService {

  private QuizRepository quizRepository;
  private QuizUserRepository quizUserRepository;

  private OptionRepository optionRepository;

  private UserResponsesRepository userResponsesRepository;


  public void processUserResponses(Map<Long, Long> responses, String userId) {
    int score = 0;
    for (Map.Entry<Long, Long> entry : responses.entrySet()) {
      Long questionId = entry.getKey();
      Long selectedOptionId = entry.getValue();
      Options option = optionRepository.findById(selectedOptionId).orElseThrow();
      if (option.isCorrect()) {
        score += 20; // 각 정답당 점수
      }
      // 사용자 응답 저장 로직
      UserResponses response = new UserResponses(userId, questionId, selectedOptionId);
      userResponsesRepository.save(response);
    }
    // 사용자 점수 업데이트 로직
    updateOrCreateUserScore(userId, score);
  }

  private void updateOrCreateUserScore(String userId, int score) {
    QuizUser userScore = quizUserRepository.findByUserId(userId)
            .orElse(new QuizUser(userId, 0));
    userScore.setUserScore(userScore.getUserScore() + score);
    quizUserRepository.save(userScore);
  }

}
