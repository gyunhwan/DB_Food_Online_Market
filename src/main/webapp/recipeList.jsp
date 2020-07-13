<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.food.biz.recipe.RecipeVO"%>
<%
	List<RecipeVO> recipeList = (List) request.getAttribute("recipeList");
	String member_email = (String) session.getAttribute("member_email");
	String member_name = (String) session.getAttribute("member_name");
	Integer member_grade_code = (Integer) session.getAttribute("member_grade_code");
	Integer admin = (Integer) session.getAttribute("admin");
	List<RecipeVO> popularRecipe = (List) request.getAttribute("popularRecipe");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.card {
	float: left;
	margin: 15px 15px 15px 15px;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	transition: 0.3s;
	width: 30%;
}

.card:hover {
	box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
}

.container {
	padding: 2px 16px;
}
.mySlides {display:none; visibility:gone}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta content="text/html; charset=iso-8859-2" http-equiv="Content-Type">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body>
	<div class="container style="text-align:center">

		<div class="row">
			<div class="col"></div>
			<div class="col">
				<form action="recipeSearch.do" method="post">
					<input style="width: 70%; float: left" class="input-group-text"
						type="text" name="recipe_name"> <input
						class="btn btn-success" type="submit" value="검색">
				</form>
			</div>
			<div class="col"></div>

		</div>
		<div class="w3-content w3-display-container">

 
			<%if (popularRecipe!=null){for(RecipeVO vo:  popularRecipe){%>

				<div  class="mySlides">
					<div class="card" style="width:100%">
					<img src="http://localhost:8080\biz\img\<%=vo.getRecipe_image()%>"
						style="width: 100%; height: 300px" class="card-img-top"
						onclick="location.href='recipeDetail.do?recipe_code=<%=vo.getRecipe_code()%>'">

					<h5 class="card-title">
						<%=vo.getRecipe_name()%></h5>
					<p class="card-text">
						<%=vo.getRecipe_grade()%></p>
				</div>
				</div>

			<%} }%>

		</div>


		<div style="margin-left: auto; margin-right: auto;">
			<%
				for (RecipeVO recipe : recipeList) {
			%>
			<div class="card">
				<img
					src="http://localhost:8080\biz\img\<%=recipe.getRecipe_image()%>"
					style="width: 100%; height: 300px"
					onclick="location.href='recipeDetail.do?recipe_code=<%=recipe.getRecipe_code()%>'">
				<div class="container">
					<p style="text-align: center"><%=recipe.getRecipe_name()%></p>
					<p style="text-align: center"><%=recipe.getRecipe_grade()%></p>
				</div>
				
			</div>
			<%
				}
			%>
		</div>
	</div>
</body>
<script>
var myIndex = 0;
carousel();

function carousel() {
  var i;
  var x = document.getElementsByClassName("mySlides");
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";  
  }
  myIndex++;
  if (myIndex > x.length) {myIndex = 1}    
  x[myIndex-1].style.display = "block";  
  setTimeout(carousel, 2000); // Change image every 2 seconds
}
</script>

</html>