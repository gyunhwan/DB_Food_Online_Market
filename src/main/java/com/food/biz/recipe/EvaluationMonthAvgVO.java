package com.food.biz.recipe;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class EvaluationMonthAvgVO {
	private int recipe_code;
	private int evaluation_month;
	private int evaluation_avg_point;
	private int evaluation_count;
}
