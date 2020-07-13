<%@page import="com.food.biz.recipe.EvaluationVO"%>
<%@page import="com.food.biz.recipe.RecipeDetailDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.food.biz.recipe.RecipeVO"%>
<%
	java.text.SimpleDateFormat formatter2 = new java.text.SimpleDateFormat("MM");
	String today2 = formatter2.format(new java.util.Date());

	List<RecipeDetailDTO> recipeFood = (List<RecipeDetailDTO>) request.getAttribute("recipeFood");
	RecipeVO recipe = (RecipeVO) request.getAttribute("recipe");
	String member_email = (String) session.getAttribute("member_email");
	String member_name = (String) session.getAttribute("member_name");
	Integer member_grade_code = (Integer) session.getAttribute("member_grade_code");
	Integer admin = (Integer) session.getAttribute("admin");
	List<EvaluationVO> comment = (List<EvaluationVO>) request.getAttribute("comment");
	System.out.println(recipeFood.toString());
%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Anton&display=swap"
	rel="stylesheet">
<meta charset="UTF-8">
<style>
#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</style>
</head>
<body>
	
	<div class="container">
	<div class="row" style="width: 100%;text-align:center">
		<h1 style="width: 50%; font-family: 'Anton', sans-serif;"><%=recipe.getRecipe_name()%></h1>
		<h1 style="width: 50%; font-family: 'Pacifico', cursive;">
			등급:<%=recipe.getRecipe_grade()%></h1>
	</div>
		<div class=row>
			<div class=col>
				<img
					style="width:100%"
					src="http://localhost:8080/biz/img/<%=recipe.getRecipe_image()%>">
			</div>
			<div class=col>
				<jsp:include page="./foodList.jsp" />
			</div>
		</div>
	<div class=row>
	<div class=col>
	<table id="customers">
		<tr >
			<th colspan="2" stlye="font-family: 'Anton', sans-serif;">만드는법</th>
		</tr>
		<tr>
			<td colspan="2"><%=recipe.getRecipe_comment()%></td>

		</tr>
		<tr>
			<th>재료명</th>
			<th>양</th>
		</tr>
		<%
			System.out.println(recipeFood.size());
			for (int a = 0; a < recipeFood.size(); a++) {
		%>
		<tr>
			<td><a
				href=<%="http://localhost:8080/biz/recipeDetail.do?recipe_code=" + recipe.getRecipe_code()
						+ "&food_name=" + recipeFood.get(a).getFood_name()%>><%=recipeFood.get(a).getFood_name()%></a></td>
			<td><%=recipeFood.get(a).getRecipe_food_amount()%> <%=recipeFood.get(a).getFood_unit()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<form action="123123123.do" method="post">
		<input type="hidden" name="member_email" value="<%=member_email%>" />
		<input type="hidden" name="recipe_code" 
			value="<%=recipe.getRecipe_code()%>" /> <input type="submit"
			value="최저가로 구매하기" class="btn btn-success">
	</form>
	</div>
	<div class=col>
	<table id="customers" border="1">
		<tr>
			<th>아이디</th>
			<th>평가글</th>
			<th>평가점수</th>
			<th>등록</th>
		</tr>
		<%
			if (member_email != null) {
		%>
		<tr>
			<form action="evaluation.do" method="post">
				<td><%=member_email%><input type="hidden" name="member_eamil"
					value=<%=member_email%> /></td>
				<td><input type="text" name="evaluation_comment" /></td>
				<td><input type="text" name="evaluation_point" /></td> <input
					type="hidden" name="recipe_code" value=<%=recipe.getRecipe_code()%> />
				<input type="hidden" name="member_email" value="<%=member_email%>">
				<input type="hidden" name="evaluation_month" value="<%=today2%>">
				<td><input type="submit" value="등록"></td>
			</form>
		</tr>
		<%
			}
		%>
		<%
			for (EvaluationVO evaluation : comment) {
		%>
		<tr>
			<td><%=evaluation.getMember_email()%></td>
			<td><%=evaluation.getEvaluation_comment()%></td>
			<td colspan=2><%=evaluation.getEvaluation_point()%></td>
		</tr>
		<%
			}
		%>

	</table>
	</div>
	</div>
	</div>
	
</body>
</html>