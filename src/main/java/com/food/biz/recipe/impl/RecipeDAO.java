package com.food.biz.recipe.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.food.biz.recipe.EvaluationMonthAvgVO;
import com.food.biz.recipe.EvaluationVO;
import com.food.biz.recipe.RecipeDetailDTO;
import com.food.biz.recipe.RecipeFoodVO;
import com.food.biz.recipe.RecipeVO;
import com.food.biz.supplier.SupplierFoodVO;

@Repository("recipeDAO")
public class RecipeDAO {

	@Autowired
	SqlSession sqlSession;

	int insertRecipt(RecipeVO vo) {
		return sqlSession.insert("recipeDAO.insertRecipe", vo);
	}

	int insertFood(RecipeVO vo) {
		return sqlSession.insert("recipeDAO.insertFood", vo);
	}

	int insertRecipeFood(RecipeFoodVO vo) {
		return sqlSession.insert("recipeDAO.insertRecipeFood", vo);
	}

	RecipeVO getFoodCode(RecipeVO vo) {
		return sqlSession.selectOne("recipeDAO.getFoodCode", vo);
	}

	RecipeVO getRecipeCode(RecipeVO vo) {
		return sqlSession.selectOne("recipeDAO.getRecipeCode", vo);
	}

	List<RecipeVO> recipeList() {
		return sqlSession.selectList("recipeDAO.recipeList");
	}

	List<RecipeVO> recipeSearch(RecipeVO vo) {
		return sqlSession.selectList("recipeDAO.recipeSearch", vo);
	}

	List<RecipeDetailDTO> recipeDetail(RecipeVO vo) {
		return sqlSession.selectList("recipeDAO.recipeDetail", vo);
	}

	RecipeVO getRecipeOne(int code) {
		return sqlSession.selectOne("recipeDAO.getRecipeOne", code);
	}

	List<EvaluationVO> getEvaluation(int code) {
		return sqlSession.selectList("recipeDAO.getComment", code);
	}

	int insertEvaluation(EvaluationVO vo) {
		return sqlSession.insert("recipeDAO.insertEvaluation", vo);
	}

	List<SupplierFoodVO> getOne(int code) {
		return sqlSession.selectList("recipeDAO.getAuto", code);
	}

	int insertEvaluationAvg(EvaluationMonthAvgVO vo) {
		return sqlSession.insert("recipeDAO.insertEvaluationMonthAvg", vo);
	}

	int updateEvaluationAvg(EvaluationMonthAvgVO vo) {
		return sqlSession.update("recipeDAO.updateEvaluationMonthAvg", vo);
	}

	EvaluationMonthAvgVO checkEvaluation(EvaluationMonthAvgVO vo) {
		return sqlSession.selectOne("recipeDAO.checkEvaluationMonthAvg", vo);
	}

	List<RecipeVO> popularRecipe() {
		return sqlSession.selectList("recipeDAO.popularRecipe");
	}
	
	int updateRecipeGrade(RecipeVO vo) {
	      return sqlSession.update("recipeDAO.updateRecipeGrade", vo);
	   }
}
