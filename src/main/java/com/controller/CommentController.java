package com.controller;

import com.pojo.Comment;
import com.pojo.User;
import com.service.CommentService;
import com.util.TimeGetTrans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


/**对评论表进行操作
 * Created by WU on 2017/9/4.
 */
@Controller
@RequestMapping(value = "Comment")
public class CommentController {
    //调用扩展类
    @Autowired
    CommentService commentService;

    //向评论表中新增数据
    @RequestMapping(value = "insert")
    //aa 是用来判断 是评论还是 回复
    public String insertComment(HttpServletRequest request, int aa,Model model){
        Comment comment=new Comment();
       //将评论内容存入到Comment
        comment.setcContent(request.getParameter("cContent"));

        //模拟从session中获取到数据包括 uId(用户ID) taskId（任务ID） uName(用户名字)
        comment.setuId(Integer.valueOf(request.getParameter("uId")));
        comment.setTaskId(Integer.valueOf(request.getParameter("taskId")));
        comment.setuName(request.getParameter("uName"));
        //如果是回复才进去,aa==1，评论时aa==0
        if(aa==1) {
            //通过回复点击 触发事件 返回被评论者的id 、姓名和评论ID
            comment.setBuUsername(request.getParameter("buUsername"));
            comment.setBuId(Integer.valueOf(request.getParameter("buId")));
            comment.setBcId(Integer.valueOf(request.getParameter("bCid")));
        }
        //将数据存入Comment数据库中
        int i = commentService.addComment(comment);

        if(i==1){
            //添加成功就跳进遍历Controllor进行重新遍历
            //自己编写URL
            model.addAttribute("taskid",request.getParameter("taskId"));
            return "redirect:queryComment";
        }
        return "comment/fail";
    }

    @RequestMapping(value = "queryComment",method = RequestMethod.GET)
    //前台要传过来一个任务ID 即 taskid
    public String queryComment(String taskid,HttpServletRequest request){
        Comment comment=new Comment();
        //将任务ID放到一个评论表中
        comment.setTaskId(Integer.valueOf(taskid));
        List<Comment> commentList = commentService.selectComment(comment, 0);
        if(commentList!=null&&commentList.size()!=0){
            HttpSession session = request.getSession();
            session.setAttribute("commentList",commentList);
            session.setAttribute("taskId",taskid);
            return "comment/querycomment";
        }
        return "comment/fail";
    }

    /**
     * 根据ID对要修改的评论进行查找
     * @param cid
     * @param request
     * @return
     */
    @RequestMapping(value = "selectCommentByID",method = RequestMethod.GET)
    public String selectCommentByID(String cid,HttpServletRequest request)
    {
        Comment comment=new Comment();
        //将页面得到的评论的ID 存入comment对象中
        comment.setcId(Integer.valueOf(cid));
        List<Comment> commentList = commentService.selectComment(comment, 1);
        if(commentList!=null&&commentList.size()!=0){
            //将返回的List存到对象中
            comment=commentList.get(0);
            request.getSession().setAttribute("comment",comment);
            return "comment/updatecommet";
        }
        return "comment/fail";
    }


    /**
     * 修改自己的评论
     * @param request
     * @return
     */
    @RequestMapping(value = "/updateComment")
    public String updateComment(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        //通过Session从页面中得到之前传到页面comment（是未修改的)
        Comment comment = (Comment) session.getAttribute("comment");
        //得到评论修改的内容就是 评论内容
        String cContent=request.getParameter("cContent");
        //将修改的内容放到对象中
        comment.setcContent(cContent);
        //调用update的方法
        int i = commentService.updateComment(comment);
        if (i==1){
            model.addAttribute("taskid",comment.getTaskId());
            return "redirect:queryComment";
        }
        return "comment/fail";
    }

    /**
     *根据ID删除
     * @param request
     * @return
     */
    @RequestMapping(value = "/deleteComment" , method = RequestMethod.GET)
    public String deleteComment(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();

        //根据ID进行删除
        int i = commentService.deleteComment(Integer.parseInt(request.getParameter("cid")));
        if(i==1)
        {
            model.addAttribute("taskid",session.getAttribute("taskId"));
            return "redirect:queryComment";
        }
        return "comment/fail";
    }
}
