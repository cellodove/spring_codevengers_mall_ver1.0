<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<style>
.select_img img {
	margin: 20px 0;
	width: 500px;
	height: auto;
}
.inputArea { margin:10px 0; }
select { width:100px; }
label { display:inline-block; width:70px; padding:5px; }
label[for='gdsDes'] { display:block; }
input { width:150px; }
textarea#gdsDes { width:400px; height:180px; }


</style>
<title>codevengers 관리자화면</title>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="/resources/ckeditor/ckeditor.js"></script>

<script>
var regExp = /[^0-9]/gi;

$("#gdsPrice").keyup(function(){ numCheck($(this)); });
$("#gdsStock").keyup(function(){ numCheck($(this)); });

function numCheck(selector) {
 var tempVal = selector.val();
 selector.val(tempVal.replace(regExp, ""));
}
</script>
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
				<form role="form" method="post" autocomplete="off"
					enctype="multipart/form-data">

					<label>1차 분류</label> 
					<select class="category1">
						<option value="">전체</option>
					</select> 
					
					<label>2차 분류</label> 
					<select class="category2" name="item_catecode">
						<option value="">전체</option>
					</select>

					<div class="inputArea">
						<label for="gdsName">상품명</label> <input type="text" id="gdsName"
							name="item_name" />
					</div>

					<div class="inputArea">
						<label for="gdsPrice">상품가격</label> <input type="text"
							id="gdsPrice" name="item_price" />
					</div>

					<div class="inputArea">
						<label for="gdsStock">상품수량</label> <input type="text"
							id="gdsStock" name="item_allnumber" />
					</div>

					<div class="inputArea">
						<label for="gdsDes">상품소개</label>
						<textarea rows="5" cols="50" id="gdsDes" name="item_summary"></textarea>

						<script>
							var ckeditor_config = {
								resize_enaleb : false,
								enterMode : CKEDITOR.ENTER_BR,
								shiftEnterMode : CKEDITOR.ENTER_P,
								filebrowserUploadUrl : "/admin/item/ckUpload"
							};

							CKEDITOR.replace("gdsDes", ckeditor_config);
						</script>

					</div>
					<br />

					<div class="inputArea">
						<label>이미지</label> <input type="file" id="gdsImg" name="file" />
						<div class="select_img">
							<img src="" />
						</div>
					</div>
					<script>
						$("#gdsImg").change(
								function() {
									if (this.files && this.files[0]) {
										var reader = new FileReader;
										reader.onload = function(data) {
											$(".select_img img").attr("src",
													data.target.result).width(
													500);
										}
										reader.readAsDataURL(this.files[0]);
									}
								});
					</script>

					<%=request.getRealPath("/")%>

					<div class="inputArea">
						<button type="submit" id="register_Btn" class="btn btn-primary">등록</button>
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
	<script type="text/javascript"></script>
	<script>
		// 컨트롤러에서 데이터 받기
		var jsonData = JSON.parse('${category}');
		console.log(jsonData);

		var cate1Arr = new Array();
		var cate1Obj = new Object();

		// 1차 분류 셀렉트 박스에 삽입할 데이터 준비
		for (var i = 0; i < jsonData.length; i++) {

			if (jsonData[i].level == "1") {
				cate1Obj = new Object(); //초기화
				cate1Obj.cateCode = jsonData[i].cateCode;
				cate1Obj.cateName = jsonData[i].cateName;
				cate1Arr.push(cate1Obj);
			}
		}

		// 1차 분류 셀렉트 박스에 데이터 삽입
		var cate1Select = $("select.category1")

		for (var i = 0; i < cate1Arr.length; i++) {
			cate1Select.append("<option value='" + cate1Arr[i].cateCode + "'>"
					+ cate1Arr[i].cateName + "</option>");
		}

		$(document)
				.on(
						"change",
						"select.category1",
						function() {

							var cate2Arr = new Array();
							var cate2Obj = new Object();

							// 2차 분류 셀렉트 박스에 삽입할 데이터 준비
							for (var i = 0; i < jsonData.length; i++) {

								if (jsonData[i].level == "2") {
									cate2Obj = new Object(); //초기화
									cate2Obj.cateCode = jsonData[i].cateCode;
									cate2Obj.cateName = jsonData[i].cateName;
									cate2Obj.cateCodeRef = jsonData[i].cateCodeRef;

									cate2Arr.push(cate2Obj);
								}
							}

							var cate2Select = $("select.category2");

							/*
							for(var i = 0; i < cate2Arr.length; i++) {
							  cate2Select.append("<option value='" + cate2Arr[i].cateCode + "'>"
							       + cate2Arr[i].cateName + "</option>");
							}
							 */

							cate2Select.children().remove();

							$("option:selected", this)
									.each(
											function() {

												var selectVal = $(this).val();
												cate2Select.append("<option value='" + selectVal + "'>전체</option>");

												for (var i = 0; i < cate2Arr.length; i++) {
													if (selectVal == cate2Arr[i].cateCodeRef) {
														cate2Select
																.append("<option value='" + cate2Arr[i].cateCode + "'>"
																		+ cate2Arr[i].cateName
																		+ "</option>");
													}
												}

											});

						});
	</script>



</body>
</html>
