package com.pro.vo;

/**
 * YgAdmin entity. @author MyEclipse Persistence Tools
 */

public class YgAdmin implements java.io.Serializable {

	// Fields

	private Integer adminId;
	private String adminLoginName;
	private String adminRealName;
	private String adminPwd;
	private String adminPhone;
	private String adminEmail;
	private String adminAge;
	private String adminGender;
	private Integer adminRoleId;
	private String adminLastLoginIp;

	// Constructors

	/** default constructor */
	public YgAdmin() {
	}

	/** minimal constructor */
	public YgAdmin(Integer adminId) {
		this.adminId = adminId;
	}

	/** full constructor */
	public YgAdmin(Integer adminId, String adminLoginName,
			String adminRealName, String adminPwd, String adminPhone,
			String adminEmail, String adminAge, String adminGender,
			Integer adminRoleId, String adminLastLoginIp) {
		this.adminId = adminId;
		this.adminLoginName = adminLoginName;
		this.adminRealName = adminRealName;
		this.adminPwd = adminPwd;
		this.adminPhone = adminPhone;
		this.adminEmail = adminEmail;
		this.adminAge = adminAge;
		this.adminGender = adminGender;
		this.adminRoleId = adminRoleId;
		this.adminLastLoginIp = adminLastLoginIp;
	}

	// Property accessors

	public Integer getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminLoginName() {
		return this.adminLoginName;
	}

	public void setAdminLoginName(String adminLoginName) {
		this.adminLoginName = adminLoginName;
	}

	public String getAdminRealName() {
		return this.adminRealName;
	}

	public void setAdminRealName(String adminRealName) {
		this.adminRealName = adminRealName;
	}

	public String getAdminPwd() {
		return this.adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

	public String getAdminPhone() {
		return this.adminPhone;
	}

	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}

	public String getAdminEmail() {
		return this.adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminAge() {
		return this.adminAge;
	}

	public void setAdminAge(String adminAge) {
		this.adminAge = adminAge;
	}

	public String getAdminGender() {
		return this.adminGender;
	}

	public void setAdminGender(String adminGender) {
		this.adminGender = adminGender;
	}

	public Integer getAdminRoleId() {
		return this.adminRoleId;
	}

	public void setAdminRoleId(Integer adminRoleId) {
		this.adminRoleId = adminRoleId;
	}

	public String getAdminLastLoginIp() {
		return this.adminLastLoginIp;
	}

	public void setAdminLastLoginIp(String adminLastLoginIp) {
		this.adminLastLoginIp = adminLastLoginIp;
	}

}