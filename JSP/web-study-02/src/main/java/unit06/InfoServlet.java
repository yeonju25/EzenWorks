package unit06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InfoServlet")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=utf8");
		String n = request.getParameter("name");
		String a = request.getParameter("addr");
		
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.println("당신이 입력한 정보입니다.<br>");
		out.println("이름 : ");
		out.println(n);
		out.println("<br> 주소 : ");
		out.println(a);
		
		out.println("<br><a href='javascript:history.go(-1)'>다시</a>");
		out.print("</body></html>");
		out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// utf-8로 변환하는 과정을 거쳐야 한글이 깨지지 않고 출력된다.
		// get은 request.setCharacterEncoding("utf-8")이 내장되어 있지만,
		// post 방식은 그렇지 않아서 추가해줘야 한다.
		// 해당 라인이 출력 라인보다 위에 있어야 정상적으로 한글이 나온다. 아래에 위치하면 안됨!
		
		doGet(request, response);
	}

}
