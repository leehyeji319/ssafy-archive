package com.ssafy.empapp.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.empapp.model.dto.DataInfo;
import com.ssafy.empapp.model.dto.PageInfo;

@WebServlet(loadOnStartup = 1, urlPatterns = {"*.do", "*.ssafy"} )
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String root;
	
	private UserController userController = new UserController();
	private DeptController deptController = new DeptController();
	private HomeController homeController = new HomeController();
	
	@Override
    public void init() throws ServletException {
        ServletContext application = getServletContext();
        root = application.getContextPath();
        application.setAttribute("root", root);
        System.out.println("root set...");
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getServletPath();
		System.out.println("url : " + url);

		if (url.startsWith("/dept")) {
            HttpSession session = request.getSession();
            if (session.getAttribute("userId") == null) {
                System.out.println("로그인 안 됨!!");
                response.sendRedirect(root + "/user/login_form.do");
                return;
            }
        }
		
		Controller controller = null;
		Object result = null;
		try {
			if(url.startsWith("/user")) {
				controller = userController;
			}
			else if(url.startsWith("/dept")) {
				controller = deptController;
			}
			else {
				controller = homeController;
			}
			
			if(controller != null) {
				result = controller.handleRequest(request, response);
			}
			
			if(result instanceof PageInfo) {
				PageInfo pageInfo = (PageInfo)result;
				if(pageInfo.isForward()) {
					request.getRequestDispatcher(pageInfo.getPage()).forward(request, response);
					return;
				}
				else {
					response.sendRedirect(request.getContextPath() + pageInfo.getPage());
				}
			}
			else if(result instanceof DataInfo) {
				DataInfo dataInfo = (DataInfo)result;
				response.setContentType(dataInfo.getContentType());
				if(dataInfo.getContentType().equals("application/json")) {
					ObjectMapper mapper = new ObjectMapper();
					String value = mapper.writeValueAsString(dataInfo.getData());
					
					response.getWriter().println(value);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			if(result instanceof PageInfo) {
				request.setAttribute("errorMsg", e.getMessage());
				request.getRequestDispatcher("../error.jsp").forward(request, response);
				return;
			}
			else if(result instanceof DataInfo) {
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
		}
		
	}
}
