package io;

import java.io.*;  

public class FileExample{  
   public static void main(String[] args) {  
      
       createFile();  
   }  
  
 /** 
  * �ļ�����ʾ�� 
  */  
 public static void createFile() {  
    File f=new File("D:/111.txt");  
       try{  
           f.createNewFile();  //���ҽ��������ھ��д˳���·����ָ�����Ƶ��ļ�ʱ�����ɷֵش���һ���µĿ��ļ���  
           System.out.println("�÷�����С"+f.getTotalSpace()/(1024*1024*1024)+"G"); //�����ɴ˳���·������ʾ���ļ���Ŀ¼�����ơ�  
           f.mkdirs();  //�����˳���·����ָ����Ŀ¼���������б��赫�����ڵĸ�Ŀ¼��  
//           f.delete(); //  ɾ���˳���·������ʾ���ļ���Ŀ¼  
          System.out.println("�ļ���  "+f.getName());  //  �����ɴ˳���·������ʾ���ļ���Ŀ¼�����ơ�  
          System.out.println("�ļ���Ŀ¼�ַ��� "+f.getParent());// ���ش˳���·������Ŀ¼��·�����ַ����������·����û��ָ����Ŀ¼���򷵻� null��  
           
       }catch (Exception e) {  
           e.printStackTrace();  
       }  
 }  
}  
