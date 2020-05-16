package com.sxt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sxt.pojo.Role;

public interface RoleMapper {
	//查询全部
	List<Role> findAll();
	//分页查询
	List<Role> findByPage(Map<String,Object> map);
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
	Role findByRoleName(@Param("roleName") String roleName);
}
