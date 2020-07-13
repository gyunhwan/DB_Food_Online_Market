package com.food.biz.supplier;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class SupplierGradeVO {
	private int supplier_grade_code;
	private String supplier_grade_name;
	private int supplier_grade_frequency;
}
