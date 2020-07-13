package com.food.biz.member.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.food.biz.member.AddressListVO;
import com.food.biz.member.CardListVO;
import com.food.biz.member.MemberMonthTotalVO;
import com.food.biz.member.MemberVO;
import com.food.biz.order.OrderVO;
import com.food.biz.supplier.SupplierFoodVO;

@Repository("memberDAO")
public class MemberDAO {

   @Autowired
   SqlSession sqlSession;
   
   public int join(MemberVO vo) {
      return sqlSession.insert("memberDAO.join",vo);
   }
   
   public int insertAddress(AddressListVO vo) {
      return sqlSession.insert("memberDAO.insertAddress",vo);
   }
   
   public int insertCard(CardListVO vo) {
      return sqlSession.insert("memberDAO.insertCard",vo);
   }
   
   public int deleteAddress(AddressListVO vo) {
      return sqlSession.insert("memberDAO.deleteAddress",vo);
   }
   
   public int deleteCard(CardListVO vo) {
      return sqlSession.insert("memberDAO.deleteCard",vo);
   }
   
   public MemberVO memberLogin(MemberVO vo) {
      return sqlSession.selectOne("memberDAO.memberLogin",vo);
   }
   
   public List<CardListVO> cardList(CardListVO vo) {
      return sqlSession.selectList("memberDAO.cardList",vo);
   }
   
   public List<AddressListVO> addressList(AddressListVO vo) {
      return sqlSession.selectList("memberDAO.addressList",vo);
   }
   
   public CardListVO getCard(CardListVO vo) {
      return sqlSession.selectOne("memberDAO.getCard",vo);
   }
   
   public AddressListVO getAddress(AddressListVO vo) {
      return sqlSession.selectOne("memberDAO.getAddress",vo);
   }
   
   public List<OrderVO> getOrderList(OrderVO vo) {
      return sqlSession.selectList("memberDAO.getOrderList",vo);
   }
   
   public int insertMemberMonthTotal(OrderVO vo) {
      return sqlSession.insert("memberDAO.insertMemberMonthTotal",vo);
   }
   
   public int updateMemberMonthTotal(OrderVO vo) {
      return sqlSession.update("memberDAO.updateMemberMonthTotal",vo);
   }
   
   OrderVO checkMonthTotal(OrderVO vo) {
      return sqlSession.selectOne("memberDAO.checkMonthTotal",vo);
   }
   
   public int reduceMemberMonthTotal(OrderVO vo) {
      return sqlSession.update("memberDAO.reduceMemberMonthTotal",vo);
   }
   
   SupplierFoodVO foodYesNoDetail(SupplierFoodVO vo) {
      return sqlSession.selectOne("memberDAO.foodYesNoDetail",vo);
   }
   
   public int foodYes(SupplierFoodVO vo) {
      return sqlSession.update("memberDAO.foodYes",vo);
   }
   
   public int foodNo(SupplierFoodVO vo) {
      return sqlSession.update("memberDAO.foodNo",vo);
   }
   
   MemberVO memberInfoUpdatePage(MemberVO vo) {
      return sqlSession.selectOne("memberDAO.memberInfoUpdatePage",vo);
   }
   
   public int memberInfoUpdate(MemberVO vo) {
      return sqlSession.update("memberDAO.memberInfoUpdate",vo);
   }
   
   MemberMonthTotalVO getTotal(MemberMonthTotalVO vo) {
      return sqlSession.selectOne("memberDAO.getTotal",vo);
   }
   
   public int updateGrade(MemberVO vo) {
      return sqlSession.update("memberDAO.updateGrade",vo);
   }
}
