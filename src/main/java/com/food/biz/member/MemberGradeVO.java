package com.food.biz.member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class MemberGradeVO {
	private int member_grade_code;
	private String member_grade_name;
	private int member_grade_rate;
	private int member_grade_price;
}
