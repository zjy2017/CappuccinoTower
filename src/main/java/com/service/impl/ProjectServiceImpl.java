package com.service.impl;

import com.dao.ProjectMapper;
import com.pojo.Project;
import com.pojo.ProjectExample;
import com.pojo.Team;
import com.pojo.Userandteam;
import com.service.ProjectService;
import com.service.TeamService;
import com.service.UserandteamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WU on 2017/8/29.
 * 对应项目表的Service实现类
 * [ProjectMapper] [ProjectService]
 */
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    //创建项目类的Mapper
    @Autowired
    ProjectMapper projectMapper;

    //创建团队的Service
    @Autowired
    TeamService teamService;

    //创建团队和用户的Service
    @Autowired
    UserandteamService userandteamService;


    /**
     * 创建一个新的项目
     * @param project 项目实体类
     * @return
     */

    public int addProject(Project project,Integer[] uId) {
        //创建一个新的团队表
        Team team = new Team();
        team.settName(project.getpName());
        team.setIsgroup(0);
        //返回团队表的ID
        int tid = teamService.addTeam(team);
        //创建UserAndTeam表
        // TODO
        for(int i=0;i<uId.length;i++)
        {
            Userandteam userandteam=new Userandteam();
            userandteam.setuId(uId[i]);
            userandteam.settId(tid);

            //这里以后要判断是否是项目项目创建者
            //默认为0，为组员
            userandteam.setType(0);
            userandteamService.addUserandteam(userandteam);
        }

        //得到团队id
        project.settId(tid);
        //判断是否有sensitive
        if(project.getpSensitive()==null)
        {
            project.setpSensitive(0);
        }

        projectMapper.insert(project);
        return project.getpId();
    }

    /**
     * 查询有多少个成员
     * @param
     * @return
     */
    public int selectCountPeople(){return 0 ;}


    /**
     * 根据ID进行删除
     * @param pId 根据什么来删除 （0代表ID，1代表项目名）
     * @return
     */
    public int deleteProject(int pId) {
        projectMapper.deleteByPrimaryKey(pId);
        return 1;
    }


    /**
     * 修改项目信息
     * @param project 项目实体类
     * @return
     */
    public int updateProject(Project project) {
        //Mybatis会默认为text类型的自动生成 withBlOBs 来对 数据库进行修改
        projectMapper.updateByPrimaryKeyWithBLOBs(project);
        return 1;
    }



    /**
     * 查找与选择[Project]
     *
     * @param project 项目实体类
     * @param i 根据什么来查找 （0代表ID，1代表项目名）
     * @return
     */
    public List<Project> selectProject(Project project, int i) {
        List<Project> projectList=new ArrayList<Project>();
        Project project1=null;
        //用ID主键进行查询
        if(i==0){
            project1=projectMapper.selectByPrimaryKey(project.getpId());
            System.out.println(project1.toString()+"aaa-----------------");
            projectList.add(project1);
            for (int a = 0;a<projectList.size();a++)
            {
                System.out.println(projectList.get(a).toString()+"b--------------");
            }

        }
        //若查询为空则返回null
        if (projectList == null || projectList.size() == 0) {
            System.out.println("返回了空");
            return null;
        }
        //否则返回这个list
        else {
            return projectList;
        }
    }

    /**
     * 对根据用户ID 对项目表进行遍历
     * @return
     */
    public List<Project> QueryList(int uId) {
        ProjectExample projectExample=new ProjectExample();
        //调用对遍历出的对象进行查重
        projectExample.setDistinct(true);

        return null;
    }

}
