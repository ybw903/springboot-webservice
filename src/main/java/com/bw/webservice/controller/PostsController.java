package com.bw.webservice.controller;

import com.bw.webservice.dto.PostsSaveRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostsController {

    @GetMapping("/posts/new")
    public String createTodo(Model model) {
        model.addAttribute("form",new PostsSaveRequestDto());
        return"posts/postForm";
    }

}
