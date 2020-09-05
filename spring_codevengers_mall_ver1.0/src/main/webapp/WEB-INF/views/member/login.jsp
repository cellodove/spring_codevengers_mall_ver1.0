<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<section id="content">
 <form role="form" method="post" autocomplete="off">
  <div class="input_area">
   <label>아이디</label>
   <input type="text"  name="mem_id" required="required" />      
  </div>
  
  <div class="input_area">
   <label>패스워드</label>
   <input type="password"  name="mem_passwd" required="required" />      
  </div>
       
  <button type="submit"  name="signin_btn">로그인</button>
  
  <c:if test="${msg == false}">
   <p style="color:#f00;">로그인에 실패했습니다.</p>
  </c:if>
  
 </form>   
</section>

</body>
</html>