package com.food.biz.recipe;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter @Setter @ToString
public class RecipeVO {
	private int recipe_code;
	private String recipe_name;
	private String recipe_comment;
	private String recipe_grade;
	private String recipe_image;
	
	private int recipe_food_code;
	private int food_code;
	private int recipe_food_amount;
	

	private String food_name;
	private String food_unit;
	private List<RecipeFoodVO> recipe_food;

}
