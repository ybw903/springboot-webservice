package com.bw.webservice.service;

import com.bw.webservice.domain.Posts;
import com.bw.webservice.dto.PostsSaveRequestDto;
import com.bw.webservice.repository.PostsRepositroy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PostsServiceTest {

    @Autowired
    PostsService postsService;

    @Autowired
    PostsRepositroy postsRepositroy;

    @Test
    public void 게시글작성(){
        //Given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .title("테스트 게시글")
                .content("테스트 본문")
                .author("작성자")
                .build();

        //When
        postsService.savePosts(dto);

        //Then
        Posts posts = postsRepositroy.findAll().get(0);
        assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(posts.getContent()).isEqualTo(dto.getContent());
        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());

    }
}