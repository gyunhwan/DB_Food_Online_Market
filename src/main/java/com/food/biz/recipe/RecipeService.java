package com.food.biz.recipe;

import java.util.List;

import com.food.biz.supplier.SupplierFoodVO;

public interface RecipeService {

	int insertRecipe(RecipeVO vo);

	int insertFood(RecipeVO vo);

	int insertRecipeFood(RecipeVO vo);

	RecipeVO getFoodCode(RecipeVO vo);

	RecipeVO getRecipeCode(RecipeVO vo);

	List<RecipeVO> recipeList();

	List<RecipeDetailDTO> recipeDetail(RecipeVO vo);

	RecipeVO getRecipeOne(int code);

	List<RecipeVO> recipeSearch(RecipeVO vo);

	List<EvaluationVO> getEvaluation(int code);

	List<RecipeVO> popularRecipe();

	List<SupplierFoodVO> getOne(int code);

	int insertEvaluation(EvaluationVO vo);

	int insertEvaluationAvg(EvaluationMonthAvgVO vo);

	int updateEvaluationAvg(EvaluationMonthAvgVO vo);

	EvaluationMonthAvgVO checkEvaluation(EvaluationMonthAvgVO vo);
	
	int updateRecipeGrade(RecipeVO vo);
}
