<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
	<title>codevengers mall</title>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<style>
 section#content ul li { margin:10px 0; }
 section#content ul li img { width:250px; height:250px; }
 section#content ul li::after { content:""; display:block; clear:both; }
 section#content div.thumb { float:left; width:250px; }
 section#content div.gdsInfo { float:right; width:calc(100% - 270px); }
 section#content div.gdsInfo { font-size:20px; line-height:2; }
 section#content div.gdsInfo span { display:inline-block; width:100px; font-weight:bold; margin-right:10px; }
 section#content div.gdsInfo .delete { text-align:right; }
 section#content div.gdsInfo .delete button { font-size:22px;
            padding:5px 10px; border:1px solid #eee; background:#eee;}
.allCheck { float:left; width:200px; }
.allCheck input { width:16px; height:16px; }
.allCheck label { margin-left:10px; }
.delBtn { float:right; width:300px; text-align:right; }
.delBtn button { font-size:18px; padding:5px 10px; border:1px solid #eee; background:#eee;}

.checkBox { float:left; width:30px; }
.checkBox input { width:16px; height:16px; }
.listResult { padding:20px; background:#eee; }
.listResult .sum { float:left; width:45%; font-size:22px; }

.listResult .orderOpne { float:right; width:45%; text-align:right; }
.listResult .orderOpne button { font-size:18px; padding:5px 10px; border:1px solid #999; background:#fff;}
.listResult::after { content:""; display:block; clear:both; }
 .orderInfo { border:5px solid #eee; padding:20px; display: none; }
.orderInfo .inputArea { margin:10px 0; }
.orderInfo .inputArea label { display:inline-block; width:120px; margin-right:10px; }
.orderInfo .inputArea input { font-size:14px; padding:5px; }
#userAddr2, #userAddr3 { width:250px; }

.orderInfo .inputArea:last-child { margin-top:30px; }
.orderInfo .inputArea button { font-size:20px; border:2px solid #ccc; padding:5px 10px; background:#fff; margin-right:20px;}
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
			<ul>
				
				 <li>
  					<div class="allCheck">
   						<input type="checkbox" name="allCheck" id="allCheck" /><label for="allCheck">모두 선택</label> 
  						<script>
						$("#allCheck").click(function(){
						 var chk = $("#allCheck").prop("checked");
 							if(chk) {
 							 $(".chBox").prop("checked", true);
 							} else {
  						$(".chBox").prop("checked", false);
 							}
						});
						</script>
  					
  					</div>
  
  					<div class="delBtn">
   						<button type="button" class="selectDelete_btn">선택 삭제</button> 
  					</div>
  
 					</li>
			
				<c:set var="sum" value="0"/>
				<c:forEach items="${wishListList}" var="wishListList">
					<li>
						<div class="checkBox">
   							<input type="checkbox" name="chBox" class="chBox" data-cartNum="${wishListList.wishlist_num}" />
   							<script>
 							$(".chBox").click(function(){
  							$("#allCheck").prop("checked", false);
 							});
							</script>
  						</div>
					
						
						<div class="thumb">
							<img src="${wishListList.item_thumbImg}" />
						</div>
						<div class="gdsInfo">
							<p>
								<span>상품명</span>${wishListList.item_name}<br /> 
								<span>개당 가격</span>
								<fmt:formatNumber pattern="###,###,###"	value="${wishListList.item_price}" />원<br/> 
								<span>구입 수량</span>${wishListList.wishlist_stock} 개<br/> 
								<span>최종가격</span>
								<fmt:formatNumber pattern="###,###,###"	value="${wishListList.item_price * wishListList.wishlist_stock}" />원
							</p>
							
							
							<div class="delete">
     							<button type="button" class="delete_${wishListList.wishlist_num}_btn" data-cartNum="${wishListList.wishlist_num}">삭제</button>
    							<script>
 								$(".delete_${wishListList.wishlist_num}_btn").click(function(){
  								var confirm_val = confirm("정말 삭제하시겠습니까?");
  
  								if(confirm_val) {
   								var checkArr = new Array();
   
   								$("input[class='chBox']:checked").each(function(){
   								 checkArr.push($(this).attr("data-cartNum"));
   								});
    
   								$.ajax({
    								url : "/shop/deleteWishList",
    								type : "post",
   									data : { chbox : checkArr },
								    success : function(result){
								    	if(result == 1) {          
								    		   location.href = "/shop/wishListList";
								    		  } else {
								    		   alert("삭제 실패");
								    		  }
								    }
								   });
								  } 
								 });
								</script>
    						
    						</div>
						</div>
					</li>
					<c:set var="sum" value="${sum + (wishListList.item_price * wishListList.wishlist_stock) }"/>
				</c:forEach>
			</ul>
			
		<div class="listResult">
			<div class="sum">
				총 합계:  <fmt:formatNumber pattern="###,###,###" value="${sum}" />원
			</div>
			
			<div class="orderOpne">
  				<button type="button" class="orderOpne_bnt">주문 정보 입력</button>
  				<script>
 $(".orderOpne_bnt").click(function(){
  $(".orderInfo").slideDown();
  $(".orderOpne_bnt").slideUp();
 });      
</script>
			</div>
		</div>
		
		<div class="orderInfo">
 <form role="form" method="post" autocomplete="off">
    
  <input type="hidden" name="cor_amount" value="${sum}" />
    
  <div class="inputArea">
   <label for="">수령인</label>
   <input type="text" name="cor_rec" id="orderRec" required="required" />
  </div>
  
  <div class="inputArea">
   <label for="orderPhon">수령인 연락처</label>
   <input type="text" name="mem_tel1" id="orderPhon" required="required" />-
   <input type="text" name="mem_tel2" id="orderPhon" required="required" />-
   <input type="text" name="mem_tel3" id="orderPhon" required="required" />
  
  </div>
  
  <div class="inputArea">
   <label for="userAddr1">우편번호</label>
   <input type="text" name="mem_zipcode" id="userAddr1" required="required" />
  </div>
  
  <div class="inputArea">
   <label for="userAddr2">1차 주소</label>
   <input type="text" name="mem_adress1" id="userAddr2" required="required" />
  </div>
  
  <div class="inputArea">
   <label for="userAddr3">2차 주소</label>
   <input type="text" name="mem_adress2" id="userAddr3" required="required" />
  </div>
  
  <div class="inputArea">
   <button type="submit" class="order_btn">주문</button>
   <button type="button" class="cancel_btn">취소</button> 
   <script>
$(".cancel_btn").click(function(){
 $(".orderInfo").slideUp();
 $(".orderOpne_bnt").slideDown();
});      
</script>
  </div>
  
 </form> 
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
