package com.food.biz.recipe;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class RecipeFoodVO {
   int recipe_code;
   String food_code;
   String food_amount;
   String recipe_food_code;
}
