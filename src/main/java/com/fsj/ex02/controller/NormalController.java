package com.fsj.ex02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fsj.ex02.service.DemoService;

@Controller
public class NormalController {
	@Autowired
	DemoService demoService;
	
	@RequestMapping("/normal")
	public  String testPage(Model model){
		//可通过freemarker等模板引擎传值到前端页面
		model.addAttribute("msg", demoService.saySomething());
		return "page";
	}

}
