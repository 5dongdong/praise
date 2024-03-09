package com.example.realpraise.controller;

import com.example.realpraise.entity.QuizUser;
import com.example.realpraise.repository.QuizUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
@AllArgsConstructor
public class QuizController {

  private QuizUserRepository quizUserRepository;


  @GetMapping("/quiz")
  public String quiz() {
    return "/quiz";
  }

  @RequestMapping("/index")
  public String praise() {
    return "/index";
  }


  @RequestMapping("/login")
  public String login() {
    return "/login";
  }

  @PostMapping("/saveUserName")
  public String saveUserName(QuizUser user, RedirectAttributes redirectAttributes) {
    QuizUser savedUser = quizUserRepository.save(user);
    redirectAttributes.addAttribute("userId", savedUser.getUserId());
    return "redirect:/quiz/{userId}";
  }


  @GetMapping("/quiz/{userId}")
  public String showUserTest(@PathVariable Long userId, Model model) {
    QuizUser user = quizUserRepository.findById(userId).orElseThrow();
    model.addAttribute("user", user);
    return "quiz";
  }



}

