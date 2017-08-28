package com.dao;

import com.pojo.Userandgroup;
import com.pojo.UserandgroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserandgroupMapper {

	/**
	 * 统计符合自定义条件的数据个数
	 *
	 * @param example [UserandgroupExample]自定义条件
	 * @return [int]符合条件的数据个数
	 */
	int countByExample(UserandgroupExample example);

	/**
	 * 自定义条件删除数据
	 *
	 * @param example [UserandgroupExample]自定义条件
	 * @return [int]受影响行数
	 */
	int deleteByExample(UserandgroupExample example);

	/**
	 * 根据主键删除单条数据
	 *
	 * @param ugId [Integer](主键属性)编号（主键）
	 * @return [int]受影响行数
	 */
	int deleteByPrimaryKey(@Param("ugId") Integer ugId);

	/**
	 * 插入单条数据
	 *
	 * @param record [Userandgroup]待插入数据
	 * @return [int]受影响行数
	 */
	int insert(Userandgroup record);

	/**
	 * 有选择的插入单条数据，只插入不为空的属性
	 *
	 * @param record [Userandgroup]待插入数据
	 * @return [int]受影响行数
	 */
	int insertSelective(Userandgroup record);

	/**
	 * 查询符合自定义条件的数据
	 *
	 * @param example [UserandgroupExample]自定义条件
	 * @return [List<Userandgroup>]符合自定义条件的数据
	 */
	List<Userandgroup> selectByExample(UserandgroupExample example);

	/**
	 * 根据主键查询单条数据
	 *
	 * @param ugId [Integer](主键属性)编号（主键）
	 * @return [Userandgroup]查询结果
	 */
	Userandgroup selectByPrimaryKey(@Param("ugId") Integer ugId);

	/**
	 * 自定义条件的有选择性的修改某些属性，只修改不为空的属性
	 *
	 * @param record [Userandgroup]数据对象，用于指定修改属性
	 * @param example [UserandgroupExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExampleSelective(@Param("record") Userandgroup record, @Param("example") UserandgroupExample example);

	/**
	 * 自定义条件修改所有属性
	 *
	 * @param record [Userandgroup]数据对象，用于指定修改属性
	 * @param example [UserandgroupExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExample(@Param("record") Userandgroup record, @Param("example") UserandgroupExample example);

	/**
	 * 通过主键有选择性的修改某该属性
	 *
	 * @param record [Userandgroup]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKeySelective(Userandgroup record);

	/**
	 * 通过主键修改所有属性
	 *
	 * @param record [Userandgroup]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKey(Userandgroup record);

}