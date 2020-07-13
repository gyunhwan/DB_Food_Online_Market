package com.food.biz.member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class MemberVO {
	private String member_email;
	private int member_grade_code;
	private String member_pw;
	private String member_name;
	private String member_tel;
	private int admin;
	
}
