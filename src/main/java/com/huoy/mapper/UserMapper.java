package com.huoy.mapper;

import com.huoy.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> findUser();

    User findByName(String username);

    int createUser(User user);
}
