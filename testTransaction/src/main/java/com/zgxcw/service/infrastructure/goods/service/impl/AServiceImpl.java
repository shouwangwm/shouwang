package com.zgxcw.service.infrastructure.goods.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zgxcw.service.infrastructure.goods.bean.A;
import com.zgxcw.service.infrastructure.goods.dao.AMapper;
import com.zgxcw.service.infrastructure.goods.service.AService;
import com.zgxcw.service.infrastructure.goods.utils.LogConsole;

@Service
public class AServiceImpl implements AService {
	@Autowired
	private AMapper aMapper;
	
	@Transactional(rollbackFor = Exception.class)
	public void add(A a) throws Exception{
		try {
			aMapper.insert(a);
			int index = 10 / 0;
			a.setScount(30);
			aMapper.insert(a);
		} catch (Exception e) {
			LogConsole.error("新增出错");
			throw new Exception();
		}
		
	}

}
