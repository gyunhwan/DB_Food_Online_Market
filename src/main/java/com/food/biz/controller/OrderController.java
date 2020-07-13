package com.food.biz.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.food.biz.basket.BasketService;
import com.food.biz.basket.BasketVO;
import com.food.biz.member.AddressListVO;
import com.food.biz.member.CardListVO;
import com.food.biz.member.MemberMonthTotalVO;
import com.food.biz.member.MemberService;
import com.food.biz.member.MemberVO;
import com.food.biz.order.OrderDTO;
import com.food.biz.order.OrderService;
import com.food.biz.order.OrderVO;
import com.food.biz.recipe.RecipeService;
import com.food.biz.supplier.SupplierFoodVO;
import com.food.biz.supplier.SupplierMonthTotalVO;
import com.food.biz.supplier.SupplierService;
import com.food.biz.supplier.SupplierVO;

@Controller
public class OrderController {

   @Autowired
   OrderService orderService;

   @Autowired
   MemberService memberService;

   @Autowired
   BasketService basketService;

   @Autowired
   SupplierService supplierService;
   @Autowired
   RecipeService rService;
   
   @RequestMapping(value = "123123123.do")
   public ModelAndView autoOrder(ModelAndView mav, OrderDTO dto) {
      System.out.println("hi"+dto.toString());
      SupplierFoodVO vo= new SupplierFoodVO();
      BasketVO bvo=new BasketVO();
      bvo.setMember_email(dto.getMember_email());
      BasketVO code=new BasketVO();
      code = basketService.getBasketCode(bvo);
      List<SupplierFoodVO> svo =new ArrayList<SupplierFoodVO>();
      svo=rService.getOne(dto.getRecipe_code());
      if(code==null) {
  		basketService.insertBasket(bvo);
  		code = basketService.getBasketCode(bvo);
  		}
  		bvo.setBasket_code(code.getBasket_code());
  		for(SupplierFoodVO sfood:svo) {
  			bvo.setSupplier_food_code(sfood.getSupplier_food_code());
  			if(basketService.detailCheck(bvo)==null) {
  		  		basketService.insertBasketDetail(bvo);
  		  		}else {
  		  			basketService.increase(bvo); 
  		  		}
  		}
  		
      CardListVO card = new CardListVO();
      AddressListVO address = new AddressListVO();
      card.setMember_email(dto.getMember_email());
      address.setMember_email(dto.getMember_email());
      vo.setMember_email(dto.getMember_email());
      System.out.println(rService.getOne(dto.getRecipe_code()));
      mav.addObject("page","orderBasket.jsp");
      mav.addObject("supplierFoodList",  orderService.basketOrderPage(vo));
      mav.addObject("addressList", memberService.addressList(address));
      mav.addObject("cardList", memberService.cardList(card));
      mav.setViewName("index.jsp");
      return mav;
   }
   @RequestMapping(value = "singleOrderPage.do")
   public ModelAndView singleOrderPage(ModelAndView mav, SupplierFoodVO vo) {
      System.out.println("단일 주문 페이지");
      CardListVO card = new CardListVO();
      AddressListVO address = new AddressListVO();
      card.setMember_email(vo.getMember_email());
      address.setMember_email(vo.getMember_email());
      mav.addObject("page", "order.jsp");
      mav.addObject("supplierFood", orderService.singleOrderPage(vo));
      mav.addObject("addressList", memberService.addressList(address));
      mav.addObject("cardList", memberService.cardList(card));
      mav.setViewName("index.jsp");
      return mav;
   }

