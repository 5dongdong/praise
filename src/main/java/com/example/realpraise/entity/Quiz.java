package com.example.realpraise.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class Quiz {

  @Id
  @Column(name = "quizId")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long quizId;

  @Lob
  private String question;

  private int score;

  private int answer;

  @OneToMany(mappedBy = "quiz")
  private List<Options> options;
}
