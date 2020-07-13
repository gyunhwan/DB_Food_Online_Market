package com.food.biz.food;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService {
   @Autowired
   FoodDAO dao;
   @Override
   public List<FoodVO> getFoodList() {
      return dao.getFoodList();
   }
   
}