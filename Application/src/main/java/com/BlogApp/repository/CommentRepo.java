package com.BlogApp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.BlogApp.entity.Comment;

public interface CommentRepo  extends JpaRepository<Comment	, Integer> {

}