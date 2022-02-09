<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이름 추가하기</title>

	<!-- bootstrap CDN link -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<!-- Ajax 쓰려면 전체의 jQuery가져와야 한다 -->
  <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<b>이름:</b>
		<div class="d-flex">
			<input type="text" class="form-control col-3" id="name" placeholder="이름을 입력하세요.">
			<button type="button" id="nameCheckBtn"class="btn btn-info">중복확인</button>
		</div>
		
		<div id="nameStatusArea"></div>
		
		<button type="submit" id="joinBtn" class="btn btn-primary mt-5">가입하기</button>
		
		
	</div>
	
<script>
$(document).ready(function(e){ //무조건 console확인하면서 하기
	//중복 확인 버튼 클릭
	$("#nameCheckBtn").on('click', function(e) {
		let name = $("#name").val().trim();
		
		//div 태그 안의 내용을 모두 비운다.(append라 계속 추가됨)
		$("#nameStatusArea").empty();
		
		//validation check
		if (name == "") {
			$("#nameStatusArea").append('<span class="text-danger">이름이 비어있습니다.</span>'); //태그를 넣어줄거라 text가 아니라 append 함수를 쓴다.
			//alert("이름을 입력하세요");
			return;
		}
		
		//이름이 중복되는지 확인(DB) -> AJAX
		$.ajax({
			type: "GET"
			, url: "/is_duplication"
			, data: {"name":name}
			, success: function(data) {
				//alert(data.is_duplication) //true
				if (data.is_duplication == true) {
				$("#nameStatusArea").append('<span class="text-danger">중복된 이름입니다.</span>'); //서버를 거친 후에 response를 받아서 그에 따른 동적, 화면은 머무르면서 일부분만 다르게 한다.
				}
			}
			, error: function(e) {
				alert("error");
			}
		});
	});
		// 회원가입 버튼 클릭
		$("#joinBtn").on('click', function(e){
			e.preventDefault(); //기본동작 멈춤
			
			//nameStatusArea 태그 안에 누가 있는지 
			if ($('nameStatusArea').children().length > 0) { // 안의 자식이 몇개 인지 나온다.
				alert("서브밋 불가");
			} else {
				alert("서브밋 가능");
			}
			
		});
	
});
</script>
</body>
</html>