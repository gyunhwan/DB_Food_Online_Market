package com.food.biz.member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class MemberMonthTotalVO {
	private String member_email;
	private int buy_month;
	private int buy_total;
}
