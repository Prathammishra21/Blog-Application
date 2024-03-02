package com.BlogApp.service;

import com.BlogApp.entity.User;

public interface UserService {

    public User saveUser(User user);

    public void removeSessionMessage();

}
