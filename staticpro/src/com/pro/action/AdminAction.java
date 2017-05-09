package com.pro.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.pro.service.AdminService;
import com.pro.vo.TbCommodity;

public class AdminAction extends ActionSupport implements RequestAware{
	private AdminService adminService;
	private Map<String,Object> request;
	private TbCommodity tbCommodity;
	public TbCommodity getTbCommodity() {
		return tbCommodity;
	}
	public void setTbCommodity(TbCommodity tbCommodity) {
		this.tbCommodity = tbCommodity;
	}
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	@Override
	public String execute() throws Exception {
		request.put("admins", adminService.getCommodity());
		return SUCCESS;
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	public String insert() throws Exception{
		tbCommodity.setPicUrl("http://img01.taobaocdn.com/tps/i1/T1R6NxFe8gXXaZVCTS-300-100.png");
		adminService.save(tbCommodity);
		request.put("admins", adminService.getCommodity());
		return SUCCESS;
	}
	
	public String update() throws Exception{
		tbCommodity.setPicUrl("http://img01.taobaocdn.com/tps/i1/T1R6NxFe8gXXaZVCTS-300-100.png");
		adminService.update(tbCommodity);
		request.put("admins", adminService.getCommodity());
		return SUCCESS;
	}
	
	public String delete() throws Exception{
		adminService.delete(tbCommodity);
		request.put("admins", adminService.getCommodity());
		return SUCCESS;
	}

}
