package com.food.biz.basket;

import java.util.List;

import com.food.biz.supplier.SupplierFoodVO;

public interface BasketService {
	int insertBasket(BasketVO vo);
	
	int insertBasketDetail(BasketVO vo);
	
	BasketVO getBasketCode(BasketVO vo);
	
	BasketVO detailCheck(BasketVO vo);
	
	int increase(BasketVO vo);
	
	int decrease(BasketVO vo);
	
	List<SupplierFoodVO> basketList(SupplierFoodVO vo);
	
	int deleteOrderBasketDetail(BasketVO vo);
	
	int deleteOrderBasketDetail2(BasketVO vo);
}
