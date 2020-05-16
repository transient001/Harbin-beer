package com.sxt.service;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sxt.pojo.PageUtil;
import com.sxt.pojo.User;

public interface UserService {
	//登陆
	User login(String userName,String password);
	//ajax检查用户名是否存在
	User ajaxCheckUserName(String userName);
	//修改密码
	int updatePassword(int id,String password);	
	//分页查询
	PageUtil findByPage(User user,PageUtil pageUtil);
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
