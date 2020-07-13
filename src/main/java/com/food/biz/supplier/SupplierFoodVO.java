package com.food.biz.supplier;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class SupplierFoodVO {
	private int supplier_food_code;
	private String supplier_business_number;
	private int food_code;
	private String supplier_food_name;
	private String supplier_food_image;
	private String supplier_food_comment;
	private String supplier_food_stock;
	private String supplier_food_yesno;
	private int supplier_food_price;
	private String supplier_food_unit;
	
	private String member_email;
	private int basket_detail_amount=1;
	private int basket_code;
	private int basket_detail_code;
}
