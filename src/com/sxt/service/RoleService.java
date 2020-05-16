package com.sxt.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sxt.pojo.PageUtil;
import com.sxt.pojo.Role;

public interface RoleService {
	//查询全部
	List<Role> findAll();
	//分页查询
	PageUtil findByPage(Role role,PageUtil pageUtil);
	//查询总的记录数
	int findCount(Role role);
	//添加
	int add(Role role);	
	//删除
	int delete(int id);
	//修改
	int update(Role role);
	//根据id查询详情
	Role findById(int id);
	//根据名称查询详情
	Role findByRoleName(String roleName);
}
