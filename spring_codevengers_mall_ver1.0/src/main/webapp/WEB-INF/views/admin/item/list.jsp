<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>codevengers 관리자화면</title>
<style>
#container_box table td { width:100px; }
#container_box table img {width: 150px; height: auto;}
</style>
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
				<h2>상품목록</h2>
				<table>
					<thead>
						<tr>
							<th>썸네일</th>
							<th>번호</th>
							<th>이름</th>
							<th>카테고리</th>
							<th>크기</th>
							<th>성별</th>
							<th>가격</th>
							<th>수량</th>
							<th>등록일자</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="list">
							<tr>
								<td>
									<img src="${list.item_thumbImg}">
								</td>
							
								<td>${list.item_num}</td>
								<td>
									<a href="/admin/item/view?n=${list.item_num}">${list.item_name}</a>								
								</td>
								<td>${list.cateName}</td>
								<td>${list.item_size}</td>
								<td>${list.item_gender}</td>
								<td>
								<fmt:formatNumber value="${list.item_price}" pattern="###,###,###"/>
								</td>
								<td>${list.item_allnumber}</td>
								<td>
								<fmt:formatDate value="${list.item_date}" pattern="yyyy-mm-dd"/>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
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
