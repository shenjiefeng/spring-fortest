package com.fsj.ex02;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fsj.ex02.MyMvcConfig;
import com.fsj.ex02.service.DemoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyMvcConfig.class})
@WebAppConfiguration("src/main/resources") //1 此注解指定web资源的位置，默认为src/main/webapp
public class TestControllerIntegrationTests {
	private MockMvc mockMvc; //2 模拟MVC对象
	
	@Autowired
	private DemoService demoService;//3 在测试用例注入spring的bean
	
	@Autowired 
	WebApplicationContext wac; //4 注入WebApplicationContext
	
    @Autowired 
    MockHttpSession session; //5 注入模拟的http session
    
    @Autowired 
    MockHttpServletRequest request; // 模拟request
    
    @Before //7 测试开始前的初始化工作
    public void setup() {
    	mockMvc =
    			MockMvcBuilders.webAppContextSetup(this.wac).build(); //2
    	}
	
	@Test
	public void testNormalController() throws Exception{
    	String exp_str = demoService.saySomething(); // expect str
		mockMvc.perform(get("/normal")) //8 模拟GET /normal
				.andExpect(status().isOk())//9 预期返回状态为200
				.andExpect(view().name("page"))//10 预期view的名称
				.andExpect(forwardedUrl("/WEB-INF/classes/views/page.jsp"))//11 预期页面转向的真正路径
				.andExpect(model().attribute("msg", exp_str));//12 预期model里的值
				
	}
	
	@Test
	public void testRestController() throws Exception{
		mockMvc.perform(get("/testRest")) //13 GET
        .andExpect(status().isOk())
         .andExpect(content().contentType("text/plain;charset=UTF-8"))//14
        .andExpect(content().string(demoService.saySomething()));//15
	}

}
