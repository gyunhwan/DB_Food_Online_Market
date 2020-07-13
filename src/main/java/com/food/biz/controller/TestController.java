package com.food.biz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.food.biz.food.FoodService;
import com.food.biz.recipe.RecipeService;
import com.food.biz.recipe.RecipeVO;

@Controller
@RequestMapping(value = "/test.do")
@CrossOrigin
public class TestController {
   @Autowired
   FoodService foodService;
   @Autowired
   RecipeService recipeService;
   @RequestMapping(method=RequestMethod.POST)
   public @ResponseBody Object test(ModelAndView mav,@RequestBody RecipeVO vo) {
      System.out.println("test()==> "+vo.toString());
      recipeService.insertRecipe(vo);
      vo.setRecipe_code(recipeService.getRecipeCode(vo).getRecipe_code());
      recipeService.insertRecipeFood(vo); 
      mav.addObject("recipeList", recipeService.recipeList());
      
      return true;

   }

   @GetMapping
   public ModelAndView goTest(ModelAndView mav) {
      mav.addObject("data", foodService.getFoodList());
      mav.addObject("page", "test.jsp");
      mav.setViewName("index.jsp");
      return mav;
   }
}