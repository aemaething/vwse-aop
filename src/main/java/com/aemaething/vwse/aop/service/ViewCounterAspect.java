package com.aemaething.vwse.aop.service;

import com.aemaething.vwse.aop.repository.CommentRepository;
import com.aemaething.vwse.aop.repository.PostRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ViewCounterAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ViewCounterAspect.class);

    private PostRepository postRepository;

    private CommentRepository commentRepository;


    public ViewCounterAspect(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @After("execution (* com.aemaething.vwse.aop.repository.PostRepository.findById(String))")
    public void incrementPostViewCounter(JoinPoint jp) {
        LOGGER.info("Incrementing view cnt of entity 'Post'", jp.getArgs()[0]);
        postRepository.incrementViewCounter(jp.getArgs()[0].toString());
        LOGGER.info("Completed update on 'Post'", jp.getArgs()[0]);
    }

    @After("execution (* com.aemaething.vwse.aop.repository.CommentRepository.findById(String))")
    public void incrementCommentViewCounter(JoinPoint jp) {
        LOGGER.info("Incrementing view cnt of entity 'Comment'", jp.getArgs()[0]);
        commentRepository.incrementViewCounter(jp.getArgs()[0].toString());
        LOGGER.info("Completed update on 'Comment'", jp.getArgs()[0]);
    }
}
