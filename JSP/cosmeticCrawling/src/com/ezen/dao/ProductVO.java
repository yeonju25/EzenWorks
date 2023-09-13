package com.ezen.dao;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductVO {
	private int code;
	private String name;
	private String image;
	private String price;
	private String description;
	
}
