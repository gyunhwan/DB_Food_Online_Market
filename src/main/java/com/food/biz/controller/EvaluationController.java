package com.food.biz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.food.biz.recipe.EvaluationVO;
import com.food.biz.recipe.RecipeService;

@Controller

public class EvaluationController {
	
	@Autowired
	RecipeService recipeService;
	
	@PostMapping
	int insertEvaluation(EvaluationVO vo) {
		System.out.println(vo.toString());
		return recipeService.insertEvaluation(vo);
	}
	
	
}