   @RequestMapping(value = "/singleInsertOrder.do")
   public String singleInsertOrder(OrderVO vo, HttpSession session) {

      MemberMonthTotalVO member2 = new MemberMonthTotalVO();
      SupplierMonthTotalVO supplier2 = new SupplierMonthTotalVO();
      MemberVO member = new MemberVO();
      SupplierVO supplier = new SupplierVO();

      AddressListVO address = new AddressListVO();
      OrderVO code = new OrderVO();
      if (vo.getAddress_code() != 0) {
         address.setAddress_code(vo.getAddress_code());
         address = memberService.getAddress(address);
         vo.setOrder_address(address.getAddress());
         vo.setOrder_address_detail(address.getAddress_detail());
      }
      orderService.insertOrder(vo);
      code = orderService.getOrderCode(vo);
      vo.setOrder_code(code.getOrder_code());
      if(vo.getMember_grade_code()==1) {
         vo.setOrder_detail_price((int)(vo.getOrder_detail_price()*0.95));
      } else if(vo.getMember_grade_code()==2) {
         vo.setOrder_detail_price((int)(vo.getOrder_detail_price()*0.9));
      } else if(vo.getMember_grade_code()==3) {
         vo.setOrder_detail_price((int)(vo.getOrder_detail_price()*0.85));
      }
      orderService.insertOrderDetail(vo);
      // 월통계
      vo.setBuy_month(vo.getSell_month());
      OrderVO supplierInfo = new OrderVO();
      supplierInfo = supplierService.supplierInfo(vo);
      vo.setSupplier_business_number(supplierInfo.getSupplier_business_number());
      if (supplierService.checkMonthTotal(vo) == null) {
         supplierService.insertSupplierMonthTotal(vo);
      } else {
         supplierService.updateSupplierMonthTotal(vo);
      }
      if (memberService.checkMonthTotal(vo) == null) {
         memberService.insertMemberMonthTotal(vo);
      } else {
         memberService.updateMemberMonthTotal(vo);
      }

      // 등급변경
      member2.setMember_email(vo.getMember_email());
      member2.setBuy_month(vo.getBuy_month());
      member2 = memberService.getTotal(member2);
      System.out.println(member2.toString());
      if (member2.getBuy_total() >= 10000 && member2.getBuy_total() < 100000) {
         member.setMember_email(member2.getMember_email());
         member.setMember_grade_code(1);
         memberService.updateGrade(member);
      } else if (member2.getBuy_total() >= 100000 && member2.getBuy_total() < 1000000) {
         member.setMember_email(member2.getMember_email());
         member.setMember_grade_code(2);
         memberService.updateGrade(member);
      } else if (member2.getBuy_total() >= 1000000) {
         member.setMember_email(member2.getMember_email());
         member.setMember_grade_code(3);
         memberService.updateGrade(member);
      } else {
         member.setMember_email(member2.getMember_email());
         member.setMember_grade_code(0);
         memberService.updateGrade(member);
      }

      supplier2.setSupplier_business_number(vo.getSupplier_business_number());
      supplier2.setSell_month(vo.getSell_month());
      supplier2 = supplierService.getTotal(supplier2);
      System.out.println(supplier2.toString());
      if (supplier2.getSell_total() >= 1000000 && supplier2.getSell_total() < 2000000) {
         supplier.setSupplier_business_number(supplier2.getSupplier_business_number());
         supplier.setSupplier_grade_code(1);
         supplierService.updateGrade(supplier);
      } else if (supplier2.getSell_total() >= 2000000) {
         supplier.setSupplier_business_number(supplier2.getSupplier_business_number());
         supplier.setSupplier_grade_code(2);
         supplierService.updateGrade(supplier);
      } else {
         supplier.setSupplier_business_number(supplier2.getSupplier_business_number());
         supplier.setSupplier_grade_code(0);
         supplierService.updateGrade(supplier);
      }
      
      session.setAttribute("member_grade_code",member.getMember_grade_code());
      
      return "recipeList.do";
   }

