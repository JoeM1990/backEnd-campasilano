package com.monkilatech.backendcampasilano.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.monkilatech.backendcampasilano.model.Posts;

@Repository
public interface PostsRepo extends JpaRepository<Posts, Long> {
    @Query("FROM posts s WHERE s.id=:postsId")
    public Posts getPostById(@Param("postsId") long postsId);

}
