package com.huoy.service.inf;

import com.huoy.pojo.User;

import java.util.List;

public interface LoginService {
    List<User> findUser();

    int createUser(User user);

    User findByName(String username);
}
