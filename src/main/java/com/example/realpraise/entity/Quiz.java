package com.example.realpraise.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Quiz {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long quizId;
  private String question;

  private int score;
  private int answer;
}
