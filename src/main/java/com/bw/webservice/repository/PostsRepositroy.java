package com.bw.webservice.repository;

import com.bw.webservice.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepositroy extends JpaRepository<Posts, Long> {
}
