package com.bw.webservice.service;

import com.bw.webservice.domain.Posts;
import com.bw.webservice.dto.PostsMainResponseDto;
import com.bw.webservice.dto.PostsSaveRequestDto;
import com.bw.webservice.repository.PostsRepositroy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PostsServiceTest {

    @Autowired
    PostsService postsService;

    @Autowired
    PostsRepositroy postsRepositroy;

    @Test
    public void 게시글작성() {
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

    @Test
    public void 게시글ID내림차순조회() {
        //Given
        PostsSaveRequestDto dto1 = PostsSaveRequestDto.builder()
                .title("테스트 게시글1")
                .content("테스트 본문1")
                .author("작성자1")
                .build();
        PostsSaveRequestDto dto2 = PostsSaveRequestDto.builder()
                .title("테스트 게시글2")
                .content("테스트 본문2")
                .author("작성자2")
                .build();

        //When
        postsService.savePosts(dto1);
        postsService.savePosts(dto2);

        //Then
        List<PostsMainResponseDto> postsMainResponseDtos = postsService.findAllDesc();
        assertThat(postsMainResponseDtos.get(0).getId())
                .isGreaterThan(postsMainResponseDtos.get(1).getId());
    }
}