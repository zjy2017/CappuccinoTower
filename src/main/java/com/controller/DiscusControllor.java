package com.controller;

import com.dto.AllObj;
import com.pojo.Comment;
import com.pojo.Discus;
import com.pojo.Project;
import com.service.CommentService;
import com.service.DiscusService;
import com.service.DynamicService;
import com.service.ProjectService;
import com.util.AjaxResult;
import com.util.ObtainSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**讨论表
 * Created by WU on 2017/9/15.
 */
@Controller
@RequestMapping("/discus")
public class DiscusControllor {
    // slf4j日志配置
    private static final Logger _LOG = LoggerFactory.getLogger(ProjectController.class);

    //注入项目Service
    @Autowired
    ProjectService projectService;
    //注入讨论Service
    @Autowired
    DiscusService discusService;
    //注入评论的Service
    @Autowired
    CommentService commentService;
    //注入动态的serv
    DynamicService dynamicService;


    /**
     * 新建讨论
     * @param pId
     * @param discus
     * @return
     */
    @RequestMapping(value ="/creatDiscus")
    @ResponseBody
    public AjaxResult creatDiscus(@RequestParam("pId")int pId, Discus discus, HttpServletRequest request){
        System.out.println("我进入了creatDiscus");
        System.out.println(new ObtainSession(request).getUser().getuId());
        //通过session取值将uid uName
        discus.setuId(new ObtainSession(request).getUser().getuId());
        discus.setuName(new ObtainSession(request).getUser().getuName());
        //将项目Id放入其中
        Project project=new Project();
        project.setpId(pId);
        List<Project> projectList = projectService.selectProject(project, 0);
        System.out.println(projectList.get(0)+"hhahhhhhhhh");
        if (projectList.get(0)!=null){
                Discus discus1 = discusService.addDiscus(discus, projectList.get(0));
                System.out.println(discus1+"11111111111111");
                return new AjaxResult(1,"成功",discus1);
            }else {
                return new AjaxResult(0,"badness");
        }
    }

    /**
     * 遍历该项目中所有的讨论
     * @return
     */
    @RequestMapping(value = "/QueryDiscus")
    @ResponseBody
    public AjaxResult QueryDiscus(@RequestParam("pId")int pId){
        System.out.println("进入了query");
        List<Discus> discusList = discusService.QueryDiscus(pId);
        if (discusList!=null){
            System.out.println("query到这里了");
            for(int i=0;i<discusList.size();i++){
                System.out.println(discusList.get(i));
            }
            return new AjaxResult(1,"成功",discusList);
        }else {
            return new AjaxResult(0,"失败");
        }
    }

    /**
     * 根据讨论ID查找内容
     * @param discusId
     * @return
     */
    @RequestMapping("/selectDiscusByDid")
    @ResponseBody
    public AjaxResult selectDiscusByDid(@RequestParam("discusId")int discusId,HttpServletRequest request){
        Discus discus=new Discus();
        discus.setDiscusId(discusId);
        Comment comment=new Comment();
        comment.setDiscusId(discusId);
        List<Discus> discusList = discusService.select(discus, 0);
        List<Comment> commentList=commentService.selectComment(comment,2);
        if(discusList!=null&&commentList!=null){
            discus=discusList.get(0);
            request.getSession().setAttribute("discus",discus);
            return new AjaxResult(1,"成功",discus,commentList);
        }
        return new AjaxResult(0,"失败");
    }

    @RequestMapping(value = "hyperlink")
    @ResponseBody
    public AjaxResult hyperlink(@RequestParam("operateId")int operateId,@RequestParam("table")String table){
        List<AllObj> allObjList = dynamicService.selectObj(operateId, table);
        if(allObjList!=null||allObjList.size()!=0){
            return new AjaxResult(1,"查询对象成功",allObjList.get(0));
        }
        return null;
    }
}
