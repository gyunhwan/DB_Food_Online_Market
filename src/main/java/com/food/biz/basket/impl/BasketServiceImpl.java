package com.food.biz.basket.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.biz.basket.BasketService;
import com.food.biz.basket.BasketVO;
import com.food.biz.supplier.SupplierFoodVO;

@Service
public class BasketServiceImpl implements BasketService{

	@Autowired
	BasketDAO basketDAO;
	
	@Override
	public int insertBasket(BasketVO vo) {
		// TODO Auto-generated method stub
		return basketDAO.insertBasket(vo);
	}

	@Override
	public int insertBasketDetail(BasketVO vo) {
		// TODO Auto-generated method stub
		return basketDAO.insertBasketDetail(vo);
	}

	@Override
	public BasketVO getBasketCode(BasketVO vo) {
		// TODO Auto-generated method stub
		return basketDAO.getBasketCode(vo);
	}

	@Override
	public BasketVO detailCheck(BasketVO vo) {
		// TODO Auto-generated method stub
		return basketDAO.detailCheck(vo);
	}

	@Override
	public int increase(BasketVO vo) {
		// TODO Auto-generated method stub
		return basketDAO.increase(vo);
	}

	@Override
	public List<SupplierFoodVO> basketList(SupplierFoodVO vo) {
		// TODO Auto-generated method stub
		return basketDAO.basketList(vo);
	}

	@Override
	public int deleteOrderBasketDetail(BasketVO vo) {
		// TODO Auto-generated method stub
		return basketDAO.deleteOrderBasketDetail(vo);
	}
	
	@Override
	public int deleteOrderBasketDetail2(BasketVO vo) {
		// TODO Auto-generated method stub
		return basketDAO.deleteOrderBasketDetail2(vo);
	}

	@Override
	public int decrease(BasketVO vo) {
		// TODO Auto-generated method stub
		return basketDAO.decrease(vo);
	}

}
