package com.ssafy.sample.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.sample.model.dto.PageInfo;


@WebServlet(loadOnStartup = 1, urlPatterns = {"*.do"})
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductController productController = new ProductController();
	private UserController userController = new UserController();
	private HomeController homeController = new HomeController();
	private String root;
	
       
	


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

		if (url.startsWith("/product")) {
			
			//== 로그인 세션 ==//
			HttpSession session = request.getSession();
			if (session.getAttribute("userId") == null) {
				System.out.println("로그인이 필요합니다.");
				response.sendRedirect(request.getContextPath() + "/user/login.jsp");
				return;
			}
		} 
		
		Object result = null;
		
		try {
			//분기 처리
			Controller controller = null;
			if (url.startsWith("/product")) {
				controller = productController;
				
			} else if (url.startsWith("/user")) {
				controller = userController;
			} else {
				controller = homeController;
			}
			
			if (controller != null) {
				result = controller.handleRequest(request, response);
			}
			
			if (result instanceof PageInfo) {
				
				PageInfo pageInfo = (PageInfo) result;
				if (pageInfo.isForward()) {
					request.getRequestDispatcher(pageInfo.getPage()).forward(request, response) ;
					return;
				} else {
					response.sendRedirect(root + pageInfo.getPage());
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			if (result instanceof PageInfo) {
				request.setAttribute("errorMsg", e.getMessage());
				request.getRequestDispatcher("/error/error.jsp").forward(request, response);
			} else {
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
			return;
		}
	}

}
