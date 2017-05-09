package com.pro.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pro.vo.TbCommodity;



public class DataHelper{
	private String dbName;
	private String user;
	private String passWord;
	private Connection conn;
	private Statement st;
	public DataHelper(){
	}
	public DataHelper(String dbName,String user,String passWord){
		this.dbName = dbName;
		this.user  = user;
		this.passWord = passWord;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	private void getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url="jdbc:mysql://localhost:3306/"+this.getDbName()+"?user="+this.getUser()+"&password="+this.getPassWord();
			conn = DriverManager.getConnection(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<TbCommodity> getAll(){
		getConnection();
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from tb_commodity");
			List<TbCommodity> tbCommoditys = new ArrayList<TbCommodity>();
			while (rs.next()) {
				TbCommodity tb = new TbCommodity();
				tb.setCommId(rs.getString("commId"));
				tb.setCommName(rs.getString("commName"));
				tb.setPicUrl(rs.getString("picUrl"));
				tbCommoditys.add(tb);
			}
			return tbCommoditys;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}
		return null;
	}
	
	private void close(){
		try {
			conn.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
