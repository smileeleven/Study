package com.aiboleepro.service;

import com.aiboleepro.entity.Group;
import com.aiboleepro.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 小组xml操作类
 *
 * @author aiboleepro
 * @date 2018-01-12 下午3:57
 **/
@Service
public interface GroupService {

    /**
     * 移除小组内成员
     *
     * @param user
     */
    void removeUserFromGroup(User user);

    /**
     * 小组内添加成员
     *
     * @param user 用户实体
     */
    void addUserToGroup(User user);

    /**
     * 返回小组内所有成员
     *
     * @param groupId
     * @return List<User>
     */
    List<User> findUsersByGroupId(String groupId);

    /**
     * 查询所有小组
     */
    List<Group> findAllGroup();

    /**
     * 更新小组信息
     *
     * @param group
     */
    void updateGroup(Group group);

    /**
     * 删除小组
     *
     * @param groupId 小组编号
     */
    void deleteGroupById(String groupId);

    /**
     * 添加小组
     *
     * @param group
     */
    void addGroup(Group group);

    /**
     * 通过组Id找到组
     *
     * @param groupId 小组编号
     * @return Group
     */
    Group findGroupById(String groupId);

}
