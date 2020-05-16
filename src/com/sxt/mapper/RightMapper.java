package com.sxt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sxt.pojo.Right;

public interface RightMapper {
	//根据角色id查询以及菜单
	List<Right> findByRoleId(int roleId);
	//根据父id查询子菜单
	List<Right> findByParentId(int parentId);
	//查询所有的一级菜单
	List<Right> findByLevel();
	
	//分页查询 查询所有的一级菜单
	List<Right> findByPage(Map<String,Object> map);
	//查询总的记录数
	int findCount(Right right);
	//根据id查询父菜单拥有的子菜单
	List<Right> findLevelTwoById(int parentId);
	
	//根据id查询详情
	Right findById(int id);
	//添加一级权限
	int addLevel1(Right right);
	//添加二级权限
	int addLevel2(Right right);
	//根据父权限id删除相关所有的子权限
	int deleteByParentId(int id);
	//删除一级权限
	int delete(int id);
	//修改一级权限的名称
	int updateLevel1(@Param("id") int id,@Param("rightName") String rightName);
	
}
