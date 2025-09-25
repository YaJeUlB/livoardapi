package com.livoard.livoardapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("currentTime", java.time.LocalDateTime.now());
        model.addAttribute("message", "Thymeleaf가 정상 작동중입니다!");
        return "index";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello, Spring Boot API!";
    }
}