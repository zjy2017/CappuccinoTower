package com.service.impl;

import com.dao.UserMapper;
import com.pojo.Team;
import com.pojo.User;
import com.pojo.UserExample;
import com.service.TeamService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by BF on 2017/8/29.
 * 对应用户表的Service实现类
 * [UserMapper] [UserService]
 */
@Service
public class UserServiceImpl implements UserService {

    //注入UserMapper依赖 [对数据库进行操作的Dao层]
    @Autowired
    UserMapper userMapper;

    @Autowired
    TeamService teamService;

    public int addUser(User user, Team team) {
        List<User> userList = null;
        String uName = user.getUName();
        //创建Example对象，使用createCtiteria方法以uName查询数据库
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUNameEqualTo(uName);
        //userList接受查询结果
        userList = userMapper.selectByExample(userExample);
        //若结果为空或者长度为0
        if (userList==null||userList.size()==0)
        {
            //添加用户
            userMapper.insert(user);
            //是否存在小组默认为否
            team.setIsgroup(0);
            //将团队名加入
            teamService.addTeam(team);
            return 1;
        }
        else {
            return 0;
        }

    }

    public int addUser(User user) {
        List<User> userList = null;
        String uName = user.getUName();
        //创建Example对象，使用createCtiteria方法以uName查询数据库
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUEmailEqualTo(uName);
        //userList接受查询结果
        userList = userMapper.selectByExample(userExample);
        if(userList==null||userList.size()==0)
        {
            //添加用户
            userMapper.insert(user);
            return 1;
        }
        return 0;
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
     * @param i 根据什么来查找（0代表ID，1代表用户名，2代表邮箱）
     * @return 若查询为空则判断返回空，查询不为空则返回
     */
    public List<User> selectUser(User user, int i) {
        List<User> userList = null;
        User user1 = null;
        //用ID主键进行查询
        if (i==0)
        {
             user1 = userMapper.selectByPrimaryKey(i);
             userList.add(user1);
        }
        //用用户名查询
        else if (i==1)
        {
            String uName = user.getUName();
            UserExample userExample = new UserExample();
            userExample.createCriteria().andUNameEqualTo(uName);
            userList = userMapper.selectByExample(userExample);
        }
        //用用户邮箱查询
        else if (i==2)
        {
            String uEmail = user.getUEmail();
            UserExample userExample = new UserExample();
            userExample.createCriteria().andUEmailEqualTo(uEmail);
            userList = userMapper.selectByExample(userExample);
        }
        //若查询为空则返回null
        if (userList==null||userList.size()==0)
        {
            return null;
        }
        //否则返回这个list
        else {
            return userList;
        }
    }
}
