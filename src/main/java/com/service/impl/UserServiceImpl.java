package com.service.impl;

import com.dao.UserMapper;
import com.dao.UserandteamMapper;
import com.pojo.Team;
import com.pojo.User;
import com.pojo.UserExample;
import com.pojo.Userandteam;
import com.service.TeamService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by BF on 2017/8/29.
 * 对应用户表的Service实现类
 * [UserMapper] [UserService]
 */
@Service
public class UserServiceImpl implements UserService {

    //注入UserMapper依赖 [对数据库User表进行操作的Dao层]
    @Autowired
    UserMapper userMapper;

    //注入UserandteamMapper依赖 [对数据库UserAandTeam表进行操作的Dao层]
    @Autowired
    UserandteamMapper userandteamMapper;

    @Autowired
    TeamService teamService;

    /**
     * 新增用户 [User],[Team],[UserAndTeam]
     * @param user 用户实体类
     * @param team 团队实体类
     * @return 若成功添加返回1,用户名称已存在返回0
     */
    public int addUser(User user, Team team) {
        // 判断用户名是否存在
        List<User> userList = selectUser(user, 1);
        // 若结果为空或者长度为0 则表示用户名不存在
        if (userList == null || userList.size() == 0) {
            // 创建[UserAndTeam]联袂关系实体类
            Userandteam userandteam = new Userandteam();
            // 是否存在小组默认为否
            if (team.getIsgroup()==null) {
                team.setIsgroup(0);
            }
            if (team.gettId() == null) {
                // 添加用户
                userMapper.insert(user);
                // 创建新的一个团队
                teamService.addTeam(team);
                // 设置成超级管理员
                userandteam.setType(1);
            }
            else{
                // 添加用户
                userMapper.insert(user);
                // 设置成普通用户
                userandteam.setType(0);
            }
            userandteam.setuId(user.getuId());     // [UserAndTeam]联袂关系实体类设置用户编号
            userandteam.settId(team.gettId());     // [UserAndTeam]联袂关系实体类设置团队编号
            userandteamMapper.insert(userandteam); // 往[UserAndTeam]联袂表插入一条信息
            return 1;
        }
        else {
            // 用户名已存在
            return 0;
        }

    }

    public int deleteUser(int uId) {
        userMapper.deleteByPrimaryKey(uId);
        return 0;
    }

    public int updateUser(User user) {
        userMapper.updateByPrimaryKey(user);
        return 1;
    }

    /**
     * 查找与选择 [User]
     * @param user 用户实体类
     * @param i    根据什么来查找（0代表ID，1代表用户名，2代表邮箱）
     * @return 若查询为空则判断返回空，查询不为空则返回
     */
    public List<User> selectUser(User user, int i) {
        List<User> userList = null;
        User user1 = null;
        //用ID主键进行查询
        if (i == 0) {
            user1 = userMapper.selectByPrimaryKey(i);
            userList.add(user1);
        }
        //用用户名查询
        else if (i == 1) {
            String uName = user.getuName();
            UserExample userExample = new UserExample();
            userExample.createCriteria().andUNameEqualTo(uName);
            userList = userMapper.selectByExample(userExample);
        }
        //用用户邮箱查询
        else if (i == 2) {
            String uEmail = user.getuEmail();
            UserExample userExample = new UserExample();
            userExample.createCriteria().andUEmailEqualTo(uEmail);
            userList = userMapper.selectByExample(userExample);
        }
        //若查询为空则返回null
        if (userList == null || userList.size() == 0) {
            return null;
        }
        //否则返回这个list
        else {
            return userList;
        }
    }
}
