package com.fsj.ex02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc// 1  开启SpringMVC支持，如ViewResolver或者MessageConverter等。
@ComponentScan("com.fsj.ex02")
public class MyMvcConfig extends WebMvcConfigurerAdapter {// 2

	@Bean
	public InternalResourceViewResolver viewResolver() {
		/* InternalResourceViewResolver 实现了ViewResolver接口
		 */
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		// 配置JSP的ViewResolver，映射路径和实际页面的位置。
		// 可以从编译好的xxx-SNAPSHOT中看到此路径
		viewResolver.setPrefix("/WEB-INF/classes/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}
}
