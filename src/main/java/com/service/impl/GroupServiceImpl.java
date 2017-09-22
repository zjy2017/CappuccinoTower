package com.service.impl;

import com.dao.GroupofteamMapper;
import com.pojo.Groupofteam;
import com.pojo.GroupofteamExample;
import com.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WU on 2017/9/22.
 */
@Service
@Transactional
public class GroupServiceImpl implements GroupService {
    @Autowired
    GroupofteamMapper groupofteamMapper;



    public int addGroup(Groupofteam group) {
        return 0;
    }

    public int deleteGroup(int gId) {
        return 0;
    }

    public int updateGroup(Groupofteam group) {
        return 0;
    }


    /**
     *
     * @param group 分组实体类
     * @param gId 根据ID进行查询
     * @return
     */
    public List<Groupofteam> selectGroup(Groupofteam group, int gId) {
        System.out.println("进入分组Service---->");
       List<Groupofteam> groupList=new ArrayList<Groupofteam>();

       //gid为0时，则根据tid进行查找
       if(gId==0){
           GroupofteamExample groupofteamExample=new GroupofteamExample();
           groupofteamExample.createCriteria().andTIdEqualTo(group.gettId());
           groupList= groupofteamMapper.selectByExample(groupofteamExample);
           if (groupList!=null&&groupList.get(0).getgName()!=null){
               return groupList;
           }
       }

        return null;
    }
}
