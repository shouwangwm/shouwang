package com.zgxcw.service.infrastructure.goods.service.impl;

import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zgxcw.service.infrastructure.goods.bean.A;
import com.zgxcw.service.infrastructure.goods.service.AService;
import com.zgxcw.service.infrastructure.goods.utils.LogConsole;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/notenv/applicationContext.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AServiceImplTest {
	
	@Autowired
	AService aService;
	@Test
	public void testAdd() {
		A a = new A();
		a.setId(RandomStringUtils.randomAlphanumeric(32));
		a.setName("zs");
		a.setScount(200);
		System.out.println("================================== id: " + a.getId());
		try {
			aService.add(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LogConsole.error("===================testAdd======================");
	}

}
