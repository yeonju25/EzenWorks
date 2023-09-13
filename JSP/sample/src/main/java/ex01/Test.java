package ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/info")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 글자가 깨질 때 이거 넣어줌...
		response.setContentType("text/html; charset=utf-8");
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		
		//http://localhost:8081/sample/info?name=kim&age=30
		// 1. 서블릿 통해서만 출력 : 서블릿으로 클라이언트 요청받아서 출력까지 담당
//		PrintWriter out = response.getWriter();
//		out.print("이름 : " + name + "<br>");
//		out.print("나이 : " + age + "<br>");
		
		// 이거는 콘솔에 찍으려고 프린트해본거~
		System.out.println(name);
		System.out.println(age);
		
		// 2. jsp를 통해서 출력 : 요청 서블릿, 출력 jsp
		request.setAttribute("n", name);
		request.setAttribute("a", age);
		
		RequestDispatcher dis = request.getRequestDispatcher("test01.jsp");
		dis.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
