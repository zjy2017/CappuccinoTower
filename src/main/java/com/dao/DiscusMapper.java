package com.dao;

import com.pojo.Discus;
import com.pojo.DiscusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DiscusMapper {

	/**
	 * 统计符合自定义条件的数据个数
	 *
	 * @param example [DiscusExample]自定义条件
	 * @return [int]符合条件的数据个数
	 */
	int countByExample(DiscusExample example);

	/**
	 * 自定义条件删除数据
	 *
	 * @param example [DiscusExample]自定义条件
	 * @return [int]受影响行数
	 */
	int deleteByExample(DiscusExample example);

	/**
	 * 根据主键删除单条数据
	 *
	 * @param discusId [Integer](主键属性)讨论编号（主键）
	 * @return [int]受影响行数
	 */
	int deleteByPrimaryKey(@Param("discusId") Integer discusId);

	/**
	 * 插入单条数据
	 *
	 * @param record [Discus]待插入数据
	 * @return [int]受影响行数
	 */
	int insert(Discus record);

	/**
	 * 有选择的插入单条数据，只插入不为空的属性
	 *
	 * @param record [Discus]待插入数据
	 * @return [int]受影响行数
	 */
	int insertSelective(Discus record);

	/**
	 * 查询符合自定义条件的数据
	 *
	 * @param example [DiscusExample]自定义条件
	 * @return [List<Discus>]符合自定义条件的数据
	 */
	List<Discus> selectByExample(DiscusExample example);

	/**
	 * 根据主键查询单条数据
	 *
	 * @param discusId [Integer](主键属性)讨论编号（主键）
	 * @return [Discus]查询结果
	 */
	Discus selectByPrimaryKey(@Param("discusId") Integer discusId);

	/**
	 * 自定义条件的有选择性的修改某些属性，只修改不为空的属性
	 *
	 * @param record [Discus]数据对象，用于指定修改属性
	 * @param example [DiscusExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExampleSelective(@Param("record") Discus record, @Param("example") DiscusExample example);

	/**
	 * 自定义条件修改所有属性
	 *
	 * @param record [Discus]数据对象，用于指定修改属性
	 * @param example [DiscusExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExample(@Param("record") Discus record, @Param("example") DiscusExample example);

	/**
	 * 通过主键有选择性的修改某该属性
	 *
	 * @param record [Discus]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKeySelective(Discus record);

	/**
	 * 通过主键修改所有属性
	 *
	 * @param record [Discus]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKey(Discus record);

}