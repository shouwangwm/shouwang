package com.test.service;


import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.service.springdemo.ProducerService;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/notenv/applicationContext.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProducerConsumerTest {
 
    @Autowired
    private ProducerService producerService;

    @Test
    public void testSend() {
        for (int i=0; i<2; i++) {
            producerService.sendMessage(null, "这是第" + (i+1) + "条消息");
        }
    }
    
}

