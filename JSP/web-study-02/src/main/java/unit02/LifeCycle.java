package unit02;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cycle")
public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	int initCount = 1;
	int doGetCount = 1;
	int destroyCount = 1;
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메소드 요청 : " + initCount++);
	}

	public void destroy() {
		System.out.println("destroy 메소드 요청 : " + destroyCount++);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 메소드 요청 : " + doGetCount++);
	}

}
