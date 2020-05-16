package com.sxt.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sxt.mapper.UserMapper;
import com.sxt.pojo.PageUtil;
import com.sxt.pojo.User;
import com.sxt.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserMapper userMapper;
	
	//登陆
	@Override
	public User login(String userName, String password) {
		// TODO Auto-generated method stub
		return userMapper.login(userName, password);
	}
	//分页查询
	@Override
	public PageUtil findByPage(User user, PageUtil pageUtil) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userName",user.getUserName());
		map.put("realName",user.getRealName());
		map.put("roleName",user.getRole().getRoleName());
		map.put("startNum",pageUtil.getStartNum());
		map.put("pageSize",pageUtil.getPageSize());
		pageUtil.setPageList(userMapper.findByPage(map));
		pageUtil.setTotalNum(userMapper.findCount(user));
		
		return pageUtil;
	}

	@Override
	public int findCount(User user) {
		// TODO Auto-generated method stub
		return userMapper.findCount(user);
	}

	@Override
	public int add(User user) {
		// TODO Auto-generated method stub
		return userMapper.add(user);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return userMapper.delete(id);
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		return userMapper.update(user);
	}
	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return userMapper.findById(id);
	}
	//ajax检查用户名是否存在
	@Override
	public User ajaxCheckUserName(String userName) {
		// TODO Auto-generated method stub
		return userMapper.ajaxCheckUserName(userName);
	}
	//修改密码
	@Override
	public int updatePassword(int id, String password) {
		// TODO Auto-generated method stub
		return userMapper.updatePassword(id, password);
	}

}
