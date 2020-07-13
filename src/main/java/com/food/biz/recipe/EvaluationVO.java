package com.food.biz.recipe;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class EvaluationVO {
	private int evaluation_code;
	private String member_email;
	private int recipe_code;
	private String evaluation_comment;
	private int evaluation_point;
	private int evaluation_month;
}
