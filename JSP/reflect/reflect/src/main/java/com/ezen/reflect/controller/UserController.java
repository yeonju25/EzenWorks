package com.ezen.reflect.controller;

import com.ezen.reflect.ano.RequestMapping;

public class UserController {
	
	@RequestMapping("/user/join2")
	public String join() {
		System.out.println("join()함수 호출");
		return "/";
	}
	
	@RequestMapping("/user/login2")
	public String login() {
		System.out.println("login()함수 호출");
		return "/";
	}
	
	@RequestMapping("/user/user2")
	public String user() {
		System.out.println("user()함수 호출");
		return "/";
	}

	@RequestMapping("/user/hello2")
	public String hello() {
		System.out.println("hello()함수 호출");
		return "/";
	}
	
	@RequestMapping("/user/del")
	public String delete() {
		System.out.println("delete()함수 호출");
		return "/delete.jsp";
	}
	
}
