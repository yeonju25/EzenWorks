package com.saeyan.javabeans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

//@ToString
//@AllArgsConstructor		// 생성자
//@NoArgsConstructor		// 빈 생성자
//// 추가되어있지만 화면상에만 보이지 않는 것
//@Data	 // 위에 꺼 다 쓰기도 귀찮으면 이거 쓰면 대충 알아서 만들어줌
public class MemberBean {
	private String name;
	private String userid;
	private String nickname;
	private String pwd;
	private String email;
	private String phone;
	
	
}
