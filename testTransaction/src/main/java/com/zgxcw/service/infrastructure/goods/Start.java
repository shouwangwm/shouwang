package com.zgxcw.service.infrastructure.goods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {
    
    private static final Logger logger = LoggerFactory.getLogger(Start.class);
  
    public static void main(String[] args) throws Exception {
      ClassPathXmlApplicationContext context =
          new ClassPathXmlApplicationContext("notenv/applicationContext.xml");
      logger.info("服务启动成功");
      
      
      System.exit(0);
    }

}
