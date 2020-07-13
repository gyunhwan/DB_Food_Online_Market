package com.food.biz.supplier;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class SupplierMonthTotalVO {
	private String supplier_business_number;
	private int sell_month;
	private int sell_total;
}
