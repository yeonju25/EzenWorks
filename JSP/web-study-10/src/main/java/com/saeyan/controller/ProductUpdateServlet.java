package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.saeyan.dto.ProductDAO;
import com.saeyan.dto.ProductVO;

@WebServlet("/productUpdate.do")
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int code = Integer.parseInt(request.getParameter("code"));
		
		ProductDAO pDao = ProductDAO.getInstance();
		ProductVO vo = pDao.getProduct(code);
		request.setAttribute("product", vo);
		
		String url = "product/productUpdate.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
		
		
		
//		ProductDAO pDao = ProductDAO.getInstance();
//		ProductVO vo = pDao.getProduct("${product.code}");
					// 표현식은 jsp 보여줄때 써야하지 서블릿에서 쓰니까 안되지 흑흑흑
//		request.setAttribute("product", vo);
//		
//		HttpSession session = request.getSession();
//		session.setAttribute("product", vo);
//		
//		String url = "product/productUpdate.jsp";
//		RequestDispatcher dis = request.getRequestDispatcher(url);
//		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		String path = context.getRealPath("upload");
		String encType = "utf-8";
		int sizeLimit = 20*1024*1024;	// 20M
		
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, 
									encType, new DefaultFileRenamePolicy());
		
		// productUpdate.jsp에서 히든으로 날려주는 코드값을 받아줘야 한다.
		int code = Integer.parseInt(multi.getParameter("code"));
		
		String name = multi.getParameter("name");
		int price = Integer.parseInt(multi.getParameter("price"));
		String pictureUrl = multi.getFilesystemName("pictureUrl");
		String description = multi.getParameter("description");
		
		// 사진을 수정하지 않았을 때 기존 사진을 가져와서 쓰게 하는 용도
		if(pictureUrl == null) {
			pictureUrl = multi.getParameter("nonmakeImg");
		}
		
		// vo에 저장
		ProductVO vo = new ProductVO();
		vo.setCode(code);
		vo.setName(name);
		vo.setPrice(price);
		vo.setPictureUrl(pictureUrl);
		vo.setDescription(description);
		ProductDAO pDao = ProductDAO.getInstance();
		int result = pDao.updateProduct(vo);
		
		if(result == 1) {
			response.sendRedirect("productList.do");
		}
		
	}

}
