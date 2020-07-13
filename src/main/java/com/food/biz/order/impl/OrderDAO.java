package com.food.biz.order.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.food.biz.order.OrderVO;
import com.food.biz.supplier.SupplierFoodVO;

@Repository("orderDAO")
public class OrderDAO {
   
   @Autowired
   SqlSession sqlSession;
   
   public SupplierFoodVO singleOrderPage(SupplierFoodVO vo) {
      return sqlSession.selectOne("orderDAO.singleOrderPage",vo);
   }
   
   public int insertOrder(OrderVO vo) {
      return sqlSession.insert("orderDAO.insertOrder",vo);
   }
   
   public int insertOrderDetail(OrderVO vo) {
      return sqlSession.insert("orderDAO.insertOrderDetail",vo);
   }
   
   public OrderVO getOrderCode(OrderVO vo) {
      return sqlSession.selectOne("orderDAO.getOrderCode",vo);
   }
   
   public List<SupplierFoodVO> basketOrderPage(SupplierFoodVO vo) {
      return sqlSession.selectList("orderDAO.basketOrderPage",vo);
   }
   
   public List<OrderVO> orderList() {
      return sqlSession.selectList("orderDAO.orderList");
   }
   
   public List<OrderVO> returnList(OrderVO vo) {
      return sqlSession.selectList("orderDAO.returnList",vo);
   }
   
   public int deleteOrder(OrderVO vo) {
      return sqlSession.delete("orderDAO.deleteOrder",vo);
   }
   
   public int deleteOrderDetail(OrderVO vo) {
      return sqlSession.delete("orderDAO.deleteOrderDetail",vo);
   }
   
   public int changeOrderState(OrderVO vo) {
      return sqlSession.update("orderDAO.changeOrderState",vo);
   }
   
   public List<OrderVO> getOrderDetail(OrderVO vo) {
      return sqlSession.selectList("orderDAO.getOrderDetail",vo);
   }
}