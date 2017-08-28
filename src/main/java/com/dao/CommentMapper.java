package com.dao;

import com.pojo.Comment;
import com.pojo.CommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentMapper {

	/**
	 * 统计符合自定义条件的数据个数
	 *
	 * @param example [CommentExample]自定义条件
	 * @return [int]符合条件的数据个数
	 */
	int countByExample(CommentExample example);

	/**
	 * 自定义条件删除数据
	 *
	 * @param example [CommentExample]自定义条件
	 * @return [int]受影响行数
	 */
	int deleteByExample(CommentExample example);

	/**
	 * 根据主键删除单条数据
	 *
	 * @param cId [Integer](主键属性)评论编号
	 * @return [int]受影响行数
	 */
	int deleteByPrimaryKey(@Param("cId") Integer cId);

	/**
	 * 插入单条数据
	 *
	 * @param record [Comment]待插入数据
	 * @return [int]受影响行数
	 */
	int insert(Comment record);

	/**
	 * 有选择的插入单条数据，只插入不为空的属性
	 *
	 * @param record [Comment]待插入数据
	 * @return [int]受影响行数
	 */
	int insertSelective(Comment record);

	/**
	 * 查询符合自定义条件的数据
	 *
	 * @param example [CommentExample]自定义条件
	 * @return [List<Comment>]符合自定义条件的数据
	 */
	List<Comment> selectByExample(CommentExample example);

	/**
	 * 根据主键查询单条数据
	 *
	 * @param cId [Integer](主键属性)评论编号
	 * @return [Comment]查询结果
	 */
	Comment selectByPrimaryKey(@Param("cId") Integer cId);

	/**
	 * 自定义条件的有选择性的修改某些属性，只修改不为空的属性
	 *
	 * @param record [Comment]数据对象，用于指定修改属性
	 * @param example [CommentExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentExample example);

	/**
	 * 自定义条件修改所有属性
	 *
	 * @param record [Comment]数据对象，用于指定修改属性
	 * @param example [CommentExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExample(@Param("record") Comment record, @Param("example") CommentExample example);

	/**
	 * 通过主键有选择性的修改某该属性
	 *
	 * @param record [Comment]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKeySelective(Comment record);

	/**
	 * 通过主键修改所有属性
	 *
	 * @param record [Comment]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKey(Comment record);

}