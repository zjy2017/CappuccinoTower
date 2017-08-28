package com.dao;

import com.pojo.Dynamic;
import com.pojo.DynamicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DynamicMapper {

	/**
	 * 统计符合自定义条件的数据个数
	 *
	 * @param example [DynamicExample]自定义条件
	 * @return [int]符合条件的数据个数
	 */
	int countByExample(DynamicExample example);

	/**
	 * 自定义条件删除数据
	 *
	 * @param example [DynamicExample]自定义条件
	 * @return [int]受影响行数
	 */
	int deleteByExample(DynamicExample example);

	/**
	 * 根据主键删除单条数据
	 *
	 * @param dynamicId [Integer](主键属性)动态编号
	 * @return [int]受影响行数
	 */
	int deleteByPrimaryKey(@Param("dynamicId") Integer dynamicId);

	/**
	 * 插入单条数据
	 *
	 * @param record [Dynamic]待插入数据
	 * @return [int]受影响行数
	 */
	int insert(Dynamic record);

	/**
	 * 有选择的插入单条数据，只插入不为空的属性
	 *
	 * @param record [Dynamic]待插入数据
	 * @return [int]受影响行数
	 */
	int insertSelective(Dynamic record);

	/**
	 * 查询符合自定义条件的数据
	 *
	 * @param example [DynamicExample]自定义条件
	 * @return [List<Dynamic>]符合自定义条件的数据
	 */
	List<Dynamic> selectByExample(DynamicExample example);

	/**
	 * 根据主键查询单条数据
	 *
	 * @param dynamicId [Integer](主键属性)动态编号
	 * @return [Dynamic]查询结果
	 */
	Dynamic selectByPrimaryKey(@Param("dynamicId") Integer dynamicId);

	/**
	 * 自定义条件的有选择性的修改某些属性，只修改不为空的属性
	 *
	 * @param record [Dynamic]数据对象，用于指定修改属性
	 * @param example [DynamicExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExampleSelective(@Param("record") Dynamic record, @Param("example") DynamicExample example);

	/**
	 * 自定义条件修改所有属性
	 *
	 * @param record [Dynamic]数据对象，用于指定修改属性
	 * @param example [DynamicExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExample(@Param("record") Dynamic record, @Param("example") DynamicExample example);

	/**
	 * 通过主键有选择性的修改某该属性
	 *
	 * @param record [Dynamic]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKeySelective(Dynamic record);

	/**
	 * 通过主键修改所有属性
	 *
	 * @param record [Dynamic]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKey(Dynamic record);

}