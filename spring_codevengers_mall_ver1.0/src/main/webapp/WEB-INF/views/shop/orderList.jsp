<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
	<title>codevengers mall</title>
<style>
/*  section#content ul li { display:inline-block; margin:10px; }
 section#content div.goodsThumb img { width:200px; height:200px; }
 section#content div.goodsName { padding:10px 0; text-align:center; }
 section#content div.goodsName a { color:#000; } */
 
 section#content ul li { border:5px solid #eee; padding:10px 20px; margin-bottom:20px; }
 section#content .orderList span { font-size:20px; font-weight:bold; display:inline-block; width:90px; margin-right:10px; }
</style>	
</head>
<body>
<div>

	<header>
		<div>
			<%@ include file="../include/header.jsp" %>
		</div>
	</header>
	<aside>
		<%@ include file="../include/aside.jsp"%>
	</aside>
	
	<nav>
		<div>
			<%@ include file="../include/nav.jsp" %>
		</div>
	</nav>







	<section id="container">
		<div id="container_box">
			<section id="content">
				 <ul class="orderList">
  					<c:forEach items="${mallOrderList}" var="mallOrderList">
  					<li>
  					<div>
   						<p><span>주문번호</span><a href="/shop/orderView?n=${mallOrderList.cor_id}">${mallOrderList.cor_id}</a></p>
					    <p><span>수령인</span>${mallOrderList.cor_rec}</p>
					    <p><span>주소</span>(${mallOrderList.mem_zipcode}) ${mallOrderList.mem_adress1} ${mallOrderList.mem_adress2}</p>
					    <p><span>가격</span><fmt:formatNumber pattern="###,###,###" value="${mallOrderList.cor_amount}" /> 원</p>
					 </div>
					 </li>
					 </c:forEach>
 					</ul>
				
			 </section>
		 </div>
	 </section>
	
	
	
	
	
	
	
	
	
	<footer>
		<div>
			<%@ include file="../include/footer.jsp" %>
		</div>
	</footer>



</div>




</body>
</html>
