package com.pro.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pro.vo.TbCommodity;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.TemplateExceptionHandler;

public class CreateHtml {
	
	private static final String DB_name = "test";
	private static final String DB_userName = "root";
	private static final String DB_passWord = "root";
	private static final String FTL_index = "index.ftl";
	private static final String FTL_commodity = "commodity.ftl";
	private static final String BASE = CreateHtml.class.getResource("/").getPath().split("WEB-INF")[0];
	private static final String FTL_path = BASE + "ftl";
	
	public static void main(String[] args) throws Exception{
		DataHelper db = new DataHelper(DB_name,DB_userName,DB_passWord);
		List<TbCommodity> commoditys = db.getAll();
		//生成主页
		createIndex(commoditys);
		//生成详情页
		for (TbCommodity comm : commoditys) {
			createCommodity(comm);
		}
	}
	
	/**
	 * <summary>
	 * 主页静态化
	 * </summary>
	 * @author Huangke
	 * @param data  模板数据
	 * @param fileName  静态化文件名称
	 * @Date 2013-7-10
	 */
	public static void createIndex(List<TbCommodity> ditys){
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("commoditys", ditys);
		create(FTL_index, data, "index.html");
		System.out.println("主页静态化成功");
	}
	
	public static void deleteCommodity(TbCommodity dity){
		File f = new File(BASE + "html/"+dity.getCommId()+".html");
		if(f.isFile()){
			f.delete();
		}
	}
	/**
	 * <summary>
	 * 商品详情页静态化
	 * </summary>
	 * @author Huangke
	 * @param data  模板数据
	 * @param fileName  静态化文件名称
	 * @Date 2013-7-10
	 */
	public static void createCommodity(TbCommodity commodity){
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("commName", commodity.getCommName());
		data.put("picUrl", commodity.getPicUrl());
		create(FTL_commodity, data, "/html/"+commodity.getCommId()+".html");
		System.out.println("商品["+commodity.getCommName()+"]详情页静态化成功");
	}
	
	/**
	 * <summary>
	 * 静态化配置
	 * </summary>
	 * @author Huangke
	 * @return
	 * @Date 2013-7-10
	 */
	private static Configuration createConfig(){
		Configuration cfg = null;
		try {
			cfg = new Configuration();
			cfg.setDirectoryForTemplateLoading(new File(FTL_path));
			cfg.setObjectWrapper(new DefaultObjectWrapper());
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return cfg;
	}
	/**
	 * <summary>
	 * 静态化生成
	 * </summary>
	 * @author Huangke
	 * @param templateName
	 * @param data
	 * @param fileName
	 * @Date 2013-7-10
	 */
	private static void create(String templateName,Map<String,Object> data,String fileName){
		try {
			Writer out = new OutputStreamWriter(new FileOutputStream(CreateHtml.class.getResource("/").getPath().split("WEB-INF")[0]+fileName),"GBK");
			CreateHtml.createConfig().getTemplate(templateName).process(data, out);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
