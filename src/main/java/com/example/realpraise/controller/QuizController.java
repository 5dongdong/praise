package com.example.realpraise.controller;

import com.example.realpraise.entity.Quiz;
import com.example.realpraise.entity.QuizUser;
import com.example.realpraise.repository.QuizRepository;
import com.example.realpraise.repository.QuizUserRepository;
import com.example.realpraise.service.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@AllArgsConstructor
public class QuizController {

  private QuizService quizService;
  private QuizUserRepository quizUserRepository;

  @GetMapping("/quiz/{questionId}")
  public String quiz(@PathVariable Long questionId, Model model) {
    Quiz quiz = quizService.getQuizById(questionId);
    model.addAttribute("Quiz", quiz);
    return "/quiz";
  }

  @RequestMapping("/index")
  public String praise() {
    return "/index";
  }

  @RequestMapping("/test")
  public String test() {
    return "/test";
  }

  @RequestMapping("/login")
  public String login() {
    return "/login";
  }

  @PostMapping("/saveUserName")
  public String saveUserName(QuizUser user, RedirectAttributes redirectAttributes) {
    QuizUser savedUser = quizUserRepository.save(user);
    redirectAttributes.addAttribute("userId", savedUser.getUserId());
    return "redirect:/success-page/{userId}";
  }

  @GetMapping("/success-page/{userId}")
  public String showUserTest(@PathVariable Long userId, Model model) {
    QuizUser user = quizUserRepository.findById(userId).orElseThrow();
    model.addAttribute("user", user);
    return "success-page";
  }

}

