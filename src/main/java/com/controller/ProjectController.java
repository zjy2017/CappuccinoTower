package com.controller;

import com.pojo.Project;
import com.pojo.User;
import com.service.ProjectService;
import com.service.UserService;
import com.util.ObtainSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by WU on 2017/8/29.
 * 项目表的增删改查
 */
@Controller
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    ProjectService projectService; //创建项目接口

    @Autowired
    UserService userService; //创建用户接口

    ObtainSession obtainSession =  new ObtainSession();
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
    public ModelAndView putProject(Project project, @RequestParam("uId") List<Integer> uId, HttpServletRequest request){
        // 判断在创建项目的时候是否选择了队员
        if (uId==null||uId.size()==0)
        {
            System.out.println("没有选择组员");
        }
        User user = obtainSession.getUser(request);
        // 将ID插入List数组,设置默认超管
        uId.add(user.getuId());

        // 调用实现类，插入项目数据
        projectService.addProject(project,uId);


        //　TODO [修改返回方式]
        // 将数据放到modelAndView
        String ProjectName=project.getpName();
        String ProjectDescribe=project.getpDescribe();
        ModelAndView modelAndView=new ModelAndView();
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
        // 模糊查询名字返回的List集合
        List<User> listUser=userService.listByUname(uName);
        ModelAndView modelAndView =new ModelAndView();
        // 将List放到ModelAndView中
        modelAndView.addObject("listUser",listUser);
        modelAndView.setViewName("project/afterselect");
        return modelAndView;
    }
}
