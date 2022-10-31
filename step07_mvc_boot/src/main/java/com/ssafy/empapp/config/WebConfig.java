package com.ssafy.empapp.config;

import javax.servlet.ServletContextListener;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.empapp.controller.interceptor.LoginCheckInterceptor;
import com.ssafy.empapp.listener.AppInitListener;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Bean
	public ServletListenerRegistrationBean<ServletContextListener> AppInitListener() {
		ServletListenerRegistrationBean<ServletContextListener> srb 
		= new ServletListenerRegistrationBean<>();
		
		srb.setListener(new AppInitListener());
		return srb;
		
	}

	//WebMvcConfigurer 임플리해서
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/user/login_form.do").setViewName("user/login");
		registry.addViewController("/user/register_form.do").setViewName("dept/register_form");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginCheckInterceptor()).addPathPatterns("/dept/**"); //가변인자
	}
}
