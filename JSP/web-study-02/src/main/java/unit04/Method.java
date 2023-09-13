package unit04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MethodServlet")
public class Method extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf8");
		
		PrintWriter out = response.getWriter();
		out.print("<h1>get방식으로 응답</h1>");
		out.close();
		// 조회, 검색 등은 get방식 사용
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf8");
		
		PrintWriter out = response.getWriter();
		out.print("<h1>post방식으로 응답</h1>");
		out.close();
		// 수정하거나 내용을 변경해야 할 때 post방j식 사용
	}

}
