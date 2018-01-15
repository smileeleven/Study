package com.aiboleepro.service;

import com.aiboleepro.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户xml操作类
 *
 * @author aiboleepro
 * @date 2018-01-12 下午3:14
 **/
@Service
public interface UserService {

    /**
     * 查询所有用户
     *
     * @return List<User>
     */
    List<User> findAllUser();

    /**
     * 更新用户实体
     *
     * @param user 用户实体
     */
    void updateUser(User user);

    /**
     * 通过userId删除用户
     *
     * @param userId 用户id
     */
    void deleteUserById(String userId);

    /**
     * 添加一个用户
     *
     * @param user
     * */
    void addUser(User user);

    /**
     * 通过userId查找用户
     *
     * @param userId 用户id
     * @return User 用户
     */
    User findUserById(String userId);


}
