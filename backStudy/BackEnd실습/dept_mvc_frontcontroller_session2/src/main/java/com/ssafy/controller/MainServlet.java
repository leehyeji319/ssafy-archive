package com.ssafy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.model.dto.DataInfo;
import com.ssafy.model.dto.PageInfo;


@WebServlet(loadOnStartup = 1,urlPatterns = {"*.do", "*.ssafy"})
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String root;
	
	private UserController userController = new UserController();
	private DeptController deptController = new DeptController();
	private HomeController homeController = new HomeController();


	@Override
	public void init() throws ServletException {
		getServletContext().setAttribute("root", getServletContext().getContextPath());
		System.out.println("root set as [" + getServletContext().getAttribute("root") + "]");
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

		if(url.startsWith("/dept")) {
			HttpSession session = request.getSession();
			if(session.getAttribute("userId") == null) {
				System.out.println("로그인 안됨!!");
				response.sendRedirect(request.getContextPath() + "/user/login_form.do");
				return;
			}
		}
	
		Object result = null;
		try {
			Controller controller = null;
			if (url.startsWith("/user")) {
				controller = userController;
				
			} else if (url.startsWith("/dept")) {
				controller = deptController;
			} else {
				controller = homeController;
			}
			
			if (controller != null) {
				result = controller.handleRequest(request, response);
			} 
			
			if (result instanceof PageInfo) {
				PageInfo pageInfo = (PageInfo) result;
				if(pageInfo.isForward())
					request.getRequestDispatcher(pageInfo.getPage()).forward(request, response);
				else {
					response.sendRedirect(request.getContextPath() + pageInfo.getPage());
				}
			} else if (result instanceof DataInfo) {
				DataInfo dataInfo = (DataInfo) result;
				response.setContentType(dataInfo.getContentType());
				if (dataInfo.getContentType().equals("application/json")) {
					ObjectMapper mapper = new ObjectMapper();
					String value = mapper.writeValueAsString(dataInfo.getData()); //js stringify
					
					response.getWriter().println(value);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			if (result instanceof PageInfo) {
			request.setAttribute("errorMsg", e.getMessage());
			request.getRequestDispatcher("../error.jsp").forward(request, response);
			return;
			} else {
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
		}

		return;
	}
}
