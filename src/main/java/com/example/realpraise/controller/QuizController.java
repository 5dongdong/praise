package com.example.realpraise.controller;

import com.example.realpraise.entity.Quiz;
import com.example.realpraise.service.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class QuizController {

  private QuizService quizService;

  @GetMapping("/quiz/{questionId}")
  public String quiz(@PathVariable Long questionId, Model model) {
    Quiz quiz = quizService.getQuizById(questionId);
    model.addAttribute("Quiz", quiz);
    return "quiz";
  }

  @RequestMapping("/praise")
  public String praise() {
    return "/praise";
  }

  @RequestMapping("/test")
  public String test() {
    return "/test";
  }

  @RequestMapping("/donghyeon")
  public String donghyeon() {
    return "/donghyeon";
  }

  @RequestMapping("/login")
  public String login() {
    return "/login";
  }
}

