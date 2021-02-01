package com.bw.webservice.service;

import com.bw.webservice.repository.PostsRepositroy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepositroy postsRepositroy;
}
