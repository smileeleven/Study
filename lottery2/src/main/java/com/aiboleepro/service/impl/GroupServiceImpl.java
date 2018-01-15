package com.aiboleepro.service.impl;

import com.aiboleepro.entity.Group;
import com.aiboleepro.entity.User;
import com.aiboleepro.service.GroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author aiboleepro
 * @date 2018-01-12 下午5:49
 **/
@Slf4j
@Service
public class GroupServiceImpl implements GroupService {

    @Override
    public void removeUserFromGroup(User user) {

    }

    @Override
    public void addUserToGroup(User user) {

    }

    @Override
    public List<User> findUsersByGroupId(String groupId) {
        return null;
    }

    @Override
    public List<Group> findAllGroup() {
        return null;
    }

    @Override
    public void updateGroup(Group group) {

    }

    @Override
    public void deleteGroupById(String groupId) {

    }

    @Override
    public void addGroup(Group group) {

    }

    @Override
    public Group findGroupById(String groupId) {
        return null;
    }
}
