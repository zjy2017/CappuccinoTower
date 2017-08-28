package com.dao;

import com.pojo.Folder;
import com.pojo.FolderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FolderMapper {

	/**
	 * 统计符合自定义条件的数据个数
	 *
	 * @param example [FolderExample]自定义条件
	 * @return [int]符合条件的数据个数
	 */
	int countByExample(FolderExample example);

	/**
	 * 自定义条件删除数据
	 *
	 * @param example [FolderExample]自定义条件
	 * @return [int]受影响行数
	 */
	int deleteByExample(FolderExample example);

	/**
	 * 根据主键删除单条数据
	 *
	 * @param folderId [Integer](主键属性)文件夹编号
	 * @return [int]受影响行数
	 */
	int deleteByPrimaryKey(@Param("folderId") Integer folderId);

	/**
	 * 插入单条数据
	 *
	 * @param record [Folder]待插入数据
	 * @return [int]受影响行数
	 */
	int insert(Folder record);

	/**
	 * 有选择的插入单条数据，只插入不为空的属性
	 *
	 * @param record [Folder]待插入数据
	 * @return [int]受影响行数
	 */
	int insertSelective(Folder record);

	/**
	 * 查询符合自定义条件的数据
	 *
	 * @param example [FolderExample]自定义条件
	 * @return [List<Folder>]符合自定义条件的数据
	 */
	List<Folder> selectByExample(FolderExample example);

	/**
	 * 根据主键查询单条数据
	 *
	 * @param folderId [Integer](主键属性)文件夹编号
	 * @return [Folder]查询结果
	 */
	Folder selectByPrimaryKey(@Param("folderId") Integer folderId);

	/**
	 * 自定义条件的有选择性的修改某些属性，只修改不为空的属性
	 *
	 * @param record [Folder]数据对象，用于指定修改属性
	 * @param example [FolderExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExampleSelective(@Param("record") Folder record, @Param("example") FolderExample example);

	/**
	 * 自定义条件修改所有属性
	 *
	 * @param record [Folder]数据对象，用于指定修改属性
	 * @param example [FolderExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExample(@Param("record") Folder record, @Param("example") FolderExample example);

	/**
	 * 通过主键有选择性的修改某该属性
	 *
	 * @param record [Folder]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKeySelective(Folder record);

	/**
	 * 通过主键修改所有属性
	 *
	 * @param record [Folder]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKey(Folder record);

}