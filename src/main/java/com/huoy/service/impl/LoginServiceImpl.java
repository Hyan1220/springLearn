package com.huoy.service.impl;

import com.huoy.mapper.UserMapper;
import com.huoy.pojo.User;
import com.huoy.service.inf.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findUser() {
        return userMapper.findUser();
    }

    @Override
    public int createUser(User user) {
        return 0;
    }

    @Override
    public User findByName(String username) {
        return null;
    }
}