   @RequestMapping(value = "basketOrderPage.do")
   public ModelAndView basketOrderPage(ModelAndView mav, SupplierFoodVO vo) {
      System.out.println("다중 주문 페이지");
      if (orderService.basketOrderPage(vo).isEmpty()) {
         mav.setViewName("basketList.do");
         return mav;
      } else {
         CardListVO card = new CardListVO();
         AddressListVO address = new AddressListVO();
         card.setMember_email(vo.getMember_email());
         address.setMember_email(vo.getMember_email());
         mav.addObject("page", "orderBasket.jsp");
         mav.addObject("supplierFoodList", orderService.basketOrderPage(vo));
         mav.addObject("addressList", memberService.addressList(address));
         mav.addObject("cardList", memberService.cardList(card));
         mav.setViewName("index.jsp");
         return mav;
      }
   }

   @RequestMapping(value = "/basketInsertOrder.do")
   public String basketInsertOrder(OrderVO vo,HttpSession session) {

      MemberMonthTotalVO member2 = new MemberMonthTotalVO();
      SupplierMonthTotalVO supplier2 = new SupplierMonthTotalVO();
      MemberVO member = new MemberVO();
      SupplierVO supplier = new SupplierVO();

      AddressListVO address = new AddressListVO();
      OrderVO code = new OrderVO();
      if (vo.getAddress_code() != 0) {
         address.setAddress_code(vo.getAddress_code());
         address = memberService.getAddress(address);
         vo.setOrder_address(address.getAddress());
         vo.setOrder_address_detail(address.getAddress_detail());
      }
      List<SupplierFoodVO> foodList = new ArrayList<SupplierFoodVO>();
      SupplierFoodVO email = new SupplierFoodVO();
      email.setMember_email(vo.getMember_email());
      foodList = orderService.basketOrderPage(email);
      orderService.insertOrder(vo);
      code = orderService.getOrderCode(vo);
      vo.setOrder_code(code.getOrder_code());

      vo.setBuy_month(vo.getSell_month());
      OrderVO supplierInfo = new OrderVO();

      for (SupplierFoodVO food : foodList) {
         vo.setSupplier_food_code(food.getSupplier_food_code());
         vo.setOrder_detail_price(food.getSupplier_food_price());
         vo.setOrder_detail_amount(food.getBasket_detail_amount());
         if(vo.getMember_grade_code()==1) {
            vo.setOrder_detail_price((int)(vo.getOrder_detail_price()*0.95));
         } else if(vo.getMember_grade_code()==2) {
            vo.setOrder_detail_price((int)(vo.getOrder_detail_price()*0.9));
         } else if(vo.getMember_grade_code()==3) {
            vo.setOrder_detail_price((int)(vo.getOrder_detail_price()*0.85));
         }
         orderService.insertOrderDetail(vo);

         // 월통계
         supplierInfo = supplierService.supplierInfo(vo);
         vo.setSupplier_business_number(supplierInfo.getSupplier_business_number());
         if (supplierService.checkMonthTotal(vo) == null) {
            supplierService.insertSupplierMonthTotal(vo);
         } else {
            supplierService.updateSupplierMonthTotal(vo);
         }
         if (memberService.checkMonthTotal(vo) == null) {
            memberService.insertMemberMonthTotal(vo);
         } else {
            memberService.updateMemberMonthTotal(vo);
         }

         // 등급변경
         member2.setMember_email(vo.getMember_email());
         member2.setBuy_month(vo.getBuy_month());
         member2 = memberService.getTotal(member2);
         if (member2.getBuy_total() >= 10000 && member2.getBuy_total() < 100000) {
            member.setMember_email(member2.getMember_email());
            member.setMember_grade_code(1);
            memberService.updateGrade(member);
         } else if (member2.getBuy_total() >= 100000 && member2.getBuy_total() < 1000000) {
            member.setMember_email(member2.getMember_email());
            member.setMember_grade_code(2);
            memberService.updateGrade(member);
         } else if (member2.getBuy_total() >= 1000000) {
            member.setMember_email(member2.getMember_email());
            member.setMember_grade_code(3);
            memberService.updateGrade(member);
         } else {
            member.setMember_email(member2.getMember_email());
            member.setMember_grade_code(0);
            memberService.updateGrade(member);
         }

         supplier2.setSupplier_business_number(vo.getSupplier_business_number());
         supplier2.setSell_month(vo.getSell_month());
         supplier2 = supplierService.getTotal(supplier2);
         if (supplier2.getSell_total() >= 1000000 && supplier2.getSell_total() < 2000000) {
            supplier.setSupplier_business_number(supplier2.getSupplier_business_number());
            supplier.setSupplier_grade_code(1);
            supplierService.updateGrade(supplier);
         } else if (supplier2.getSell_total() >= 2000000) {
            supplier.setSupplier_business_number(supplier2.getSupplier_business_number());
            supplier.setSupplier_grade_code(2);
            supplierService.updateGrade(supplier);
         } else {
            supplier.setSupplier_business_number(supplier2.getSupplier_business_number());
            supplier.setSupplier_grade_code(0);
            supplierService.updateGrade(supplier);
         }

      }
      BasketVO basketCode = new BasketVO();
      basketCode.setMember_email(vo.getMember_email());
      basketCode = basketService.getBasketCode(basketCode);
      basketService.deleteOrderBasketDetail(basketCode);
      
      session.setAttribute("member_grade_code",member.getMember_grade_code());
      return "recipeList.do";
   }
   @RequestMapping(value = "orderList.do")
   public ModelAndView orderList(ModelAndView mav, SupplierFoodVO vo) {
      System.out.println("주문 목록 페이지");
      mav.addObject("page", "orderList.jsp");
      mav.addObject("orderList", orderService.orderList());
      mav.setViewName("index.jsp");
      return mav;
   }

