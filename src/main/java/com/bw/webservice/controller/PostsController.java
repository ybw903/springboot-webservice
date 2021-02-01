package com.bw.webservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostsController {

    @GetMapping("/posts/new")
    public String createTodo(Model model) {
        model.addAttribute("form",new PostForm());
        return"posts/postForm";
    }
}
