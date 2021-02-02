package com.bw.webservice.service;

import com.bw.webservice.domain.Posts;
import com.bw.webservice.dto.PostsSaveRequestDto;
import com.bw.webservice.repository.PostsRepositroy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepositroy postsRepositroy;

    @Transactional
    public Long savePosts(PostsSaveRequestDto dto) {
        return postsRepositroy.save(dto.toEntity()).getId();
    }
}
