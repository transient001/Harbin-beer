package com.sxt.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.sxt.mapper.RightMapper;
import com.sxt.pojo.PageUtil;
import com.sxt.pojo.Right;
import com.sxt.service.RightService;

@Service
public class RightServiceImpl implements RightService{
	@Resource
	private RightMapper rightMapper;
	//根据角色id查询以及菜单
	@Override
	public List<Right> findByRoleId(int roleId) {
		List<Right> rightList = rightMapper.findByRoleId(roleId);
		for(Right r:rightList){
			r.setChildRight(rightMapper.findByParentId(r.getId()));
		}
		return rightList;
	}
	//查询所有的一级菜单
	@Override
	public List<Right> findByLevel() {
		// TODO Auto-generated method stub
		return rightMapper.findByLevel();
	}
	@Override
	public PageUtil findByPage(Right right,PageUtil pageUtil) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("startNum",pageUtil.getStartNum());
		map.put("pageSize",pageUtil.getPageSize());
		map.put("rightName",right.getRightName());
		pageUtil.setTotalNum(rightMapper.findCount(right));
		List<Right> rightList = rightMapper.findByPage(map);
		for(Right r:rightList){
			r.setChildRight(rightMapper.findLevelTwoById(r.getId()));
			System.out.println("**=========================");
			System.out.println(rightMapper.findLevelTwoById(r.getId()));
		}
		
		pageUtil.setPageList(rightList);
		return pageUtil;
	}
	@Override
	public int findCount(Right right) {
		// TODO Auto-generated method stub
		return rightMapper.findCount(right);
	}
	//根据id查询详情
	@Override
	public Right findById(int id) {
		// TODO Auto-generated method stub
		return rightMapper.findById(id);
	}
	//根据id查询父菜单拥有的子菜单
	@Override
	public List<Right> findLevelTwoById(int parentId) {
		// TODO Auto-generated method stub
		return rightMapper.findLevelTwoById(parentId);
	}
	//添加一级权限
	@Override
	public int addLevel1(Right right) {
		// TODO Auto-generated method stub
		return rightMapper.addLevel1(right);
	}
	//添加二级权限
	@Override
	public int addLevel2(Right right) {
		// TODO Auto-generated method stub
		return rightMapper.addLevel2(right);
	}
	//根据父id删除相关子权限
	@Override
	public int deleteByParentId(int id) {
		// TODO Auto-generated method stub
		return rightMapper.deleteByParentId(id);
	}
	//删除一级权限
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return rightMapper.delete(id);
	}
	//根据父id查询子权限
	@Override
	public List<Right> findByParentId(int parentId) {
		// TODO Auto-generated method stub
		return rightMapper.findByParentId(parentId);
	}
	//修改一级权限的名称
	@Override
	public int updateLevel1(int id, String rightName) {
		// TODO Auto-generated method stub
		return rightMapper.updateLevel1(id, rightName);
	}

	
}
