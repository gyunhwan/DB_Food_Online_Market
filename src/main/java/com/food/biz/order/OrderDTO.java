package com.food.biz.order;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Data
@Getter@Setter@ToString
public class OrderDTO {
	String member_email;
	int recipe_code;
}
