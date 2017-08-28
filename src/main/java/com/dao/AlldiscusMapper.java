package com.dao;

import com.pojo.Alldiscus;
import com.pojo.AlldiscusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AlldiscusMapper {

	/**
	 * 统计符合自定义条件的数据个数
	 *
	 * @param example [AlldiscusExample]自定义条件
	 * @return [int]符合条件的数据个数
	 */
	int countByExample(AlldiscusExample example);

	/**
	 * 自定义条件删除数据
	 *
	 * @param example [AlldiscusExample]自定义条件
	 * @return [int]受影响行数
	 */
	int deleteByExample(AlldiscusExample example);

	/**
	 * 根据主键删除单条数据
	 *
	 * @param discusallId [Integer](主键属性)讨论总表编号
	 * @return [int]受影响行数
	 */
	int deleteByPrimaryKey(@Param("discusallId") Integer discusallId);

	/**
	 * 插入单条数据
	 *
	 * @param record [Alldiscus]待插入数据
	 * @return [int]受影响行数
	 */
	int insert(Alldiscus record);

	/**
	 * 有选择的插入单条数据，只插入不为空的属性
	 *
	 * @param record [Alldiscus]待插入数据
	 * @return [int]受影响行数
	 */
	int insertSelective(Alldiscus record);

	/**
	 * 查询符合自定义条件的数据
	 *
	 * @param example [AlldiscusExample]自定义条件
	 * @return [List<Alldiscus>]符合自定义条件的数据
	 */
	List<Alldiscus> selectByExample(AlldiscusExample example);

	/**
	 * 根据主键查询单条数据
	 *
	 * @param discusallId [Integer](主键属性)讨论总表编号
	 * @return [Alldiscus]查询结果
	 */
	Alldiscus selectByPrimaryKey(@Param("discusallId") Integer discusallId);

	/**
	 * 自定义条件的有选择性的修改某些属性，只修改不为空的属性
	 *
	 * @param record [Alldiscus]数据对象，用于指定修改属性
	 * @param example [AlldiscusExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExampleSelective(@Param("record") Alldiscus record, @Param("example") AlldiscusExample example);

	/**
	 * 自定义条件修改所有属性
	 *
	 * @param record [Alldiscus]数据对象，用于指定修改属性
	 * @param example [AlldiscusExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExample(@Param("record") Alldiscus record, @Param("example") AlldiscusExample example);

	/**
	 * 通过主键有选择性的修改某该属性
	 *
	 * @param record [Alldiscus]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKeySelective(Alldiscus record);

	/**
	 * 通过主键修改所有属性
	 *
	 * @param record [Alldiscus]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKey(Alldiscus record);

}