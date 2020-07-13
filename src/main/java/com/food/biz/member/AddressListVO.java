package com.food.biz.member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class AddressListVO {
	private int address_code;
	private String member_email;
	private String address;
	private String address_detail;
	private int post_number;
}
