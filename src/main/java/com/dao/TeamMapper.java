package com.dao;

import com.pojo.Team;
import com.pojo.TeamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeamMapper {

	/**
	 * 统计符合自定义条件的数据个数
	 *
	 * @param example [TeamExample]自定义条件
	 * @return [int]符合条件的数据个数
	 */
	int countByExample(TeamExample example);

	/**
	 * 自定义条件删除数据
	 *
	 * @param example [TeamExample]自定义条件
	 * @return [int]受影响行数
	 */
	int deleteByExample(TeamExample example);

	/**
	 * 根据主键删除单条数据
	 *
	 * @param tId [Integer](主键属性)团队编号（主键）
	 * @return [int]受影响行数
	 */
	int deleteByPrimaryKey(@Param("tId") Integer tId);

	/**
	 * 插入单条数据
	 *
	 * @param record [Team]待插入数据
	 * @return [int]受影响行数
	 */
	int insert(Team record);

	/**
	 * 有选择的插入单条数据，只插入不为空的属性
	 *
	 * @param record [Team]待插入数据
	 * @return [int]受影响行数
	 */
	int insertSelective(Team record);

	/**
	 * 查询符合自定义条件的数据
	 *
	 * @param example [TeamExample]自定义条件
	 * @return [List<Team>]符合自定义条件的数据
	 */
	List<Team> selectByExample(TeamExample example);

	/**
	 * 根据主键查询单条数据
	 *
	 * @param tId [Integer](主键属性)团队编号（主键）
	 * @return [Team]查询结果
	 */
	Team selectByPrimaryKey(@Param("tId") Integer tId);

	/**
	 * 自定义条件的有选择性的修改某些属性，只修改不为空的属性
	 *
	 * @param record [Team]数据对象，用于指定修改属性
	 * @param example [TeamExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExampleSelective(@Param("record") Team record, @Param("example") TeamExample example);

	/**
	 * 自定义条件修改所有属性
	 *
	 * @param record [Team]数据对象，用于指定修改属性
	 * @param example [TeamExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExample(@Param("record") Team record, @Param("example") TeamExample example);

	/**
	 * 通过主键有选择性的修改某该属性
	 *
	 * @param record [Team]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKeySelective(Team record);

	/**
	 * 通过主键修改所有属性
	 *
	 * @param record [Team]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKey(Team record);

}