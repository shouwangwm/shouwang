package com.mq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @time : 2017年2月20日 上午11:26:20
 * @author :weiming
 */
@Controller
public class IndexController {
	
	@RequestMapping("index")
	public String index(){
		System.out.println("----------");
		return "index";
	}
	
}
