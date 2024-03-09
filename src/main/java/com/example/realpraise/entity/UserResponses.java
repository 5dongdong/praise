package com.example.realpraise.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class UserResponses {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long responseId;

  //응답자 ID
  @ManyToOne
  @JoinColumn(name = "userId")
  private QuizUser quizUser;

  //문제의 ID
  @ManyToOne
  @JoinColumn(name = "quizId")
  private Quiz quiz;

  //선택된 옵션
  @ManyToOne
  @JoinColumn(name = "optionId")
  private Options options;


  public UserResponses(String userId, Long questionId, Long selectedOptionId) {
  }
}

