package com.food.biz.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.biz.member.AddressListVO;
import com.food.biz.member.CardListVO;
import com.food.biz.member.MemberMonthTotalVO;
import com.food.biz.member.MemberService;
import com.food.biz.member.MemberVO;
import com.food.biz.order.OrderVO;
import com.food.biz.supplier.SupplierFoodVO;

@Service
public class MemberServiceImpl implements MemberService{

   @Autowired
   MemberDAO memberDAO;
   
   @Override
   public int join(MemberVO vo) {
      // TODO Auto-generated method stub
      return memberDAO.join(vo);
   }

   @Override
   public int insertAddress(AddressListVO vo) {
      // TODO Auto-generated method stub
      return memberDAO.insertAddress(vo);
   }

   @Override
   public int insertCard(CardListVO vo) {
      // TODO Auto-generated method stub
      return memberDAO.insertCard(vo);
   }

   @Override
   public MemberVO memberLogin(MemberVO vo) {
      // TODO Auto-generated method stub
      return memberDAO.memberLogin(vo);
   }

   @Override
   public List<CardListVO> cardList(CardListVO vo) {
      // TODO Auto-generated method stub
      return memberDAO.cardList(vo);
   }

   @Override
   public List<AddressListVO> addressList(AddressListVO vo) {
      // TODO Auto-generated method stub
      return memberDAO.addressList(vo);
   }

   @Override
   public int deleteAddress(AddressListVO vo) {
      // TODO Auto-generated method stub
      return memberDAO.deleteAddress(vo);
   }

   @Override
   public int deleteCard(CardListVO vo) {
      // TODO Auto-generated method stub
      return memberDAO.deleteCard(vo);
   }

   @Override
   public CardListVO getCard(CardListVO vo) {
      // TODO Auto-generated method stub
      return memberDAO.getCard(vo);
   }

   @Override
   public AddressListVO getAddress(AddressListVO vo) {
      // TODO Auto-generated method stub
      return memberDAO.getAddress(vo);
   }

   @Override
   public List<OrderVO> getOrderList(OrderVO vo) {
      // TODO Auto-generated method stub
      return memberDAO.getOrderList(vo);
   }

   @Override
   public int insertMemberMonthTotal(OrderVO vo) {
      // TODO Auto-generated method stub
      return memberDAO.insertMemberMonthTotal(vo);
   }

   @Override
   public int updateMemberMonthTotal(OrderVO vo) {
      // TODO Auto-generated method stub
      return memberDAO.updateMemberMonthTotal(vo);
   }

   @Override
   public OrderVO checkMonthTotal(OrderVO vo) {
      // TODO Auto-generated method stub
      return memberDAO.checkMonthTotal(vo);
   }
   
   @Override
   public int reduceMemberMonthTotal(OrderVO vo) {
      // TODO Auto-generated method stub
      return memberDAO.reduceMemberMonthTotal(vo);
   }

   @Override
   public SupplierFoodVO foodYesNoDetail(SupplierFoodVO vo) {
      // TODO Auto-generated method stub
      return memberDAO.foodYesNoDetail(vo);
   }

   @Override
   public int foodYes(SupplierFoodVO vo) {
      // TODO Auto-generated method stub
      return memberDAO.foodYes(vo);
   }

   @Override
   public int foodNo(SupplierFoodVO vo) {
      // TODO Auto-generated method stub
      return memberDAO.foodNo(vo);
   }

   @Override
   public MemberVO memberInfoUpdatePage(MemberVO vo) {
      // TODO Auto-generated method stub
      return memberDAO.memberInfoUpdatePage(vo);
   }

   @Override
   public int memberInfoUpdate(MemberVO vo) {
      // TODO Auto-generated method stub
      return memberDAO.memberInfoUpdate(vo);
   }

   @Override
   public MemberMonthTotalVO getTotal(MemberMonthTotalVO vo) {
      // TODO Auto-generated method stub
      return memberDAO.getTotal(vo);
   }

   @Override
   public int updateGrade(MemberVO vo) {
      // TODO Auto-generated method stub
      return memberDAO.updateGrade(vo);
   }
}