package com.ssafy.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//url pattern: 주소에다가 이렇게 쓰면 들어옵니다.

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	public void init() {
		name = "이혜지";
	}
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1. data get 
		
		
//		2. logic
//		3. response page ==> html
		//아래처럼 하면 한글 나와야하는데 왜 안되지?: 데이터의 통로를 뚫어놨음 PrintWriter 순서를 잘 해라 ~
		response.setContentType("text/html;charset=utf-8"); //한방에 처리하기
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");
		out.println("		<h2>Hello Servlet!!!</h2>");
		//한글이 깨짐 왜 ? -> 톰캣은 iso-8859를 쓰는데 한글 인식을 못함
		out.println("		<h2>" + name + "님 안녕하세요!! </h2>");
		out.println("	</body>");
		out.println("</html>");
	}
}

/*
 * servlet : html in java 이며, *.java
 * jsp: java in html 이며, *.jsp 이다.
 * 
 * client의 요청이 오면 init() 호출하고 service()하고 destroy() 끝냄
 * */
