package com.saeyan.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
// MemberVO는 로그인 정보들을 담으려는 용도
public class MemberVO {
	private String name;
	private String userid;
	private String pwd;
	private String email;
	private String phone;
	private int admin;
}
