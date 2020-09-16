<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
	<title>codevengers mall</title>
<style>
.orderInfo { border:5px solid #eee; padding:10px 20px; margin:20px 0;}
 .orderInfo span { font-size:20px; font-weight:bold; display:inline-block; width:90px; }
 
 .orderView li { margin-bottom:20px; padding-bottom:20px; border-bottom:1px solid #999; }
 .orderView li::after { content:""; display:block; clear:both; }
 
 .thumb { float:left; width:200px; }
 .thumb img { width:200px; height:200px; }
 .gdsInfo { float:right; width:calc(100% - 220px); line-height:2; }
 .gdsInfo span { font-size:20px; font-weight:bold; display:inline-block; width:100px; margin-right:10px; }
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





<section id="content">

 <div class="orderInfo">
  <c:forEach items="${mallOrderListVO}" var="mallOrderListVO" varStatus="status">
   
   <c:if test="${status.first}">
    <p><span>수령인</span>${mallOrderListVO.cor_rec}</p>
    <p><span>주소</span>(${mallOrderListVO.mem_zipcode}) ${mallOrderListVO.mem_adress1} ${mallOrderListVO.mem_adress2}</p>
    <p><span>가격</span><fmt:formatNumber pattern="###,###,###" value="${mallOrderListVO.cor_amount}" /> 원</p>
   </c:if>
   
  </c:forEach>
 </div>
 
 <ul class="orderView">
  <c:forEach items="${mallOrderListVO}" var="mallOrderListVO">     
  <li>
   <div class="thumb">
    <img src="${mallOrderListVO.item_thumbImg}" />
   </div>
   <div class="gdsInfo">
    <p>
     <span>상품명</span>${mallOrderListVO.item_name}<br />
     <span>개당 가격</span><fmt:formatNumber pattern="###,###,###" value="${mallOrderListVO.item_price}" /> 원<br />
     <span>구입 수량</span>${mallOrderListVO.wishlist_stock} 개<br />
     <span>최종 가격</span><fmt:formatNumber pattern="###,###,###" value="${mallOrderListVO.item_price * mallOrderListVO.wishlist_stock}" /> 원                  
    </p>
   </div>
  </li>     
  </c:forEach>
 </ul>
</section>


	
	
	
	
	
	
	
	
	<footer>
		<div>
			<%@ include file="../include/footer.jsp" %>
		</div>
	</footer>



</div>




</body>
</html>
