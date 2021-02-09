package com.bw.webservice.controller;

import com.bw.webservice.domain.Posts;
import com.bw.webservice.dto.PostsMainResponseDto;
import com.bw.webservice.dto.PostsSaveRequestDto;
import com.bw.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class PostsController {

    private PostsService postsService;

    @GetMapping("/posts/new")
    public String createPosts(Model model) {
        model.addAttribute("form",new PostsSaveRequestDto());
        return"posts/postForm";
    }

    @PostMapping("/posts/new")
    public String savePosts(PostsSaveRequestDto form) {
        postsService.savePosts(form);
        return "redirect:/";
    }

    @GetMapping("/posts")
    public String list(Model model) {
        List<PostsMainResponseDto> posts = postsService.findAllDesc();
        model.addAttribute("posts", posts);
        return "/posts/postList";
    }

}
