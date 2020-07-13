package com.food.biz.food;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FoodDAO {
   @Autowired
   SqlSession sqlSession;
   
   List<FoodVO> getFoodList() {
      return sqlSession.selectList("foodDAO.getList");
   }
}