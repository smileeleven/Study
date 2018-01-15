package com.aiboleepro.service.impl;

import com.aiboleepro.entity.User;
import com.aiboleepro.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author aiboleepro
 * @date 2018-01-12 下午5:49
 **/
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<User> findAllUser() {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUserById(String userId) {

    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public User findUserById(String userId) {
        return null;
    }
}
