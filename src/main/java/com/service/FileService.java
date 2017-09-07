package com.service;

import com.pojo.File;

import java.util.List;

/**
 * Created by WU on 2017/8/29.
 * 对应 文件表
 */
public interface FileService {

    /**
     * 新增一个文件
     * @param file 文件的实体类
     * @return 返回0表示失败，返回1表示成功
     */
    int addFile(File file);


    /**
     * 删除一个文件
     * @param fileId 根据文件ID进行删除
     * @return 返回0表示失败，返回1表示成功
     */
    int deleteFile(int fileId);

    /**
     * 修改一个文件
     * @param file 文件实体类
     * @return 返回0表示失败，返回1表示成功
     */
    int updateFile(File file);


    /**
     * 查询一个文件
     * @param file 文件实体类
     * @param fileId 根据文件ID进行查找
     * @return
     */
    List<File> selectFile(File file,int fileId);
}
