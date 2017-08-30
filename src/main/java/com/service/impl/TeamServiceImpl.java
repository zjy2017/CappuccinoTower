package com.service.impl;

import com.dao.TeamMapper;
import com.pojo.Team;
import com.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by chen on 2017/8/29.
 */
@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamMapper teamMapper;
    public int addTeam(Team team) {
        teamMapper.insert(team);
        return team.getTId;
    }

    public int deleteTeam(int tId) {
        return 0;
    }

    public int updateTeam(Team team) {
        return 0;
    }

    public List<Team> selectTeam(Team team, int i) {
        return null;
    }
}
