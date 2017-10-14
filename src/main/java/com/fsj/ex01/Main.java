package com.fsj.ex01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		//使用AnnotationConfigApplicationContext实例化Spring容器
		AnnotationConfigApplicationContext context =
			  new AnnotationConfigApplicationContext();

		context.getEnvironment().setActiveProfiles("dev"); //激活profile
		context.register(TestConfig.class);// 注册bean配置类。
		context.refresh(); //刷新容器

		TestBean demoBean = context.getBean(TestBean.class);

		System.out.println(demoBean.getContent());

		context.close();
	}
}
