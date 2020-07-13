package com.food.biz.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.food.biz.food.FoodService;
import com.food.biz.member.AddressListVO;
import com.food.biz.member.CardListVO;
import com.food.biz.member.MemberService;
import com.food.biz.member.MemberVO;
import com.food.biz.order.OrderVO;
import com.food.biz.supplier.SupplierFoodVO;
import com.food.biz.supplier.SupplierService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	SupplierService supplierService;
	
	@Autowired
	FoodService foodService;
	
	@RequestMapping(value = "/memberLogin.do")
	public String login(MemberVO vo, HttpSession session) {
		System.out.println("member 로그인 처리");
		MemberVO member = memberService.memberLogin(vo);
		if (member!=null) {
			session.setAttribute("member_email", member.getMember_email());
			session.setAttribute("member_name", member.getMember_name());
			session.setAttribute("member_grade_code",member.getMember_grade_code());
			session.setAttribute("admin",member.getAdmin());
			return "recipeList.do";
		} else {
			return "memberLogin.jsp";
		}
	}
	
	@RequestMapping(value = "/memberJoin.do")
	public String join(MemberVO vo) {
		memberService.join(vo);
		return "memberLogin.jsp";
	}
	
	@RequestMapping(value="logout.do")
	public String logout(HttpSession session) {
		System.out.println("로그아웃 처리");
		session.invalidate();
		return "recipeList.do";
	}
	
	@RequestMapping(value = "/insertAddress.do")
	public String insertAddress(AddressListVO vo) {
		memberService.insertAddress(vo);
		return "addressList.do";
	}
	
	@RequestMapping(value="addressList.do")
	public ModelAndView addressList(ModelAndView mav,AddressListVO vo) {
		System.out.println("배송지 리스트");
		mav.addObject("page","addressList.jsp");
		mav.addObject("addressList",memberService.addressList(vo));
		mav.setViewName("index.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/deleteAddress.do")
	public String deleteAddress(AddressListVO vo) {
		System.out.println("배송지 삭제");
		memberService.deleteAddress(vo);
		return "addressList.do";
	}
	
	
	@RequestMapping(value = "/insertCard.do")
	public String insertCard(CardListVO vo) {
		memberService.insertCard(vo);
		return "cardList.do";
	}
	
	@RequestMapping(value="cardList.do")
	public ModelAndView cardList(ModelAndView mav,CardListVO vo) {
		System.out.println("카드 리스트");
		mav.addObject("page","cardList.jsp");
		mav.addObject("cardList",memberService.cardList(vo));
		mav.setViewName("index.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/deleteCard.do")
	public String deleteCard(CardListVO vo) {
		memberService.deleteCard(vo);
		return "cardList.do";
	}
	
	@RequestMapping(value="getOrderList.do")
	public ModelAndView getOrderList(ModelAndView mav,OrderVO vo) {
		System.out.println("유저 주문 목록");
		mav.addObject("page","memberOrderList.jsp");
		mav.addObject("orderList",memberService.getOrderList(vo));
		mav.setViewName("index.jsp");
		return mav;
	}
	
	@RequestMapping(value="foodYesNo.do")
	public ModelAndView foodYesNo(ModelAndView mav,SupplierFoodVO vo) {
		System.out.println("식자재 승인 요청 목록");
		mav.addObject("page","foodYesNo.jsp");
		mav.addObject("foodList",supplierService.foodYesNo(vo));
		mav.setViewName("index.jsp");
		return mav;
	}
	
	@RequestMapping(value="foodYesNoDetail.do")
	public ModelAndView foodYesNoDetail(ModelAndView mav,SupplierFoodVO vo) {
		System.out.println("식자재 승인 요청 상세 목록");
		mav.addObject("foodList", foodService.getFoodList());
		mav.addObject("page","foodYesNoDetail.jsp");
		mav.addObject("food",memberService.foodYesNoDetail(vo));
		mav.setViewName("index.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/foodYes.do")
	public String foodYes(SupplierFoodVO vo) {
		memberService.foodYes(vo);
		supplierService.updateFoodCode(vo);
		return "foodYesNo.do";
	}
	
	@RequestMapping(value = "/foodNo.do")
	public String foodNo(SupplierFoodVO vo) {
		memberService.foodNo(vo);
		return "foodYesNo.do";
	}
	
	@RequestMapping(value="memberInfoUpdatePage.do")
	public ModelAndView memberInfoUpdatePage(ModelAndView mav,MemberVO vo) {
		System.out.println("회원 개인 정보 수정 화면");
		mav.addObject("page","memberInfoUpdate.jsp");
		mav.addObject("memberInfo",memberService.memberInfoUpdatePage(vo));
		mav.setViewName("index.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/memberInfoUpdate.do")
	public String memberInfoUpdate(MemberVO vo) {
		memberService.memberInfoUpdate(vo);
		return "recipeList.do";
	}
}
