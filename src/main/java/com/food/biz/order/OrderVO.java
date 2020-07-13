package com.food.biz.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class OrderVO {
	private int order_code;
	private String member_email;
	private String order_date;
	private int order_total;
	private String order_address;
	private String order_address_detail;
	private String order_state;
	private int member_grade_code;
	private int order_detail_code;
	private int supplier_food_code;
	private int order_detail_price;
	private int order_detail_amount;
	
	private int address_code;
	private int card_code;
	private String supplier_business_number;
	private int food_code;
	private String supplier_food_name;
	private String supplier_food_image;
	private String supplier_food_comment;
	private String supplier_food_stock;
	private String supplier_food_yesno;
	private int supplier_food_price;
	private String supplier_food_unit;
	
	private int sell_month;
	private int sell_total;
	
	private int buy_month;
	private int buy_total;
}
