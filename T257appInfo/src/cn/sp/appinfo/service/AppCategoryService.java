package cn.sp.appinfo.service;

import java.util.List;

import cn.sp.appinfo.entity.AppCategory;

public interface AppCategoryService {
	//根据父级parentId查询对应的子级信息
	public List<AppCategory> getByParentId(Integer parentId);
}
