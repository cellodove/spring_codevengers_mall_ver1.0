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
     							<button type="button" class="delete_btn" data-cartNum="${wishListList.wishlist_num}">삭제</button>
    							<script>
 								$(".selectDelete_btn").click(function(){
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
