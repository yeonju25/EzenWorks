package com.saeyan.controller;

import java.io.File;
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

@WebServlet("/productWrite.do")
public class ProductWriterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "product/productWrite.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ServletContext context = getServletContext();
		String path = context.getRealPath("upload");
		String encType = "utf-8";
		int sizeLimit = 20*1024*1024;	// 20M
		
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, 
									encType, new DefaultFileRenamePolicy());
		
		// 텍스트가 아닌 파일도 받아오기 때문에 멀티로 다 받아와서 getParameter와 getFile로 받아와서 저장
		String name = multi.getParameter("name");
		int price = Integer.parseInt(multi.getParameter("price"));
		String pictureUrl = multi.getFilesystemName("pictureUrl");
		String description = multi.getParameter("description");
		
		// vo에 저장
		ProductVO vo = new ProductVO();
		vo.setName(name);
		vo.setPrice(price);
		vo.setPictureUrl(pictureUrl);
		vo.setDescription(description);
		
		ProductDAO pDao = ProductDAO.getInstance();
		int result = pDao.insertProduct(vo);
		
		if(result == 1) {
			response.sendRedirect("productList.do");
		}
	}

}
