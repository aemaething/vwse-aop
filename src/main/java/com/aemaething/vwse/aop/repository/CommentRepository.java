package com.aemaething.vwse.aop.repository;

import com.aemaething.vwse.aop.entity.Comment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RepositoryRestResource(path = "comments")
public interface CommentRepository extends PagingAndSortingRepository<Comment, String> {
    @Override
    Optional<Comment> findById(String id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Comment c set c.cnt = c.cnt + 1 where c.id = :id")
    void incrementViewCounter(@Param("id") String id);
}