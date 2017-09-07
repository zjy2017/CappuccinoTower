package com.service.impl;

import com.dao.FileMapper;
import com.pojo.File;
import com.pojo.FileExample;
import com.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 2017/8/30.
 */
@Service
public class FileServiceImpl implements FileService {
    @Autowired
    FileMapper fileMapper;
    public int addFile(File file) {
        String path=file.getFileUrl();
        if(path!=null){
            fileMapper.insert(file);
            return 1;
        }else{
            return 0;
        }
    }

    public int deleteFile(int fileId) {
        if(fileId>=0){
            fileMapper.deleteByPrimaryKey(fileId);
            return 1;
        }else {
            return 0;
        }
    }

    public int updateFile(File file) {
        return 0;
    }

    public List<File> selectFile(String file, int fileId) {
        List<File> fileList =new ArrayList<File>();
        File file1 =null;
        //根据文件ID进行查询
        file1 = fileMapper.selectByPrimaryKey(fileId);
        fileList.add(file1);
        //若查询为空则返回null
        if(fileList == null || fileList.size() == 0){
            return null;
        }
        //否则返回这个list
        else{
            return fileList;
        }
    }

    public List<File> QueryList(){
        List<File> list=null;
        FileExample fileExample=new FileExample();
        fileExample.setDistinct(true);
        list=fileMapper.selectByExample(fileExample);
        return list;
    }

}
