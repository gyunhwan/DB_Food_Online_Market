package com.food.biz.recipe;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class RecipeDetailDTO {
   private int recipe_code;
   private String food_code;
   private String food_amount;
   private String recipe_food_code;
   private String recipe_name;
   private String recipe_comment;
   private String recipe_grade;
   private String recipe_image;
   private int recipe_food_amount;
   private String food_name;
   private String food_unit;   
}