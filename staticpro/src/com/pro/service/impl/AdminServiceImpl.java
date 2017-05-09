package com.pro.service.impl;

import java.util.List;

import com.pro.dao.AdminDao;
import com.pro.service.AdminService;
import com.pro.vo.TbCommodity;
import com.pro.vo.YgAdmin;

public class AdminServiceImpl implements AdminService {
	private AdminDao adminDao;
	public AdminDao getAdminDao() {
		return adminDao;
	}
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	public List<YgAdmin> getAll() {
		return adminDao.getAll();
	}
	public void save(TbCommodity commodity) {
		adminDao.save(commodity);
	}
	public void update(TbCommodity commodity) {
		adminDao.update(commodity);
	}
	public void delete(TbCommodity commodity) {
		adminDao.delete(commodity);
	}
	public List<TbCommodity> getCommodity() {
		return adminDao.getCommodity();
	}

}
