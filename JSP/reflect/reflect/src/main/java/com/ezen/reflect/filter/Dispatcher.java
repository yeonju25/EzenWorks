package com.ezen.reflect.filter;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.reflect.ano.RequestMapping;
import com.ezen.reflect.controller.UserController;

public class Dispatcher implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
//		System.out.println("�������� ����?");
		
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		
		// ��û Ȯ��
//		System.out.println("������ �н� : " + request.getContextPath());
//		System.out.println("�ĺ��� �ּ� : " + request.getRequestURI());
//		System.out.println("��ü �ּ� : " + request.getRequestURL());
		
		// user�Ľ��ϱ�
		String endPoint = request.getRequestURI().replaceAll(request.getContextPath(), "");
		System.out.println("endPoint : " + endPoint);
		
		UserController userController = new UserController();
		
		Method[] methods = userController.getClass().getDeclaredMethods();
		
//		System.out.println(methods);
		
		for(Method m : methods) {
//			System.out.println(m.getName());
			Annotation annotation = m.getDeclaredAnnotation(RequestMapping.class);
			RequestMapping mapping = (RequestMapping)annotation;
//			System.out.println(mapping.value());
			
			if(mapping.value().equals(endPoint)) {
				try {
					String path = (String)m.invoke(userController);	
					RequestDispatcher dis = request.getRequestDispatcher(path);
					dis.forward(request, response);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		
		
	}
	
}
