package com.util;

import com.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by BF on 2017/9/1.
 * 获取页面Session工具类
 */
public class ObtainSession {

    private HttpServletRequest request;

    // [User实体类]  从Session中获取的User
    private User user;

    private HttpSession session;
    // 新的构造器
    public ObtainSession(HttpServletRequest request) {
        this.request = request;
    }
    // 将默认构造方法隐藏起来
    private ObtainSession(){}

    public  User getUser()
    {
        this.session = request.getSession();
        user = (User) session.getAttribute("user");
        return this.user;
    }
}
