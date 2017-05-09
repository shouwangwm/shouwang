package com.pro.service;

import java.util.List;

import com.pro.vo.TbCommodity;
import com.pro.vo.YgAdmin;

public interface AdminService {
	public List<YgAdmin> getAll();
	
	public void save(TbCommodity commodity);
	
	public void update(TbCommodity commodity);  
	
	public void delete(TbCommodity commodity);
	
	public List<TbCommodity> getCommodity();

}
