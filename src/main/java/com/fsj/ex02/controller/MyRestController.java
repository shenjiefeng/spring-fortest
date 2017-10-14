package com.fsj.ex02.controller;

import com.alibaba.fastjson.JSON;
import com.fsj.ex02.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsj.ex02.service.DemoService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MyRestController {
	
	@Autowired
	DemoService demoService;
	
	@RequestMapping(value = "/testRest" ,produces="text/plain;charset=UTF-8")
	public @ResponseBody String testRest(){
		return demoService.saySomething();
	}

	@RequestMapping(value = "/rest" ,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String rest(){
		User tom = new User();
		tom.setId(100L);
		tom.setName("tom");
		return JSON.toJSONString(tom);
	}

	public static void main(String[] args){
		System.out.println("local test:");
		Map<String,String > map = new HashMap<>();
		map.put("a","0");
		map.put("b","1");
		System.out.println(JSON.toJSONString(map));
	}
}
