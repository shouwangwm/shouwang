package com.test;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {

  public static void main(String[] args) throws Exception {
    startService();
    System.out.println(new Date().toString() + ":服务已启动");
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    do{
      String input="";
      if(br.ready()) {
        input = br.readLine();
      }
      if(input.equals("stop")){
        break;
      }
    }while (br!=null);
    br.close();
  }

  static void startService() {
    ClassPathXmlApplicationContext context =
        new ClassPathXmlApplicationContext("notenv/applicationContext.xml");
    context.start();
  }
}
