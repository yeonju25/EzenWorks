package com.saeyan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/upload.do")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String savePath = "upload";				// 저장 경로
		int uploadFileSizeLimit = 5*1024*1024;	// 업로드 파일 크기 5M제한
		String encType = "utf-8";
		
		ServletContext context = getServletContext();
		String uploadPath = context.getRealPath(savePath);
		
		System.out.println("서버상 실제 디렉토리 : " + uploadPath);
		
		try {
			MultipartRequest multi = new MultipartRequest(
										request, uploadPath, uploadFileSizeLimit, 
										encType, new DefaultFileRenamePolicy());
						// 요청, 실제 경로, 파일 크기, 인코딩방법(저 자리에 바로 utf-8 넣어도 됨), 파일이 중복됐을 때 자동 이름 바꿈 
			
			
			Enumeration files =  multi.getFileNames();
			
			while(files.hasMoreElements()) {
				String file = (String)files.nextElement();
				String file_name = multi.getFilesystemName(file);
				
				String ori_file_name = multi.getOriginalFileName(file);
				out.print("<br> 업로드된 파일명 : " + file_name);
				out.print("<br> 원본 파일명 : " + ori_file_name);
			}
			
			// 파일 하나만 올릴 때
//			String fileName = multi.getFilesystemName("uploadFile");
//			if(fileName == null) {
//				System.out.println("파일 업로드 실패");
//			}else {
//				out.print("<br> 글쓴이 : " + multi.getParameter("name"));
//				out.print("<br> 제 목 : " + multi.getParameter("title"));
//				out.print("<br> 파일명 : " + fileName);
//			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
