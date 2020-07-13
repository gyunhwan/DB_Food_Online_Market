package com.food.biz.basket;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class BasketVO {
	private int basket_code;
	private String member_email;
	
	private int basket_detail_code;
	private int supplier_food_code;
	private int basket_detail_amount;
}
