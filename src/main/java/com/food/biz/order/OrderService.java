package com.food.biz.order;

import java.util.List;

import com.food.biz.supplier.SupplierFoodVO;

public interface OrderService {
   SupplierFoodVO singleOrderPage(SupplierFoodVO vo);
   
   List<SupplierFoodVO> basketOrderPage(SupplierFoodVO vo);
   
   int insertOrder(OrderVO vo);
   
   int insertOrderDetail(OrderVO vo);
   
   OrderVO getOrderCode(OrderVO vo);
   
   List<OrderVO> orderList();
   
   List<OrderVO> returnList(OrderVO vo);
   
   int deleteOrder(OrderVO vo);
   
   int deleteOrderDetail(OrderVO vo);
   
   int changeOrderState(OrderVO vo);
   
   List<OrderVO> getOrderDetail(OrderVO vo);
}