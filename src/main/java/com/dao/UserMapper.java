package com.dao;

import com.pojo.User;
import com.pojo.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

	/**
	 * 统计符合自定义条件的数据个数
	 *
	 * @param example [UserExample]自定义条件
	 * @return [int]符合条件的数据个数
	 */
	int countByExample(UserExample example);

	/**
	 * 自定义条件删除数据
	 *
	 * @param example [UserExample]自定义条件
	 * @return [int]受影响行数
	 */
	int deleteByExample(UserExample example);

	/**
	 * 根据主键删除单条数据
	 *
	 * @param uId [Integer](主键属性)用户编号（主键）
	 * @return [int]受影响行数
	 */
	int deleteByPrimaryKey(@Param("uId") Integer uId);

	/**
	 * 插入单条数据
	 *
	 * @param record [User]待插入数据
	 * @return [int]受影响行数
	 */
	int insert(User record);

	/**
	 * 有选择的插入单条数据，只插入不为空的属性
	 *
	 * @param record [User]待插入数据
	 * @return [int]受影响行数
	 */
	int insertSelective(User record);

	/**
	 * 查询符合自定义条件的数据
	 *
	 * @param example [UserExample]自定义条件
	 * @return [List<User>]符合自定义条件的数据
	 */
	List<User> selectByExample(UserExample example);

	/**
	 * 根据主键查询单条数据
	 *
	 * @param uId [Integer](主键属性)用户编号（主键）
	 * @return [User]查询结果
	 */
	User selectByPrimaryKey(@Param("uId") Integer uId);

	/**
	 * 自定义条件的有选择性的修改某些属性，只修改不为空的属性
	 *
	 * @param record [User]数据对象，用于指定修改属性
	 * @param example [UserExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

	/**
	 * 自定义条件修改所有属性
	 *
	 * @param record [User]数据对象，用于指定修改属性
	 * @param example [UserExample]自定义条件
	 * @return [int]受影响行数
	 */
	int updateByExample(@Param("record") User record, @Param("example") UserExample example);

	/**
	 * 通过主键有选择性的修改某该属性
	 *
	 * @param record [User]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKeySelective(User record);

	/**
	 * 通过主键修改所有属性
	 *
	 * @param record [User]数据对象，用于指定修改属性，数据中应包含主键
	 * @return [int]受影响行数
	 */
	int updateByPrimaryKey(User record);

}