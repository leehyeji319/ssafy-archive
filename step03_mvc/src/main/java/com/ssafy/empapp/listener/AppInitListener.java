package com.ssafy.empapp.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class AppInitListener implements ServletContextListener {

    public AppInitListener() {
    }


    public void contextDestroyed(ServletContextEvent sce)  { 
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	//1ㄷ1 대응되는 서블릿컨텍스트생성
    	ServletContext application = sce.getServletContext();
    	String root = application.getContextPath();
    	application.setAttribute("root", root);
    	System.out.println("root set...");
    }
	
}
