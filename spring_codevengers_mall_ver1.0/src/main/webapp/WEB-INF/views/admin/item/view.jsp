<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<title>codevengers 관리자화면</title>
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
				<h2>상품등록</h2>
				<form role="form" method="post" autocomplete="off">
					<div>
					<label>1차 분류</label> 
					<span class="category1"></span>
					 
					<label>2차 분류</label> 
					<span class="category2"></span>
					
					</div>

					<div class="inputArea">
						<label for="gdsName">상품명</label> 
						<span>${mallItem.item_name}</span>
					</div>

					<div class="inputArea">
						<label for="gdsPrice">상품가격</label> 
						<span>${mallItem.item_price}</span>
					</div>

					<div class="inputArea">
						<label for="gdsStock">상품수량</label> 
						<span>${mallItem.item_allnumber}</span>
					</div>

					<div class="inputArea">
						<label for="gdsDes">상품소개</label>
						<span>${mallItem.item_summary}</span>
					</div>

					<div class="inputArea">
						 <button type="button" id="register_Btn" class="btn btn-warning">수정</button>
						 <button type="button" id="register_Btn" class="btn btn-danger">삭제</button>
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
