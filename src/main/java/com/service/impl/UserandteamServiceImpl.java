package com.service.impl;

import com.dao.UserandteamMapper;
import com.pojo.Userandteam;
import com.service.UserandteamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by WU on 2017/8/30.
 * 对应用户和团队的Service实现类
 * [UserandteamtMapper] [UserandteamService]
 */
@Service
public class UserandteamServiceImpl implements UserandteamService {
    // 注入UserandteamMapper依赖 [对数据库UserAndTeam表进行操作的Dao层]
    @Autowired
    UserandteamMapper userandteamMapper;

    /**
     * 往[UserandteamService] 表中添加一天新的数据
     * @param userandteam 用户和团队实体类
     * @return
     */
    public int addUserandteam(Userandteam userandteam) {
        userandteamMapper.insert(userandteam);
        return 1;
    }

    public int deleteUserandteam(int utId) {
        return 0;
    }

    public int updateUserandteam(Userandteam userandteam) {
        return 0;
    }

    public List<Userandteam> selectUserandteam(Userandteam userandteam, int i) {
        return null;
    }
}
