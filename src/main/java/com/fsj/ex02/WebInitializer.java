package com.fsj.ex02;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
//1 实现此接口将自动被SpringServletContainerInitializer获取到。
// 替代web.xml的位置
public class WebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(MyMvcConfig.class);
        ctx.setServletContext(servletContext); //2 关联当前的servletContext
        Dynamic servlet = servletContext.addServlet("dispatcher",
                new DispatcherServlet(ctx)); //3 注册Spring MVC的DispatcherServlet。

        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
	}

}
