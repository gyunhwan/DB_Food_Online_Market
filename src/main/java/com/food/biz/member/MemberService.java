package com.food.biz.member;

import java.util.List;

import com.food.biz.order.OrderVO;
import com.food.biz.supplier.SupplierFoodVO;

public interface MemberService {
   
   int join(MemberVO vo);
   
   int insertAddress(AddressListVO vo);
   
   int insertCard(CardListVO vo);
   
   int deleteAddress(AddressListVO vo);
   
   int deleteCard(CardListVO vo);
   
   MemberVO memberLogin(MemberVO vo);
   
   List<CardListVO> cardList(CardListVO vo);
   
   List<AddressListVO> addressList(AddressListVO vo);
   
   CardListVO getCard(CardListVO vo);
   
   AddressListVO getAddress(AddressListVO vo);
   
   List<OrderVO> getOrderList(OrderVO vo);
   
   int insertMemberMonthTotal(OrderVO vo);
   
   int updateMemberMonthTotal(OrderVO vo);
   
   OrderVO checkMonthTotal(OrderVO vo);
   
   int reduceMemberMonthTotal(OrderVO vo);
   
   SupplierFoodVO foodYesNoDetail(SupplierFoodVO vo);
   
   int foodYes(SupplierFoodVO vo);
   
   int foodNo(SupplierFoodVO vo);
   
   MemberVO memberInfoUpdatePage(MemberVO vo);
   
   int memberInfoUpdate(MemberVO vo);
   
   MemberMonthTotalVO getTotal(MemberMonthTotalVO vo);
   
   int updateGrade(MemberVO vo);
}