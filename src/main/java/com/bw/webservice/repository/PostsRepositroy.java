package com.bw.webservice.repository;

import com.bw.webservice.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface PostsRepositroy extends JpaRepository<Posts, Long> {
    @Query("SELECT p "+
            "FROM Posts p "+
            "ORDER BY p.id DESC")
    Stream<Posts> findAllDesc();
}
