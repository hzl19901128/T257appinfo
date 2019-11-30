package cn.sp.appinfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.sp.appinfo.dao.AppCategoryDao;
import cn.sp.appinfo.entity.AppCategory;
import cn.sp.appinfo.service.AppCategoryService;

@Service
public class AppCategoryServiceImpl implements AppCategoryService{
	
	@Resource
	private AppCategoryDao appCategoryDao;

	@Override
	public List<AppCategory> getByParentId(Integer parentId) {
		return appCategoryDao.getByParentId(parentId);
	}

}
