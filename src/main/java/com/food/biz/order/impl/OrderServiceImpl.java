package com.food.biz.order.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.biz.order.OrderService;
import com.food.biz.order.OrderVO;
import com.food.biz.supplier.SupplierFoodVO;

@Service
public class OrderServiceImpl implements OrderService{

   @Autowired
   OrderDAO orderDAO;
   
   @Override
   public SupplierFoodVO singleOrderPage(SupplierFoodVO vo) {
      // TODO Auto-generated method stub
      return orderDAO.singleOrderPage(vo);
   }

   @Override
   public int insertOrder(OrderVO vo) {
      // TODO Auto-generated method stub
      return orderDAO.insertOrder(vo);
   }

   @Override
   public OrderVO getOrderCode(OrderVO vo) {
      // TODO Auto-generated method stub
      return orderDAO.getOrderCode(vo);
   }

   @Override
   public int insertOrderDetail(OrderVO vo) {
      // TODO Auto-generated method stub
      return orderDAO.insertOrderDetail(vo);
   }

   @Override
   public List<SupplierFoodVO> basketOrderPage(SupplierFoodVO vo) {
      // TODO Auto-generated method stub
      return orderDAO.basketOrderPage(vo);
   }

   @Override
   public List<OrderVO> orderList() {
      // TODO Auto-generated method stub
      return orderDAO.orderList();
   }

   @Override
   public int deleteOrder(OrderVO vo) {
      // TODO Auto-generated method stub
      return orderDAO.deleteOrder(vo);
   }

   @Override
   public int deleteOrderDetail(OrderVO vo) {
      // TODO Auto-generated method stub
      return orderDAO.deleteOrderDetail(vo);
   }

   @Override
   public int changeOrderState(OrderVO vo) {
      // TODO Auto-generated method stub
      return orderDAO.changeOrderState(vo);
   }

   @Override
   public List<OrderVO> returnList(OrderVO vo) {
      // TODO Auto-generated method stub
      return orderDAO.returnList(vo);
   }

   @Override
   public List<OrderVO> getOrderDetail(OrderVO vo) {
      // TODO Auto-generated method stub
      return orderDAO.getOrderDetail(vo);
   }
}