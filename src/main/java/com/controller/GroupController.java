package com.controller;

import com.pojo.Groupofteam;
import com.service.GroupService;
import com.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by WU on 2017/9/22.
 */
@Controller
@RequestMapping("/group")
public class GroupController {

   @Autowired
   GroupService groupService;
    /**
     * 根据tid查找分组名
     * @param tId
     * @param request
     * @return
     */
    @RequestMapping("/QueryGroupByTid")
    @ResponseBody
    public AjaxResult QueryGroupByTid(@RequestParam("tId")int tId, HttpServletRequest request){
        System.out.println("进入分组遍历----->");
        Groupofteam groupofteam=new Groupofteam();
        groupofteam.settId(tId);
        List<Groupofteam> groupList = groupService.selectGroup(groupofteam, 0);
        if (groupList!=null){
            return new AjaxResult(1,"查找分组名成功",groupList);
        }
        return new AjaxResult(0,"查找失败");
    }
}
