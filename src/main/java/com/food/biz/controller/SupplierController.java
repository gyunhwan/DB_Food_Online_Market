package com.food.biz.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.food.biz.order.OrderVO;
import com.food.biz.supplier.CalVO;
import com.food.biz.supplier.SupplierFoodVO;
import com.food.biz.supplier.SupplierService;
import com.food.biz.supplier.SupplierVO;

@Controller
public class SupplierController {

	@Autowired
	SupplierService supplierService;
	
	@RequestMapping(value = "/supplierLogin.do")
	public String login(SupplierVO vo, HttpSession session) {
		System.out.println("supplier �α��� ó��");
		SupplierVO supplier = supplierService.supplierLogin(vo);
		if (supplier!=null) {
			session.setAttribute("supplier_business_number", supplier.getSupplier_business_number());
			session.setAttribute("supplier_name", supplier.getSupplier_name());
			return "supplierPersonalFoodList.do";
		} else {
			return "supplierLogin.jsp";
		}
	}
	

	@RequestMapping(value="supplierFoodList.do")
	public ModelAndView supplierFoodList(ModelAndView mav) {
		System.out.println("������ ������ ����Ʈ ��ȸ");
		mav.addObject("page","foodList.jsp");
		mav.addObject("supplierFoodList",supplierService.supplierFoodList());
		mav.setViewName("index.jsp");
		return mav;
	}
	
	@RequestMapping(value="supplierFoodDetail.do")
	public ModelAndView supplierFoodDetail(ModelAndView mav,SupplierFoodVO vo) {
		System.out.println("������ ������ �� ��ȸ");
		mav.addObject("page","foodDetail.jsp");
		mav.addObject("supplierFood",supplierService.supplierFoodDetail(vo));
		mav.setViewName("index.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/supplierJoin.do")
	public String join(SupplierVO vo) {
		supplierService.join(vo);
		return "supplierLogin.jsp";
	}
	
	@RequestMapping(value = "/insertSupplierFood.do")
	public String insertSupplierFood(SupplierFoodVO vo) {
		System.out.println("������ ������ ��û");
		supplierService.insertSupplierFood(vo);
		return "supplierPersonalFoodList.do";
	}
	
	@RequestMapping(value="supplierFoodSearch.do")
	public ModelAndView supplierFoodSearch(ModelAndView mav,SupplierFoodVO vo) {
		System.out.println("������ ������ ����Ʈ �˻�");
		mav.addObject("supplierFoodList",supplierService.supplierFoodSearch(vo));
		mav.setViewName("foodList.jsp");
		return mav;
	}
	
	@RequestMapping(value="supplierPersonalFoodList.do")
	public ModelAndView supplierPersonalFoodList(ModelAndView mav,SupplierFoodVO vo) {
		System.out.println("������ ��� ������ ����Ʈ");
		mav.addObject("foodList",supplierService.supplierPersonalFoodList(vo));
		mav.setViewName("supplierFoodList.jsp");
		return mav;
	}
	
	@RequestMapping(value="supplierInfoUpdatePage.do")
	public ModelAndView supplierInfoUpdatePage(ModelAndView mav,SupplierVO vo) {
		System.out.println("������ ���� ���� ���� ȭ��");
		mav.addObject("supplierInfo",supplierService.supplierInfoUpdatePage(vo));
		mav.setViewName("supplierInfoUpdate.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/supplierInfoUpdate.do")
	public String supplierInfoUpdate(SupplierVO vo) {
		supplierService.supplierInfoUpdate(vo);
		return "supplierPersonalFoodList.do";
	}
	@RequestMapping(value = "/supplierCalPage.do")
	   public ModelAndView supplierCalPage(ModelAndView mav,CalVO vo) {
	      System.out.println("공급자 정산 화면");
	      if(supplierService.checkCal(vo).isEmpty()) {
	         System.out.println("1");
	         mav.addObject("lastDate","0");
	         mav.addObject("frequency",10);
	      }else {
	         System.out.println("2");
	         List<CalVO> list = new ArrayList<CalVO>();
	         list = supplierService.checkCal(vo);
	         String lastDate = list.get(0).getCal_date();
	         mav.addObject("lastDate",lastDate.substring(8, 10));
	         mav.addObject("frequency",list.get(0).getSupplier_grade_frequency());
	      }
	      mav.addObject("calList",supplierService.checkCal(vo));
	      mav.setViewName("supplierCal.jsp");
	      return mav;
	   }
	   
	   @RequestMapping(value = "/supplierCal.do")
	   public String supplierCal(CalVO vo) {
	      OrderVO supplier = new OrderVO();
	      supplier.setSupplier_business_number(vo.getSupplier_business_number());
	      List<OrderVO> list = new ArrayList<OrderVO>();
	      list = supplierService.calSelect(supplier);
	      int day=0;
	      int sum=0;
	      for(OrderVO order : list) {
	         day=Integer.parseInt(order.getOrder_date().substring(5, 7));
	         if(vo.getLastDate()<day) {
	            sum +=(order.getOrder_detail_price()*order.getOrder_detail_amount());
	            System.out.println(sum);
	         }
	      }
	      vo.setCal_price((int)(sum*0.95));
	      supplierService.insertCal(vo);
	      return "supplierCalPage.do";
	   }
}
