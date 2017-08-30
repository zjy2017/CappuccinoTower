package com.controller;

import com.pojo.Project;
import com.pojo.User;
import com.service.ProjectService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by WU on 2017/8/29.
 */
@Controller
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    ProjectService projectService; //创建项目接口

    @Autowired
    UserService userService; //创建用户接口
    /**
     * 跳转到输入项目信息界面
     * @return
     */
    @RequestMapping("/goCreateProject")
    public ModelAndView goCreateProject(){
        List<User> listUser=userService.QueryList();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("listUser",listUser);
        modelAndView.setViewName("project/putProject");
       return modelAndView;
    }

    /**
     * 向数据库插入信息
     * @param project
     * @return
     */
    @RequestMapping("/putProject")
    public ModelAndView putProject(Project project, @RequestParam("uId") int[] uId, Model model){
        //判断是否接收到checkbox 中 Uid的值
        String a = Arrays.toString(uId);
        model.addAttribute("uId", a);

        System.out.println();
        //从页面中接收 Project 数据
        String ProjectName=project.getpName();
        String ProjectDescribe=project.getpDescribe();

        //调用实现类，插入项目数据
        projectService.addProject(project);

        ModelAndView modelAndView=new ModelAndView();

        //将数据放到modelAndView
        modelAndView.addObject("ProjectName",ProjectName);
        modelAndView.addObject("ProjectDescribe",ProjectDescribe);

        modelAndView.setViewName("project/afterProject");
        return modelAndView;
    }

    /**
     * 按照模糊查询名字 进行名字选择组员
     * @param uName  用户姓名
     * @return
     */
    @RequestMapping("/selectName")
    public ModelAndView checkName(String uName)
    {
//        模糊查询名字返回的List集合
        List<User> listUser=userService.listByUname(uName);
        ModelAndView modelAndView =new ModelAndView();
//      将List放到ModelAndView中
        modelAndView.addObject("listUser",listUser);
        modelAndView.setViewName("project/afterselect");
        return modelAndView;
    }
}
