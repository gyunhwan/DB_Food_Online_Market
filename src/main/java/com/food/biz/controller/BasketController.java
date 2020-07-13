package com.food.biz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.food.biz.basket.BasketService;
import com.food.biz.basket.BasketVO;
import com.food.biz.supplier.SupplierFoodVO;

@Controller
public class BasketController {

	@Autowired
	BasketService basketService;
	
	@RequestMapping(value = "/insertBasket.do")
	public String insertBasket(BasketVO vo) {
		System.out.println("��ٱ��� ���");
		BasketVO code = new BasketVO();
		code = basketService.getBasketCode(vo);
		if(code==null) {
		basketService.insertBasket(vo);
		code = basketService.getBasketCode(vo);
		}
		vo.setBasket_code(code.getBasket_code());
		if(basketService.detailCheck(vo)==null) {
		basketService.insertBasketDetail(vo);
		}else {
			basketService.increase(vo); 
		}
		return "supplierFoodDetail.do";
	}
	
	@RequestMapping(value="basketList.do")
	public ModelAndView basketList(ModelAndView mav,SupplierFoodVO vo) {
		System.out.println("��ٱ��� ����Ʈ ��ȸ");
		mav.addObject("page","basket.jsp");
		mav.addObject("basketList",basketService.basketList(vo));
		mav.setViewName("index.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/basketIncrease.do")
	public String basketIncrease(BasketVO vo) {
		System.out.println("��ٱ��� ��� ����");
		basketService.increase(vo);
		return "basketList.do";
	}
	
	@RequestMapping(value = "/basketDecrease.do")
	public String basketDecrease(BasketVO vo) {
		System.out.println("��ٱ��� ��� ����");
		basketService.decrease(vo);
		return "basketList.do";
	}
	
	@RequestMapping(value = "/deleteBasket.do")
	public String deleteBasket(BasketVO vo) {
		System.out.println("��ٱ��� ��� ����");
		basketService.deleteOrderBasketDetail2(vo);
		return "basketList.do";
	}
}
