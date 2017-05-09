package com.pro.dao;

import java.util.List;

import com.pro.vo.TbCommodity;
import com.pro.vo.YgAdmin;

public interface AdminDao {
	
	public List<YgAdmin> getAll();
	
	public List<TbCommodity> getCommodity();
	
	public void save(TbCommodity commodity);
	
	public void update(TbCommodity commodity);
	
	public void delete(TbCommodity commodity);

}
