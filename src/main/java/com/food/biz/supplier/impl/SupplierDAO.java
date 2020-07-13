package com.food.biz.supplier.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.food.biz.order.OrderVO;
import com.food.biz.supplier.CalVO;
import com.food.biz.supplier.SupplierFoodVO;
import com.food.biz.supplier.SupplierMonthTotalVO;
import com.food.biz.supplier.SupplierVO;

@Repository("supplierDAO")
public class SupplierDAO {

	@Autowired
	SqlSession sqlSession;

	public int join(SupplierVO vo) {
		return sqlSession.insert("supplierDAO.join", vo);
	}

	public int insertSupplierFood(SupplierFoodVO vo) {
		return sqlSession.insert("supplierDAO.insertSupplierFood", vo);
	}

	public SupplierVO loginSupplier(SupplierVO vo) {
		return sqlSession.selectOne("supplierDAO.supplierLogin", vo);
	}

	List<SupplierFoodVO> supplierFoodList() {
		return sqlSession.selectList("supplierDAO.supplierFoodList");
	}

	SupplierFoodVO supplierFoodDetail(SupplierFoodVO vo) {
		return sqlSession.selectOne("supplierDAO.supplierFoodDetail", vo);
	}

	OrderVO supplierInfo(OrderVO vo) {
		return sqlSession.selectOne("supplierDAO.supplierInfo", vo);
	}

	public int insertSupplierMonthTotal(OrderVO vo) {
		return sqlSession.insert("supplierDAO.insertSupplierMonthTotal", vo);
	}

	public int updateSupplierMonthTotal(OrderVO vo) {
		return sqlSession.update("supplierDAO.updateSupplierMonthTotal", vo);
	}

	OrderVO checkMonthTotal(OrderVO vo) {
		return sqlSession.selectOne("supplierDAO.checkMonthTotal", vo);
	}

	public int reduceSupplierMonthTotal(OrderVO vo) {
		return sqlSession.update("supplierDAO.reduceSupplierMonthTotal", vo);
	}

	List<SupplierFoodVO> supplierFoodSearch(SupplierFoodVO vo) {
		return sqlSession.selectList("supplierDAO.supplierFoodSearch", vo);
	}

	List<SupplierFoodVO> foodYesNo(SupplierFoodVO vo) {
		return sqlSession.selectList("supplierDAO.foodYesNo", vo);
	}

	List<SupplierFoodVO> supplierPersonalFoodList(SupplierFoodVO vo) {
		return sqlSession.selectList("supplierDAO.supplierPersonalFoodList", vo);
	}

	SupplierVO supplierInfoUpdatePage(SupplierVO vo) {
		return sqlSession.selectOne("supplierDAO.supplierInfoUpdatePage", vo);
	}

	public int supplierInfoUpdate(SupplierVO vo) {
		return sqlSession.update("supplierDAO.supplierInfoUpdate", vo);
	}

	public int updateFoodCode(SupplierFoodVO vo) {
		return sqlSession.update("supplierDAO.updateFoodCode", vo);
	}

	SupplierMonthTotalVO getTotal(SupplierMonthTotalVO vo) {
		return sqlSession.selectOne("supplierDAO.getTotal", vo);
	}

	public int updateGrade(SupplierVO vo) {
		return sqlSession.update("supplierDAO.updateGrade", vo);
	}

	List<CalVO> checkCal(CalVO vo) {
		return sqlSession.selectList("supplierDAO.checkCal", vo);
	}

	List<OrderVO> calSelect(OrderVO vo) {
		return sqlSession.selectList("supplierDAO.calSelect", vo);
	}

	CalVO insertCal(CalVO vo) {
		return sqlSession.selectOne("supplierDAO.insertCal", vo);
	}
}