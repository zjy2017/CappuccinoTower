package com.dao;

import com.pojo.File;
import com.pojo.FileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FileMapper {

	/**
	 * 统计符合自定义条件的数据个数
	 *
	 * @param example [FileExample]自定义条件
	 * @return [int]符合条件的数据个数
	 */
	int countByExample(FileExample example);

	/**
	 * 自定义条件删除数据
	 *
	 * @param example [FileExample]自定义条件
	 * @return [int]受影响行数
	 */
	int deleteByExample(FileExample example);

	/**
	 * 根据主键删除单条数据
	 *
	 * @param fileId [Integer](主键属性)文件编号
	 * @return [int]受影响行数
	 */
	int deleteByPrimaryKey(@Param("fileId") Integer fileId);

	/**
	 * 插入单条数据
	 *
	 * @param record [File]待插入数据
	 * @return [int]受影响行数
	 */
	int insert(File record);

	/**
	 * 有选择的插入单条数据，只插入不为空的属性
	 *
	 * @param record [File]待插入数据
	 * @return [int]受影响行数
	 */
	int insertSelective(File record);

	/**
	 * 查询符合自定义条件的数据
	 *
	 * @param example [FileExample]自定义条件
	 * @return [List<File>]符合自定义条件的数据
	 */
	List<File> selectByExample(FileExample example);

	/**
	 * 根据主键查询单条数据
	 *
	 * @param fileId [Integer](主键属性)文件编号
	 * @return [File]查询结果
	 */
	File selectByPrimaryKey(@Param("fileId") Integer fileId);

	/**
	 * 自定义条件的有选择性的修改某些属性，只修改不为空的属性
	 *
	 * @param record [File]数据对象，用于指定修改属性
	 * @param example [FileExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExampleSelective(@Param("record") File record, @Param("example") FileExample example);

	/**
	 * 自定义条件修改所有属性
	 *
	 * @param record [File]数据对象，用于指定修改属性
	 * @param example [FileExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExample(@Param("record") File record, @Param("example") FileExample example);

	/**
	 * 通过主键有选择性的修改某该属性
	 *
	 * @param record [File]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKeySelective(File record);

	/**
	 * 通过主键修改所有属性
	 *
	 * @param record [File]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKey(File record);

}