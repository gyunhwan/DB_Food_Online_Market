package com.food.biz.supplier;

import java.util.List;

import com.food.biz.order.OrderVO;

public interface SupplierService {

	int join(SupplierVO vo);

	int insertSupplierFood(SupplierFoodVO vo);

	SupplierVO supplierLogin(SupplierVO vo);

	List<SupplierFoodVO> supplierFoodList();

	SupplierFoodVO supplierFoodDetail(SupplierFoodVO vo);

	OrderVO supplierInfo(OrderVO vo);

	int insertSupplierMonthTotal(OrderVO vo);

	int updateSupplierMonthTotal(OrderVO vo);

	OrderVO checkMonthTotal(OrderVO vo);

	int reduceSupplierMonthTotal(OrderVO vo);

	List<SupplierFoodVO> supplierFoodSearch(SupplierFoodVO vo);

	List<SupplierFoodVO> foodYesNo(SupplierFoodVO vo);

	List<SupplierFoodVO> supplierPersonalFoodList(SupplierFoodVO vo);

	SupplierVO supplierInfoUpdatePage(SupplierVO vo);

	int supplierInfoUpdate(SupplierVO vo);

	int updateFoodCode(SupplierFoodVO vo);

	SupplierMonthTotalVO getTotal(SupplierMonthTotalVO vo);

	int updateGrade(SupplierVO vo);

	List<CalVO> checkCal(CalVO vo);

	List<OrderVO> calSelect(OrderVO vo);

	CalVO insertCal(CalVO vo);
}