package com.example.realpraise.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UserResponses {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long responseId;

  @ManyToOne
  @JoinColumn(name = "userId")
  private QuizUser quizUser;

  @ManyToOne
  @JoinColumn(name = "quizId")
  private Quiz quiz;

  @ManyToOne
  @JoinColumn(name = "optionId")
  private Options options;
}
