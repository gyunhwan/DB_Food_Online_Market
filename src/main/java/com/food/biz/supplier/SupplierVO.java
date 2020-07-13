package com.food.biz.supplier;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class SupplierVO {
	private String supplier_business_number;
	private int supplier_grade_code;
	private String supplier_pw;
	private String supplier_name;
	private String supplier_tel;
}
