package com.pro.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pro.dao.AdminDao;
import com.pro.util.CreateHtml;
import com.pro.vo.TbCommodity;
import com.pro.vo.YgAdmin;

public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao{

	public List<YgAdmin> getAll() {
		List<YgAdmin> admins = null;
		try {
			admins = getHibernateTemplate().find("from YgAdmin");
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admins;
	}

	public void save(TbCommodity commodity) {
		try {
			getHibernateTemplate().save(commodity);
			//静态化更新
			CreateHtml.createCommodity(commodity);
			CreateHtml.createIndex(this.getCommodity());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}

	public void update(TbCommodity commodity) {
		try {
			getHibernateTemplate().update(commodity);
			//静态化更新
			CreateHtml.createCommodity(commodity);
			CreateHtml.createIndex(this.getCommodity());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}

	public void delete(TbCommodity commodity) {
		try {
			getHibernateTemplate().delete(commodity);
			//静态化更新
			CreateHtml.deleteCommodity(commodity);
			CreateHtml.createIndex(this.getCommodity());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}

	public List<TbCommodity> getCommodity() {
		List<TbCommodity> ditys = null;
		try {
			ditys = getHibernateTemplate().find("from TbCommodity");
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return ditys;
	}

}
