package unit01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Add")
public class AdditionServlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
										// 요청							응답
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// servlet = java 코드 안에 html
		int num1 = 20;
		int num2 = 10;
//		int num1 = Integer.parseInt(request.getParameter("num1"));
//		int num2 = Integer.parseInt(request.getParameter("num2"));
		// http://localhost:8081/web-study-01/Add?num1=100&num2=200 
		// 인터넷 창에 이렇게 치면 num1 = 100 num2 = 200인 것
		
		int add = num1 + num2;
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Additon</title></head>");
		out.println("<body>");
		out.println(num1 + " + " + num2 + " = " +add);
		out.println("</body>");
		out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
