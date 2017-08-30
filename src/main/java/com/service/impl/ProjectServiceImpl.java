package com.service.impl;

import com.dao.ProjectMapper;
import com.pojo.Project;
import com.pojo.Team;
import com.pojo.Userandteam;
import com.service.ProjectService;
import com.service.TeamService;
import com.service.UserandteamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return 1;
    }

    /**
     * 查询有多少个成员
     * @param
     * @return
     */
    public int selectCountPeople(){return 0 ;}

    public int deleteProject(int pId) {
        return 0;
    }

    public int updateProject(Project project) {
        return 0;
    }

    public List<Project> selectProject(Project project, int i) {
        return null;
    }
}
