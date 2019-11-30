package cn.sp.appinfo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.sp.appinfo.entity.AppCategory;

public interface AppCategoryDao {
	//根据父级parentId查询对应的子级信息
	public List<AppCategory> getByParentId(@Param("parentId") Integer parentId);

}
