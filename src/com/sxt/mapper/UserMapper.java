package com.sxt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sxt.pojo.User;

public interface UserMapper {
	//登陆
	User login(@Param("userName") String userName,@Param("password") String password);
	//ajax检查用户名是否存在
	User ajaxCheckUserName(@Param("userName") String userName);
	//修改密码
	int updatePassword(@Param("id") int id,@Param("password") String password);
	//分页查询
	List<User> findByPage(Map<String,Object> map);
	//查询总的记录数
	int findCount(User user);
	//添加
	int add(User user);
	//删除
	int delete(int id);
	//修改
	int update(User user);
	//根据id查询详情
	User findById(int id);
	
}
