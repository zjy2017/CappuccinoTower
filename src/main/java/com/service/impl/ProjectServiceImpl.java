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

    //注入ProjectMapper依赖 [对数据库Project表进行操作的Dao层]
    @Autowired
    ProjectMapper projectMapper;

    //注入TeamService依赖
    @Autowired
    TeamService teamService;

    //注入团队和用户依赖
    @Autowired
    UserandteamService userandteamService;


    /**
     * 创建一个新的项目
     * @param project 项目实体类
     * @return 若成功添加返回1,用户名称已存在返回0
     */

    public int addProject(Project project,List<Integer> uId) {
        //创建一个新的团队表
        Team team = new Team();
        team.settName(project.getpName());
        team.setIsgroup(0);
        //返回团队表的ID
        int tid = teamService.addTeam(team);
        //创建UserAndTeam表

        for(int i=0;i<uId.size();i++)
        {
            Userandteam userandteam = new Userandteam();
            // 判断是否创建项目者本身 是则设置为超管
            if (i==uId.size()-1) {
                userandteam.setType(1);
            }
            else {
                userandteam.setType(0);
            }
            userandteam.setuId(uId.get(i));
            userandteam.settId(tid);
            userandteamService.addUserandteam(userandteam);
        }
        // 得到团队id
        project.settId(tid);
        // 判断是否有sensitive
        if(project.getpSensitive()==null) {
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
