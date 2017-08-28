package com.dao;

import com.pojo.Task;
import com.pojo.TaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskMapper {

	/**
	 * 统计符合自定义条件的数据个数
	 *
	 * @param example [TaskExample]自定义条件
	 * @return [int]符合条件的数据个数
	 */
	int countByExample(TaskExample example);

	/**
	 * 自定义条件删除数据
	 *
	 * @param example [TaskExample]自定义条件
	 * @return [int]受影响行数
	 */
	int deleteByExample(TaskExample example);

	/**
	 * 根据主键删除单条数据
	 *
	 * @param taskId [Integer](主键属性)任务编号（主键）
	 * @return [int]受影响行数
	 */
	int deleteByPrimaryKey(@Param("taskId") Integer taskId);

	/**
	 * 插入单条数据
	 *
	 * @param record [Task]待插入数据
	 * @return [int]受影响行数
	 */
	int insert(Task record);

	/**
	 * 有选择的插入单条数据，只插入不为空的属性
	 *
	 * @param record [Task]待插入数据
	 * @return [int]受影响行数
	 */
	int insertSelective(Task record);

	/**
	 * 查询符合自定义条件的数据
	 *
	 * @param example [TaskExample]自定义条件
	 * @return [List<Task>]符合自定义条件的数据
	 */
	List<Task> selectByExample(TaskExample example);

	/**
	 * 根据主键查询单条数据
	 *
	 * @param taskId [Integer](主键属性)任务编号（主键）
	 * @return [Task]查询结果
	 */
	Task selectByPrimaryKey(@Param("taskId") Integer taskId);

	/**
	 * 自定义条件的有选择性的修改某些属性，只修改不为空的属性
	 *
	 * @param record [Task]数据对象，用于指定修改属性
	 * @param example [TaskExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExampleSelective(@Param("record") Task record, @Param("example") TaskExample example);

	/**
	 * 自定义条件修改所有属性
	 *
	 * @param record [Task]数据对象，用于指定修改属性
	 * @param example [TaskExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExample(@Param("record") Task record, @Param("example") TaskExample example);

	/**
	 * 通过主键有选择性的修改某该属性
	 *
	 * @param record [Task]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKeySelective(Task record);

	/**
	 * 通过主键修改所有属性
	 *
	 * @param record [Task]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKey(Task record);

}