   @RequestMapping(value = "returnList.do")
   public ModelAndView returnList(ModelAndView mav, OrderVO vo) {
      System.out.println("반품 목록 페이지");
      mav.addObject("page", "returnList.jsp");
      mav.addObject("returnList", orderService.returnList(vo));
      mav.setViewName("index.jsp");
      return mav;
   }

   @RequestMapping(value = "/deleteOrder.do")
   public String deleteOrder(OrderVO vo) {
      System.out.println("주문 삭제");

      MemberMonthTotalVO member2 = new MemberMonthTotalVO();
      SupplierMonthTotalVO supplier2 = new SupplierMonthTotalVO();
      MemberVO member = new MemberVO();
      SupplierVO supplier = new SupplierVO();

      List<OrderVO> detail = new ArrayList<OrderVO>();
      detail = orderService.getOrderDetail(vo);
      for (OrderVO order : detail) {
         String date = order.getOrder_date();
         int month = Integer.parseInt(date.substring(5, 7));
         order.setSell_month(month);
         order.setBuy_month(month);
         memberService.reduceMemberMonthTotal(order);
         supplierService.reduceSupplierMonthTotal(order);

         // 등급변경
         member2.setMember_email(order.getMember_email());
         member2.setBuy_month(month);
         member2 = memberService.getTotal(member2);
         if (member2.getBuy_total() >= 10000 && member2.getBuy_total() < 100000) {
            member.setMember_email(member2.getMember_email());
            member.setMember_grade_code(1);
            memberService.updateGrade(member);
         } else if (member2.getBuy_total() >= 100000 && member2.getBuy_total() < 1000000) {
            member.setMember_email(member2.getMember_email());
            member.setMember_grade_code(2);
            memberService.updateGrade(member);
         } else if (member2.getBuy_total() >= 1000000) {
            member.setMember_email(member2.getMember_email());
            member.setMember_grade_code(3);
            memberService.updateGrade(member);
         } else {
            member.setMember_email(member2.getMember_email());
            member.setMember_grade_code(0);
            memberService.updateGrade(member);
         }
         supplier2.setSupplier_business_number(order.getSupplier_business_number());
         supplier2.setSell_month(month);
         supplier2 = supplierService.getTotal(supplier2);
         if (supplier2.getSell_total() >= 1000000 && supplier2.getSell_total() < 2000000) {
            supplier.setSupplier_business_number(supplier2.getSupplier_business_number());
            supplier.setSupplier_grade_code(1);
            supplierService.updateGrade(supplier);
         } else if (supplier2.getSell_total() >= 2000000) {
            supplier.setSupplier_business_number(supplier2.getSupplier_business_number());
            supplier.setSupplier_grade_code(2);
            supplierService.updateGrade(supplier);
         } else {
            supplier.setSupplier_business_number(supplier2.getSupplier_business_number());
            supplier.setSupplier_grade_code(0);
            supplierService.updateGrade(supplier);
         }

      }
      orderService.deleteOrderDetail(vo);
      orderService.deleteOrder(vo);
      return "getOrderList.do";
   }

