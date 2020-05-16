package com.sxt.service;

import java.util.List;

import com.sxt.pojo.RoleRight;

public interface RoleRightService {
	//添加
	int add(RoleRight roleRight);
	//根据角色id查询全部
	List<RoleRight> findByRoleId(int roleId);
	//删除单条权限
	int delete(int roleId,int rightId);
	//根据角色Id删除权限 
	int deleteAll(int roleId);
}
