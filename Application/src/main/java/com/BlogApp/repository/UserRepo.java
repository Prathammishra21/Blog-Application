package com.BlogApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BlogApp.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

    public User findByEmail(String email);

}
