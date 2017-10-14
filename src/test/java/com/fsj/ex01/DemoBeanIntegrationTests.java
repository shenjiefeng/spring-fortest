package com.fsj.ex01;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //表示该测试用例是运用junit4进行测试，也可以换成其他测试框架
@ContextConfiguration(classes = {TestConfig.class}) //此注解用来加载配置ApplicationContext
@ActiveProfiles("prod") //声明活动的profile
public class DemoBeanIntegrationTests {
	@Autowired //注入bean
	private TestBean testBean;

	@Test //@Test标注在方法前，表示其是一个测试的方法 无需在其配置文件中额外设置属性.
	public void prodBeanShouldInject(){
		String expected = "from production profile";
		String actual = testBean.getContent();
		Assert.assertEquals(expected, actual);
	}

	@Before
	public void beforeMethod(){
		System.out.println("before all tests");
	}
	@After
	public void	afterMethod(){
		System.out.println("after all tests.");
	}
}
