package com.food.biz.basket.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.food.biz.basket.BasketVO;
import com.food.biz.supplier.SupplierFoodVO;

@Repository("basketDAO")
public class BasketDAO {

	@Autowired
	SqlSession sqlSession;
	
	int insertBasket(BasketVO vo) {
		return sqlSession.insert("basketDAO.insertBasket",vo);
	}
	
	int insertBasketDetail(BasketVO vo) {
		return sqlSession.insert("basketDAO.insertBasketDetail",vo);
	}
	
	BasketVO getBasketCode(BasketVO vo) {
		return sqlSession.selectOne("basketDAO.getBasketCode",vo);
	}
	
	BasketVO detailCheck(BasketVO vo) {
		return sqlSession.selectOne("basketDAO.detailCheck",vo);
	}
	
	int increase(BasketVO vo) {
		return sqlSession.update("basketDAO.increase",vo);
	}
	
	int decrease(BasketVO vo) {
		return sqlSession.update("basketDAO.decrease",vo);
	}
	
	List<SupplierFoodVO> basketList(SupplierFoodVO vo) {
		return sqlSession.selectList("basketDAO.basketList",vo);
	}
	
	int deleteOrderBasketDetail(BasketVO vo) {
		return sqlSession.delete("basketDAO.deleteBasketDetail",vo);
	}
	
	int deleteOrderBasketDetail2(BasketVO vo) {
		return sqlSession.delete("basketDAO.deleteBasketDetail2",vo);
	}
}
