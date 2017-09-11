package com.controller;

import com.pojo.Project;
import com.pojo.User;
import com.service.ProjectService;
import com.service.UserService;
import com.util.AjaxResult;
import com.util.ObtainSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**对项目的操作
 * Created by WU on 2017/8/29.
 */
@Controller
@RequestMapping("/project")
@Transactional
public class ProjectController {
    // 注入项目服务依赖[ProjectService]
    @Autowired
    ProjectService projectService;

    //注入用户服务依赖[UserService]
    @Autowired
    UserService userService;
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
     * 新增项目
     * @param project
     * @return
     */
    @RequestMapping("/putProject")
    public ModelAndView putProject( Project project, @RequestParam("uId") List<Integer> uId,HttpServletRequest requestr){

        // 从页面中接收 Project 数据
        String ProjectName=project.getpName();
        String ProjectDescribe=project.getpDescribe();

        // 超级管理员ID
        int superId = new ObtainSession(requestr).getUser().getuId();
        uId.add(superId);

        //调用实现类，插入项目数据(返回项目)
        Project projectback = projectService.addProject(project, uId);

        requestr.getSession().setAttribute("project",projectback);
        //将数据放到modelAndView
        //向页面返回项目 ID ，，名字，，描述
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("pId",projectback.getpId());
        modelAndView.addObject("ProjectName",ProjectName);
        modelAndView.addObject("ProjectDescribe",ProjectDescribe);

        modelAndView.setViewName("project/afterProject");
        return modelAndView;
    }

    /**
     * 按照模糊查询名字 进行名字选择组员
     * @param
     * @return
     */
    @RequestMapping("/selectName")
    @ResponseBody
    public AjaxResult checkName(User user)
    {

        // 模糊查询名字返回的List集合
        List<User> listUser=userService.listByUname(user.getuName());
        ModelAndView modelAndView =new ModelAndView();
        // 将List放到ModelAndView中
        //将模糊查询到的List集合返回到页面中

        return new AjaxResult(1,"操作成功",listUser);
    }

    /**
     * 根据id查找修改项目对象
     * @param pId
     */
    @RequestMapping(value = "/selectProjectById",method = RequestMethod.GET)
    public String selectProjectById(String pId,HttpServletRequest request)
    {
        Project project=new Project();
        //将获取到的string 类型的 转化成 Int 类型
        int aa= Integer.parseInt(pId);
        project.setpId(aa);

        //调用select List
        //创建一个新的对象，用来接收返回的 List<Project>.get(0),因为根据ID只能查找到对象
        Project project1=new Project();
        //判断project是否为空
        if(project!=null) {
            List<Project> projectList = projectService.selectProject(project, 0);
            if (projectList==null||projectList.size()==1)
            {
                System.out.println("获得的list为空");
            }
            else {
                project1 = projectList.get(0);
                System.out.println(project1);
            }
        }
        //将根据ID查找到的对象放到session域中
        HttpSession session = request.getSession();
        session.setAttribute("project",project1);
        //跳转到修改页面
        return "project/updateProject";
    }


    /**
     * 修改项目信息
     * @param request
     * @return
     */
    @RequestMapping(value = "/updateProject")
    public String updateProject(HttpServletRequest request){
        HttpSession session=request.getSession();
        //将项目信息从页面的session中获取出来
        Project project = (Project) session.getAttribute("project");
        //将要修改的信息从JSP页面中获取
        //获取项目的名字
        String pName=request.getParameter("pName");
        //获取项目的描述
        String pDescribe=request.getParameter("pDescribe");
        //获取是否屏蔽敏感信息
        String qq=request.getParameter("pSensitive");
        int pSensitive=0;
        if(qq!=null){
            pSensitive=1;
        }
        //将要修改的信息放到Project中
        project.setpName(pName);
        project.setpDescribe(pDescribe);
        project.setpSensitive(pSensitive);

        //调用updatebyID的方法
        int i = projectService.updateProject(project);

        //判断是否成功
        if(i==1){
            System.out.println("修改成功");
        }
        return "project/success";
    }


    /**
     * 根据ID对项目进行删除
     * @return
     */
    @RequestMapping(value = "/deleteProject",method =RequestMethod.GET)
    public String deleteProject(HttpServletRequest request){
        // 定义操作返回值，默认为0 [失败的意思]
        int issuccess = 0;
        // 获取session中当前的项目信息
        Project project1 = (Project) request.getSession().getAttribute("project");
        System.out.println(project1.toString() + "打印的project");
        // 删除项目
        issuccess = projectService.deleteProject(project1);
        //判断是否成功
        if(issuccess==1){
            System.out.println("修改成功");
        }
        return "project/success";
    }


    /**
     *根据用户ID ，将其所参加的项目遍历出来
     * @param uId
     * @param request
     * @return
     */
    @RequestMapping(value = "/queryProjectByUserId" ,method = RequestMethod.GET)
    public String queryProjectByUserId(String uId,HttpServletRequest request){
        System.out.println("进入contollerlll");
        //将页面传来的用户ID变成int类型的
        int aa= Integer.parseInt(uId);
        List<Project> projectList = projectService.QueryList(aa);
        if(projectList!=null&&projectList.size()!=0){
            HttpSession session = request.getSession();
            session.setAttribute("projectList",projectList);
            return "project/querylist";
        }
        System.out.println("查找失败");
        return "project/success";
    }
}
