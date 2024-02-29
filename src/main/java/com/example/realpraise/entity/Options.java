package com.example.realpraise.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Options {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long optionId;

  @ManyToOne
  @JoinColumn(name = "quizId")
  private Quiz quiz;


  private String optionContents;

  private boolean isCorrect;
}
