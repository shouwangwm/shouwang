package io;

import java.io.File;  
import java.io.FileInputStream;  
import java.io.IOException;  
import java.io.InputStream;  
public class FileCount {  
  /** 
   * ����дһ������ļ����ȵ�С���򣬱��������ͦ���ģ������try catch�����Ҳ����ô���ж��ѡ� 
   */  
  public static void main(String[] args) {  
     //TODO �Զ����ɵķ������  
            int count=0;  //ͳ���ļ��ֽڳ���  
     InputStream streamReader = null;   //�ļ�������  
     try{  
         streamReader = new FileInputStream(new File("D:/1.jpg"));  
         /*1.new File()������ļ���ַҲ����д��D:\\David\\Java\\java �߼�����\\files\\tiger.jpg,ǰһ��\�������Ժ�һ�� 
          * ����ת���ģ�FileInputStream���л������ģ���������֮�����رգ�������ܵ����ڴ�ռ�������ݶ�ʧ�� 
         */  
         while(streamReader.read()!=-1) {  //��ȡ�ļ��ֽڣ�������ָ�뵽��һ���ֽ�  
            count++;  
         }  
         System.out.println("---�����ǣ� "+count+" �ֽ�");  
     }catch (final IOException e) {  
         //TODO �Զ����ɵ� catch ��  
         e.printStackTrace();  
     }finally{  
         try{  
            streamReader.close();  
         }catch (IOException e) {  
            //TODO �Զ����ɵ� catch ��  
            e.printStackTrace();  
         }  
     }  
  }  
  
} 