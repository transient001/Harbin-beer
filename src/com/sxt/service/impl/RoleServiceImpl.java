package com.sxt.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sxt.mapper.RightMapper;
import com.sxt.mapper.RoleMapper;
import com.sxt.pojo.PageUtil;
import com.sxt.pojo.Right;
import com.sxt.pojo.Role;
import com.sxt.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService{
	@Resource
	private RoleMapper roleMapper;
	@Resource
	private RightMapper rightMapper;
	
	//查询全部
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleMapper.findAll();
	}
	
	@Override
	public PageUtil findByPage(Role role, PageUtil pageUtil) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("startNum",pageUtil.getStartNum());
		map.put("pageSize",pageUtil.getPageSize());
		map.put("roleName",role.getRoleName());
		
		pageUtil.setTotalNum(roleMapper.findCount(role));
		List<Role> roles = roleMapper.findByPage(map);
		for(Role r:roles){
			r.setRightList(rightMapper.findByRoleId(r.getId()));
		}
		
		pageUtil.setPageList(roles);
		return pageUtil;
	}

	@Override
	public int findCount(Role role) {
		// TODO Auto-generated method stub
		return roleMapper.findCount(role);
	}
	//添加
	@Override
	public int add(Role role) {
		// TODO Auto-generated method stub
		return roleMapper.add(role);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return roleMapper.delete(id);
	}

	@Override
	public int update(Role role) {
		// TODO Auto-generated method stub
		return roleMapper.update(role);
	}

	@Override
	public Role findById(int id) {
		// TODO Auto-generated method stub
		return roleMapper.findById(id);
	}
	//根据角色名称查询详情
	@Override
	public Role findByRoleName(String roleName) {
		// TODO Auto-generated method stub
		return roleMapper.findByRoleName(roleName);
	}

	
}
