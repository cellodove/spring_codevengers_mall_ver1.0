<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<style>
.oriImg{width: 500px;height: auto;}
.thumbImg{}
.gdsDes img {max-width: 600px; height: auto;}
</style>
<title>codevengers 관리자화면</title>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
</head>
<body>
	<div>
		<header>
			<div>
				<%@ include file="../include/header.jsp"%>
			</div>
		</header>

		<nav>
			<div>
				<%@ include file="../include/nav.jsp"%>
			</div>
		</nav>

		<section id="container">
			<aside>
				<%@ include file="../include/aside.jsp"%>
			</aside>
			<div id="container_box">
				<h2>상품조회</h2>
				<form role="form" method="post" autocomplete="off">

					<input type="hidden" name="n" value="${mallItem.item_num}">

					<div>
						<label>1차 분류</label> <span class="category1"></span> <label>2차
							분류</label> <span class="category2"></span>

					</div>

					<div class="inputArea">
						<label for="gdsName">상품명</label> <span>${mallItem.item_name}</span>
					</div>

					<div class="inputArea">
						<label for="gdsPrice">상품가격</label> <span>${mallItem.item_price}</span>
					</div>

					<div class="inputArea">
						<label for="gdsStock">상품수량</label> 
						<span>${mallItem.item_allnumber}</span>
						
					
					</div>

					<div class="inputArea">
						<label for="gdsDes">상품소개</label> 
						<%-- <span>${mallItem.item_summary}</span> --%>
						<div class="gdsDes">${mallItem.item_summary}</div>
					</div>

					<div>
						<label for="gdsImg">이미지</label>
						<p>원본 이미지</p>
						<img src="${mallItem.item_picture}" class="oriImg" />

						<p>썸네일</p>
						<img src="${mallItem.item_thumbImg}" class="thumbImg" />

					</div>



					<div class="inputArea">

						<button type="button" id="modify_Btn" class="btn btn-warning">수정</button>
						<button type="button" id="delete_Btn" class="btn btn-danger">삭제</button>

						<script>
							var formObj = $("form[role='form']");
							$("#modify_Btn").click(function() {
								formObj.attr("action", "/admin/item/modify");
								formObj.attr("method", "get");
								formObj.submit();
							});

							$("#delete_Btn").click(
									function() {
										var con = confirm("정말로 삭제하시겠습니까?");
										if (con) {
											formObj.attr("action",
													"/admin/item/delete");
											formObj.submit();
										}
									});
						</script>


					</div>
				</form>
			</div>
		</section>

		<footer>
			<div>
				<%@ include file="../include/footer.jsp"%>
			</div>
		</footer>
	</div>
</body>
</html>