   @RequestMapping(value = "/changeOrderState.do")
   public String changeOrderState(OrderVO vo) {
      System.out.println("주문 상태 변경");
      orderService.changeOrderState(vo);
      return "orderList.do";
   }

   @RequestMapping(value = "/changeOrderState2.do")
   public String changeOrderState2(OrderVO vo) {
      System.out.println("주문 상태 변경(2)");
      orderService.changeOrderState(vo);
      return "getOrderList.do";
   }

   @RequestMapping(value = "/changeOrderState3.do")
   public String changeOrderState3(OrderVO vo) {
      System.out.println("주문 상태 변경(3)");

      MemberMonthTotalVO member2 = new MemberMonthTotalVO();
      SupplierMonthTotalVO supplier2 = new SupplierMonthTotalVO();
      MemberVO member = new MemberVO();
      SupplierVO supplier = new SupplierVO();
      List<OrderVO> list = new ArrayList<OrderVO>();
      list = orderService.getOrderDetail(vo);
      for (OrderVO order : list) {
         System.out.println(order.toString());
         String date = order.getOrder_date();
         int month = Integer.parseInt(date.substring(5, 7));
         order.setSell_month(month);
         order.setBuy_month(month);
         memberService.reduceMemberMonthTotal(order);
         supplierService.reduceSupplierMonthTotal(order);
         
         if (vo.getOrder_state().equals("환불 완료")) {
            // 등급변경
            member2.setMember_email(order.getMember_email());
            member2.setBuy_month(month);
            member2 = memberService.getTotal(member2);
            System.out.println(member2.toString());
            if (member2.getBuy_total() >= 10000 && member2.getBuy_total() < 100000) {
               member.setMember_email(member2.getMember_email());
               member.setMember_grade_code(1);
               memberService.updateGrade(member);
            } else if (member2.getBuy_total() >= 100000 && member2.getBuy_total() < 1000000) {
               member.setMember_email(member2.getMember_email());
               member.setMember_grade_code(2);
               memberService.updateGrade(member);
            } else if (member2.getBuy_total() >= 1000000) {
               member.setMember_email(member2.getMember_email());
               member.setMember_grade_code(3);
               memberService.updateGrade(member);
            } else {
               member.setMember_email(member2.getMember_email());
               member.setMember_grade_code(0);
               memberService.updateGrade(member);
            }
            supplier2.setSupplier_business_number(order.getSupplier_business_number());
            supplier2.setSell_month(month);
            supplier2 = supplierService.getTotal(supplier2);
            System.out.println(supplier2.toString());
            if (supplier2.getSell_total() >= 1000000 && supplier2.getSell_total() < 2000000) {
               supplier.setSupplier_business_number(supplier2.getSupplier_business_number());
               supplier.setSupplier_grade_code(1);
               supplierService.updateGrade(supplier);
            } else if (supplier2.getSell_total() >= 2000000) {
               supplier.setSupplier_business_number(supplier2.getSupplier_business_number());
               supplier.setSupplier_grade_code(2);
               supplierService.updateGrade(supplier);
            } else {
               supplier.setSupplier_business_number(supplier2.getSupplier_business_number());
               supplier.setSupplier_grade_code(0);
               supplierService.updateGrade(supplier);
            }
         }
      }
      orderService.changeOrderState(vo);
      return "returnList.do";
   }
}