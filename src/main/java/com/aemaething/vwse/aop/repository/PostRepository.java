package com.aemaething.vwse.aop.repository;

import com.aemaething.vwse.aop.entity.Post;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RepositoryRestResource(path = "posts")
public interface PostRepository extends PagingAndSortingRepository<Post, String> {
    @Override
    Optional<Post> findById(String id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Post p set p.cnt = p.cnt + 1 where p.id = :id")
    void incrementViewCounter(@Param("id") String id);
}