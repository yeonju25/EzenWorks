package com.ezen.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberVO {
	private Integer code;
	private String title;
	private Integer price;
	private String director;
	private String actor;
	private String poster;
	private String synopsis;
}
