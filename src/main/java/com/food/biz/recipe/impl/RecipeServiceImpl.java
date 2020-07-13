package com.food.biz.recipe.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.biz.recipe.EvaluationMonthAvgVO;
import com.food.biz.recipe.EvaluationVO;
import com.food.biz.recipe.RecipeDetailDTO;
import com.food.biz.recipe.RecipeFoodVO;
import com.food.biz.recipe.RecipeService;
import com.food.biz.recipe.RecipeVO;
import com.food.biz.supplier.SupplierFoodVO;

@Service
public class RecipeServiceImpl implements RecipeService{
	@Autowired
	RecipeDAO recipeDAO;

	@Override
	public int insertRecipe(RecipeVO vo) {
		// TODO Auto-generated method stub
		return recipeDAO.insertRecipt(vo);
	}

	@Override
	public int insertFood(RecipeVO vo) {
		// TODO Auto-generated method stub
		return recipeDAO.insertFood(vo);
	}

	@Override
	   public int insertRecipeFood(RecipeVO vo) {
	      int count=0;
	         for(RecipeFoodVO a: vo.getRecipe_food()) {
	            a.setRecipe_code(vo.getRecipe_code());
	            count+= recipeDAO.insertRecipeFood(a);
	         }
	      return count;
	   }

	@Override
	public List<EvaluationVO> getEvaluation(int code) {
		return recipeDAO.getEvaluation(code);
	}

	@Override
	public RecipeVO getFoodCode(RecipeVO vo) {
		// TODO Auto-generated method stub
		return recipeDAO.getFoodCode(vo);
	}

	@Override
	public List<SupplierFoodVO> getOne(int code) {
		return recipeDAO.getOne(code);
	}

	@Override
	public RecipeVO getRecipeCode(RecipeVO vo) {
		// TODO Auto-generated method stub
		return recipeDAO.getRecipeCode(vo);
	}

	@Override
	public List<RecipeVO> recipeList() {
		// TODO Auto-generated method stub
		return recipeDAO.recipeList();
	}

	 @Override
	public int insertEvaluation(EvaluationVO vo) {
		return recipeDAO.insertEvaluation(vo);
	}

	@Override
	   public List<RecipeDetailDTO> recipeDetail(RecipeVO vo) {
	      // TODO Auto-generated method stub
	      return recipeDAO.recipeDetail(vo);
	   }

	 @Override
	   public RecipeVO getRecipeOne(int code) {
	      return recipeDAO.getRecipeOne(code);
	   }
	 
	@Override
	public List<RecipeVO> recipeSearch(RecipeVO vo) {
		// TODO Auto-generated method stub
		return recipeDAO.recipeSearch(vo);
	}


	   @Override
	   public List<RecipeVO> popularRecipe() {
	      // TODO Auto-generated method stub
	      return recipeDAO.popularRecipe();
	   }


	   @Override
	   public int insertEvaluationAvg(EvaluationMonthAvgVO vo) {
	      // TODO Auto-generated method stub
	      return recipeDAO.insertEvaluationAvg(vo);
	   }
	   
	   @Override
	   public int updateEvaluationAvg(EvaluationMonthAvgVO vo) {
	      // TODO Auto-generated method stub
	      return recipeDAO.updateEvaluationAvg(vo);
	   }

	   @Override
	   public EvaluationMonthAvgVO checkEvaluation(EvaluationMonthAvgVO vo) {
	      // TODO Auto-generated method stub
	      return recipeDAO.checkEvaluation(vo);
	   }

	   @Override
	   public int updateRecipeGrade(RecipeVO vo) {
	      // TODO Auto-generated method stub
	      return recipeDAO.updateRecipeGrade(vo);
	   }
}
