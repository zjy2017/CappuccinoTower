package com.service.impl;

import com.dao.TaskMapper;
import com.dao.TaskinfoMapper;
import com.pojo.Task;
import com.pojo.TaskExample;
import com.pojo.Taskinfo;
import com.pojo.TaskinfoExample;
import com.service.TaskService;
import com.service.TaskinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 2017/9/5.
 */
@Service
public class TaskinfoServiceImpl implements TaskinfoService{
    @Autowired
    TaskinfoMapper taskinfoMapper;

    @Autowired
    TaskMapper taskMapper;
    public int addTaskinfo(Taskinfo taskinfo) {
        taskinfo.setpId(1);
        taskinfoMapper.insert(taskinfo);
        return taskinfo.getTaskinfoId();
    }

    public int deleteTaskinfo(int taskinfoId) {
        //将要删除的taskinfoid传入进来
        TaskExample taskExample=new TaskExample();
        taskExample.createCriteria().andTaskinfoIdEqualTo(taskinfoId);
        List<Task> taskList = taskMapper.selectByExample(taskExample);
        for(int i=0;i<taskList.size();i++){
            taskMapper.deleteByPrimaryKey(taskList.get(i).getTaskId());
            System.out.println("任务表相关联的");
        }
        int i = taskinfoMapper.deleteByPrimaryKey(taskinfoId);
        if(i>0){
            return 1;
        }else {
            return 0;
        }
    }

    public int updateTaskinfo(Taskinfo taskinfo) {
        int i=taskinfoMapper.updateByPrimaryKeyWithBLOBs(taskinfo);
        if(i>0){
            return 1;
        }else{
            return 0;
        }
    }

    public List<Taskinfo> selectTaskinfo(Taskinfo taskinfo, int i) {
        List<Taskinfo> taskinfoList = new ArrayList<Taskinfo>();
       if(i==0){
           Taskinfo taskinfo1 = taskinfoMapper.selectByPrimaryKey(taskinfo.getTaskinfoId());
           taskinfoList.add(taskinfo1);
           if(taskinfoList!=null&&taskinfoList.get(0).getTaskinfoName()!=null){
               return taskinfoList;
           }
       }
       return null;
    }

    public List<Taskinfo> QueryList() {
        TaskinfoExample taskinfoExample = new TaskinfoExample();
        taskinfoExample.setDistinct(true);
        System.out.println("111111111111111111111111111111111111111111111111111111111111111111111111111111111");
        List<Taskinfo> list = taskinfoMapper.selectByExample(taskinfoExample);
        return list;
    }
}
