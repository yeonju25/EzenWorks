package com.saeyan.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BoardVO {
	private int num;
	private String pass;
	private String name;
	private String email;
	private String title;
	private String content;
	private int readcount;
	private Timestamp writedate;
}
