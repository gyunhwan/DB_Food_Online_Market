<%@page import="com.food.biz.food.FoodVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%
   List<FoodVO> food=(List) request.getAttribute("data");
   FoodVO selectVO=new FoodVO();
   System.out.println(food.toString());
   String url=(String) request.getAttribute("url");
%>
<!DOCTYPE html>
<html>
<head>
<script src="jquery-3.4.1.min.js"></script>
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
   $(document).ready(function() {
      $('#a').click(function() {
         var $table = $(".food");
         var tr=$("<tr></tr>");
         var td1=$('<th>레시피재료</th><td><select style="width:100%" name="food_name" class="recipe_food"><% for(FoodVO vo:food){ %><option value=<%=vo.getFood_code()%>>재료명:<%=vo.getFood_name()%>  단위:<%=vo.getFood_unit()%></option><%}%></select></td>')
         var td2=$('<td><input class="food_amount" type="text" name="recipe_food_amount" placeholder="수량"></td>');
         tr.append(td1);
         tr.append(td2);
         $table.append(tr);
         })
      $('#b').click(function(){
         var size=$('select[name="food_name"]').length;
         var data={};
         var recipe_food=[];
         data.recipe_name=$("input[name='recipe_name']")[0].value;
         data.recipe_comment=$("input[name='recipe_comment']")[0].value;
         data.recipe_grade=$("input[name='recipe_grade']")[0].value;
         data.recipe_image=$("input[name='recipe_image']")[0].value;
         for(i=0;i<size;i++){
            var recipe={};
            recipe.food_code=$('select[name="food_name"]').eq(i)[0].value;
            recipe.food_amount=$('input[name="recipe_food_amount"]').eq(i)[0].value;
            recipe_food.push(recipe);
         }
         data.recipe_food=recipe_food;
         $.ajax({
            url:"http://localhost:8080/biz/test.do",
            type:"post",
            dataType:"json",
            contentType:"application/json;charset=utf-8",
            data:JSON.stringify(data),
            crossDomain:true,
            contentType : 'application/json; charset=UTF-8',
            success:function(data){
               alert("등록완료");
               window.location.href = "http://localhost:8080/biz/recipeList.do";

            }
         })
      })
   })
</script>
<meta charset="EUC-KR">
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

#customers tr:nth-child(even) {
	background-color: #f2f2f2;
}

#customers tr:hover {
	background-color: #ddd;
}

#customers th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #4CAF50;
	color: white;
}

.custom {
	margin: 50px 0 0 0;
}
</style>
<title>Insert title here</title>
</head>
<body>
   
      <table id="customers" class="food">
         <tr>
         <form action="upload2.do" method="post" enctype="multipart/form-data">
         <th>사진</th>
         <td><input type="file" name="file1"></td>
         <td><input type="submit" value="사진등록" class="btn btn-success"></td>
      
      </form>
         </tr>
         <tr>
         	<th>레시피 사진명</th>
         	<td colspan="2"><%=url %></td>
         </tr>
         <tr>
            <th>레시피 이름</th>
            <td colspan="2" ><input id="recipe_name" type="text" name="recipe_name" value=""></td>
         </tr>
         <tr>
            <th>레시피 설명</th>
            <td colspan="2"><input type="recipe_comment" name="recipe_comment"></td>
         </tr>
         <tr>
            <th>레시피 재료</th>
            <td>
            <select style="width:100%" class="recipe_food" name="food_name">
               <% for(FoodVO vo:food){ %>
                  <option value=<%=vo.getFood_code()%>>재표명:<%=vo.getFood_name()%>  단위:<%=vo.getFood_unit() %></option>
               <%} %>
            </select>
            </td>
            <td><input class="food_amount" type="text" name="recipe_food_amount"
               placeholder="수량"></td>
         </tr>
         <tr>
            <td>
            <input  type="hidden" name="recipe_grade" value="댓글 5개 이상부터 등급부여"></td>
            <input  type="hidden" name="recipe_image" value=<%=url %>></td>
         </tr>
      </table>
      
   <button id="b">등록</button>
   <button id="a">재료추가</button>
</body>
</html>
</body>
</html>