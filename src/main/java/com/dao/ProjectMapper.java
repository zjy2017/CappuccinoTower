package com.dao;

import com.pojo.Project;
import com.pojo.ProjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectMapper {

	/**
	 * 统计符合自定义条件的数据个数
	 *
	 * @param example [ProjectExample]自定义条件
	 * @return [int]符合条件的数据个数
	 */
	int countByExample(ProjectExample example);

	/**
	 * 自定义条件删除数据
	 *
	 * @param example [ProjectExample]自定义条件
	 * @return [int]受影响行数
	 */
	int deleteByExample(ProjectExample example);

	/**
	 * 根据主键删除单条数据
	 *
	 * @param pId [Integer](主键属性)项目编号（主键）
	 * @return [int]受影响行数
	 */
	int deleteByPrimaryKey(@Param("pId") Integer pId);

	/**
	 * 插入单条数据
	 *
	 * @param record [Project]待插入数据
	 * @return [int]受影响行数
	 */
	int insert(Project record);

	/**
	 * 有选择的插入单条数据，只插入不为空的属性
	 *
	 * @param record [Project]待插入数据
	 * @return [int]受影响行数
	 */
	int insertSelective(Project record);

	/**
	 * 查询符合自定义条件的数据
	 *
	 * @param example [ProjectExample]自定义条件
	 * @return [List<Project>]符合自定义条件的数据
	 */
	List<Project> selectByExample(ProjectExample example);

	/**
	 * 根据主键查询单条数据
	 *
	 * @param pId [Integer](主键属性)项目编号（主键）
	 * @return [Project]查询结果
	 */
	Project selectByPrimaryKey(@Param("pId") Integer pId);

	/**
	 * 自定义条件的有选择性的修改某些属性，只修改不为空的属性
	 *
	 * @param record [Project]数据对象，用于指定修改属性
	 * @param example [ProjectExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExampleSelective(@Param("record") Project record, @Param("example") ProjectExample example);

	/**
	 * 自定义条件修改所有属性
	 *
	 * @param record [Project]数据对象，用于指定修改属性
	 * @param example [ProjectExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExample(@Param("record") Project record, @Param("example") ProjectExample example);

	/**
	 * 通过主键有选择性的修改某该属性
	 *
	 * @param record [Project]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKeySelective(Project record);

	/**
	 * 通过主键修改所有属性
	 *
	 * @param record [Project]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKey(Project record);

}