package com.food.biz.member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class CardListVO {
	private int card_code;
	private String member_email;
	private String card_number;
	private String card_date;
	private String card_kind;
}
