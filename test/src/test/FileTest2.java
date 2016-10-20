package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileTest2 {
	
	public static void main(String[] args) {
		
		int count = 0 ;		
//		count = readCode("D:\\sumCode",count);
//		System.out.println(count);
		
		String s = " /* asdfasd*/fasdf";
		Pattern pattern = Pattern.compile("^/*(.*\\*/).+ | .+(\\*/$)"); 
		Matcher m = pattern.matcher(s);
		if(m.find()){
			System.out.println(" find ");
		}
	}
	
	public static int read(String path, int count){
		File file = new File(path);
		if(file.exists()){
			if(file.isDirectory()){
				File array[] = file.listFiles();
				for(File f : array){
					count = read(f.getAbsolutePath(), count);
				}
			}else{
				System.out.println(file.getName());
				count ++;
			}
		}
		return count;
	}
	
	//循环每一个文件
	public static int readCode(String path, int count){
		File file = new File(path);
		if(file.exists()){
			if(file.isDirectory()){
				File array[] = file.listFiles();
				for(File f : array){
					count = readCode(f.getAbsolutePath(), count);
				}
			}else{
				count = sumCode(file,count);
			}
		}
		return count;
	}
	
	//统计代码行数， 注释不算
	public static int sumCode(File file, int count){
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String str = null;
			String temp;
			
			while((str = br.readLine()) != null){
				temp = str.trim();
				int indexStart = temp.indexOf("/*");
				int indexEnd = temp.indexOf("*/");
				
				
				if("".equals(temp)){
					
				}else if(temp.startsWith("//")){
					
				}else if(temp.startsWith("/*") &&  (indexEnd == -1 || indexEnd == temp.length())){
					
				}else if(temp.endsWith("*/") && (indexStart == -1 || indexStart == 0)){
				
				}else if(temp.startsWith("*") && (indexEnd == -1 || indexEnd == temp.length())){
					
				}else{
					count ++;
					System.out.println(temp + "  ================= 符合！");
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return count;
	}
}
