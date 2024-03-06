package com.example.realpraise.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class QuizUser {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long userId;

  private String userName;
}
