package com.food.biz.supplier;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CalVO {
	private int cal_code;
	private String supplier_business_number;
	private String cal_date;
	private int cal_price;

	private int supplier_grade_code;
	private String supplier_grade_name;
	private int supplier_grade_frequency;

	private int lastDate;
}
