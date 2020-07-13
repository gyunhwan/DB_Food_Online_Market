package com.food.biz.supplier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.biz.order.OrderVO;
import com.food.biz.supplier.CalVO;
import com.food.biz.supplier.SupplierFoodVO;
import com.food.biz.supplier.SupplierMonthTotalVO;
import com.food.biz.supplier.SupplierService;
import com.food.biz.supplier.SupplierVO;

@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	SupplierDAO supplierDAO;

	@Override
	public int join(SupplierVO vo) {
		// TODO Auto-generated method stub
		return supplierDAO.join(vo);
	}

	@Override
	public int insertSupplierFood(SupplierFoodVO vo) {
		// TODO Auto-generated method stub
		return supplierDAO.insertSupplierFood(vo);
	}

	@Override
	public SupplierVO supplierLogin(SupplierVO vo) {
		// TODO Auto-generated method stub
		return supplierDAO.loginSupplier(vo);
	}

	@Override
	public List<SupplierFoodVO> supplierFoodList() {
		// TODO Auto-generated method stub
		return supplierDAO.supplierFoodList();
	}

	@Override
	public SupplierFoodVO supplierFoodDetail(SupplierFoodVO vo) {
		// TODO Auto-generated method stub
		return supplierDAO.supplierFoodDetail(vo);
	}

	@Override
	public OrderVO supplierInfo(OrderVO vo) {
		// TODO Auto-generated method stub
		return supplierDAO.supplierInfo(vo);
	}

	@Override
	public int insertSupplierMonthTotal(OrderVO vo) {
		// TODO Auto-generated method stub
		return supplierDAO.insertSupplierMonthTotal(vo);
	}

	@Override
	public int updateSupplierMonthTotal(OrderVO vo) {
		// TODO Auto-generated method stub
		return supplierDAO.updateSupplierMonthTotal(vo);
	}

	@Override
	public OrderVO checkMonthTotal(OrderVO vo) {
		// TODO Auto-generated method stub
		return supplierDAO.checkMonthTotal(vo);
	}

	@Override
	public int reduceSupplierMonthTotal(OrderVO vo) {
		// TODO Auto-generated method stub
		return supplierDAO.reduceSupplierMonthTotal(vo);
	}

	@Override
	public List<SupplierFoodVO> supplierFoodSearch(SupplierFoodVO vo) {
		// TODO Auto-generated method stub
		return supplierDAO.supplierFoodSearch(vo);
	}

	@Override
	public List<SupplierFoodVO> foodYesNo(SupplierFoodVO vo) {
		// TODO Auto-generated method stub
		return supplierDAO.foodYesNo(vo);
	}

	@Override
	public List<SupplierFoodVO> supplierPersonalFoodList(SupplierFoodVO vo) {
		// TODO Auto-generated method stub
		return supplierDAO.supplierPersonalFoodList(vo);
	}

	@Override
	public SupplierVO supplierInfoUpdatePage(SupplierVO vo) {
		// TODO Auto-generated method stub
		return supplierDAO.supplierInfoUpdatePage(vo);
	}

	@Override
	public int supplierInfoUpdate(SupplierVO vo) {
		// TODO Auto-generated method stub
		return supplierDAO.supplierInfoUpdate(vo);
	}

	@Override
	public int updateFoodCode(SupplierFoodVO vo) {
		// TODO Auto-generated method stub
		return supplierDAO.updateFoodCode(vo);
	}

	@Override
	public SupplierMonthTotalVO getTotal(SupplierMonthTotalVO vo) {
		// TODO Auto-generated method stub
		return supplierDAO.getTotal(vo);
	}

	@Override
	public int updateGrade(SupplierVO vo) {
		// TODO Auto-generated method stub
		return supplierDAO.updateGrade(vo);
	}

	@Override
	public List<CalVO> checkCal(CalVO vo) {
		// TODO Auto-generated method stub
		return supplierDAO.checkCal(vo);
	}

	@Override
	public List<OrderVO> calSelect(OrderVO vo) {
		// TODO Auto-generated method stub
		return supplierDAO.calSelect(vo);
	}

	@Override
	public CalVO insertCal(CalVO vo) {
		// TODO Auto-generated method stub
		return supplierDAO.insertCal(vo);
	}
}