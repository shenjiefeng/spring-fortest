package com.fsj.ex01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class TestConfig {
	@Bean // 声明当前方法的返回值是一个bean
	@Profile("dev")
	public TestBean devTestBean() {
		return new TestBean("from development profile");
	}

	@Bean
	@Profile("prod")
	public TestBean prodTestBean() {
		return new TestBean("from production profile");
	}

}
