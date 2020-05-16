package com.sxt.mapper;

import java.util.List;

import com.sxt.pojo.RoleRight;

public interface RoleRightMapper {
	//添加
	int add(RoleRight roleRight);
	//根据角色id查询全部
	List<RoleRight> findByRoleId(int roleId);
	//删除单条权限(修改用)
	int delete(int roleId,int rightId);
	//根据角色Id删除权限 
	int deleteAll(int roleId);
}
