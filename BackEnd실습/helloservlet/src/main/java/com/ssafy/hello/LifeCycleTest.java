package com.ssafy.hello;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LifeCycleTest")
public class LifeCycleTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LifeCycleTest() {
        super();
        System.out.println("객체 생성합니다.");
    }
    
    

	@Override
	public void destroy() { 
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("객체 제거합니다.");
	}



	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("객체 초기화합니다.");
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("클라이언트 요청 서비스합니다.");
	}

}

/**
 * 클래스니까 생성자가 호출되고,자동으로 init() 메서드가 호출된다.
 * client한테 서비스가 호출된다.
 * 클라이언트가 계속 들어와도 초기화는 1번만 한다. -> 결론: 서블릿 객체는 한개만 만들어진다.
 * thread는 누가 관리해주나? -> was가 알아서 관리해준다 (was 의 thread pool)
 * destroy()는 언제 호출되나? -> 객체 생성하고 초기화 작업을 다시 하기 전에 destroy()를 한다.
 */