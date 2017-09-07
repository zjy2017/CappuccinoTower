package com.controller;

import com.pojo.Taskinfo;
import com.service.TaskinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by chen on 2017/9/5.
 */
@Controller
@Transactional
@RequestMapping(value = "TaskInfo")
public class TaskinfoController {
    @Autowired
    private TaskinfoService taskinfoService;

    /**
     * 新增任务清单
     * @param taskinfo
     * @param request
     * @return
     */
    @RequestMapping(value = "addTaskInfo")
    public String addTaskInfo(Taskinfo taskinfo, HttpServletRequest request){
        //调用addTaskinfo方法
        System.out.println(taskinfo+"______________________________");
        int TaskinfoId = taskinfoService.addTaskinfo(taskinfo);
        System.out.println(TaskinfoId+"____________________________");
        //将刚创建的任务清单对象存入session中
        request.getSession().setAttribute("TaskinfoId",TaskinfoId);
        if(TaskinfoId!=0){
            return "task/createTask";
        }else{
            return "AllFail";
        }
    }

    /**
     * 任务清单创建后的信息显示
     * @param taskinfo
     * @param taskinfoid
     * @param request
     * @return
     */
    @RequestMapping(value = "TaskInfoinformation",method = RequestMethod.GET)
    public String TaskInfoinformation(Taskinfo taskinfo,String taskinfoid,HttpServletRequest request){
        HttpSession session = request.getSession();
        //得到前台传入的taskinfoid
        taskinfo.setTaskinfoId(Integer.valueOf(taskinfoid));
        //调用selectTeskinfo方法
        List<Taskinfo> taskinfoList = taskinfoService.selectTaskinfo(taskinfo, 0);
        //若List不为空，则取出List中第一个元素，存入session中
        if (taskinfoList != null) {
            Taskinfo taskinfo1 = taskinfoList.get(0);
            request.getSession().setAttribute("taskinfo1", taskinfo1);
            return "TaskInfo/TaskInfoinformation";
        } else {//若为空，则返回AllFail页面
            return "AllFail";
        }
    }

    /**
     * 更新任务清单信息
     * @param taskinfo
     * @param taskinfoId
     * @param request
     * @return
     */
    @RequestMapping(value = "updateTaskInfo",method = RequestMethod.POST)
    public String updateTaskInfo(Taskinfo taskinfo,String taskinfoId,HttpServletRequest request){
        HttpSession session = request.getSession();
        //将修改的数据取出
        String taskinfoName=request.getParameter("taskinfoName");
        String takinfoDescribe=request.getParameter("takinfoDescribe");
        taskinfo = (Taskinfo) request.getSession().getAttribute("taskinfo1");
        //存入对象中
        taskinfo.setTaskinfoName(taskinfoName);
        taskinfo.setTakinfoDescribe(takinfoDescribe);
        //调用
        int i=taskinfoService.updateTaskinfo(taskinfo);
        System.out.println(taskinfo+"!!!!!!!!!!!!!!");
        session.setAttribute("TaskinfoId",taskinfo.getTaskinfoId());
        if(i==1){
            System.out.println("更新成功");
            return "AllSuccess";
        }else if(i==0){
            System.out.println("更新失败");
            return "AllFail";
        }
        return null;
    }

    /**
     * 任务清单列表
     * @param request
     * @return
     */
    @RequestMapping(value = "taskInfoList")
    public String TaskInfoList (HttpServletRequest request){
        //调用querylist方法将所有任务清单取出
        List<Taskinfo> taskinfoList = taskinfoService.QueryList();
        //存入session中，返回页面
        request.getSession().setAttribute("taskinfoList",taskinfoList);
        return "TaskInfo/TaskinfoList";
    }

    /**
     * 删除任务清单
     * @param taskinfoid
     * @return
     */
    @RequestMapping(value = "deleteTaskInfo")
    public String deleteTaskInfo(String taskinfoid){
        //调用deleteteskinfo方法根据页面传回的id删除任务清单
        int i = taskinfoService.deleteTaskinfo(Integer.parseInt(taskinfoid));
        if(i==1){
            return "redirect:taskInfoList";
        }else{
            return "AllFail";
        }
    }
}
