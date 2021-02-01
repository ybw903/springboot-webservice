package com.bw.webservice.repository;

import com.bw.webservice.domain.Posts;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PostsRepositroyTest {

    @Autowired
    private PostsRepositroy postsRepositroy;

    @Test
    public void 게시글저장_불러오기() {
        //given
        postsRepositroy.save(Posts.builder()
                .title("테스트 게시글")
                .content("테스트 본문")
                .author("작성자")
                .build());

        //when
        List<Posts> postsList = postsRepositroy.findAll();

        //then
        Posts posts =postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo("테스트 게시글");
        assertThat(posts.getContent()).isEqualTo("테스트 본문");
        assertThat(posts.getAuthor()).isEqualTo("작성자");
    }

    @Test
    public void BaseTimeEntity_등록 () {
        //given
        LocalDateTime now = LocalDateTime.now();
        postsRepositroy.save(Posts.builder()
                .title("테스트 게시글")
                .content("테스트 본문")
                .author("작성자")
                .build());

        //when
        List<Posts> postsList = postsRepositroy.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getCreatedDate().isAfter(now));
        assertThat(posts.getModifiedDate().isAfter(now));
    }

}