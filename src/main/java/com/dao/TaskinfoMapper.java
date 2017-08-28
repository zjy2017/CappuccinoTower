package com.dao;

import com.pojo.Taskinfo;
import com.pojo.TaskinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskinfoMapper {

	/**
	 * 统计符合自定义条件的数据个数
	 *
	 * @param example [TaskinfoExample]自定义条件
	 * @return [int]符合条件的数据个数
	 */
	int countByExample(TaskinfoExample example);

	/**
	 * 自定义条件删除数据
	 *
	 * @param example [TaskinfoExample]自定义条件
	 * @return [int]受影响行数
	 */
	int deleteByExample(TaskinfoExample example);

	/**
	 * 根据主键删除单条数据
	 *
	 * @param taskinfoId [Integer](主键属性)任务清单编号
	 * @return [int]受影响行数
	 */
	int deleteByPrimaryKey(@Param("taskinfoId") Integer taskinfoId);

	/**
	 * 插入单条数据
	 *
	 * @param record [Taskinfo]待插入数据
	 * @return [int]受影响行数
	 */
	int insert(Taskinfo record);

	/**
	 * 有选择的插入单条数据，只插入不为空的属性
	 *
	 * @param record [Taskinfo]待插入数据
	 * @return [int]受影响行数
	 */
	int insertSelective(Taskinfo record);

	/**
	 * 查询符合自定义条件的数据
	 *
	 * @param example [TaskinfoExample]自定义条件
	 * @return [List<Taskinfo>]符合自定义条件的数据
	 */
	List<Taskinfo> selectByExample(TaskinfoExample example);

	/**
	 * 根据主键查询单条数据
	 *
	 * @param taskinfoId [Integer](主键属性)任务清单编号
	 * @return [Taskinfo]查询结果
	 */
	Taskinfo selectByPrimaryKey(@Param("taskinfoId") Integer taskinfoId);

	/**
	 * 自定义条件的有选择性的修改某些属性，只修改不为空的属性
	 *
	 * @param record [Taskinfo]数据对象，用于指定修改属性
	 * @param example [TaskinfoExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExampleSelective(@Param("record") Taskinfo record, @Param("example") TaskinfoExample example);

	/**
	 * 自定义条件修改所有属性
	 *
	 * @param record [Taskinfo]数据对象，用于指定修改属性
	 * @param example [TaskinfoExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExample(@Param("record") Taskinfo record, @Param("example") TaskinfoExample example);

	/**
	 * 通过主键有选择性的修改某该属性
	 *
	 * @param record [Taskinfo]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKeySelective(Taskinfo record);

	/**
	 * 通过主键修改所有属性
	 *
	 * @param record [Taskinfo]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKey(Taskinfo record);

}