

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class BoardWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		super.init();
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 
		 } catch (ClassNotFoundException e) {
			 e.printStackTrace();
		 }
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		//1. date get
		//userId는 클라이언트가 입력을 한 아이디,제목,내용을 얻어와야한다.
		request.setCharacterEncoding("utf-8"); //get방식이 아니라 post방식일때만 된다.
		String userId = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		System.out.println(userId + "  " + subject + "  " + content);
		
		//2. logic
		
		//3. response page
	}


}
