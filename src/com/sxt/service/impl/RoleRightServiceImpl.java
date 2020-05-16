package com.sxt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sxt.mapper.RoleRightMapper;
import com.sxt.pojo.RoleRight;
import com.sxt.service.RoleRightService;
@Service
public class RoleRightServiceImpl implements RoleRightService{
	@Resource
	private RoleRightMapper roleRightMapper;
	
	//添加
	@Override
	public int add(RoleRight roleRight) {
		// TODO Auto-generated method stub
		return roleRightMapper.add(roleRight);
	}
	//根据角色Id查询全部
	@Override
	public List<RoleRight> findByRoleId(int roleId) {
		// TODO Auto-generated method stub
		return roleRightMapper.findByRoleId(roleId);
	}
	//删除单条权限
	@Override
	public int delete(int roleId, int rightId) {
		// TODO Auto-generated method stub
		return roleRightMapper.delete(roleId, rightId);
	}
	//根据角色Id删除权限 
	@Override
	public int deleteAll(int roleId) {
		// TODO Auto-generated method stub
		return roleRightMapper.deleteAll(roleId);
	}
	
}
