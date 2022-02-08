<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 추가 화면</title>

	<!-- bootstrap CDN link -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<!-- Ajax 쓰려면 전체의 jQuery가져와야 한다 -->
  <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<h1>회원 정보 추가</h1>
		
		<form method="post" action="/lesson06/add_user">
			<div class="form-group">
				<label for="name">이름: </label>
				<input type="text" id="name"class="form-control" name="name" placeholder="이름을 입력하세요.">
			</div>
			<div class="form-group">
				<label for="yyyymmdd">생년월일: </label>
				<input type="text" id="yyyymmdd" class="form-control" name="yyyymmdd" placeholder="예) 19991011">
			</div>
			<div class="form-group">	
				<label for="email">이메일 주소: </label>
				<input type="text" id="email" class="form-control" name="email" placeholder="이메일 주소를 입력하세요.">
			</div>
			<div class="form-group">	
				<label for="introduce">자기소개: </label>
				<textarea class="form-control" id="introduce" name="introduce" rows="10" cols="10"></textarea>
			</div>
			
			<input type="button" id="addBtn" class="btn btn-success" value="추가">
			
		</form>
	</div>
	
	
	
<script>
$(document).ready(function(e){
	// 1) jquery의 submit 기능 이용하기, 아래는 태그 자체를 가지고 온다.
	/* $('form').on('submit', function(e){ //form태그 안의 모든 태그들을 가지고 온다
		//e.preventDefault(); // submit이 되는 것을 막는다.(고유한 기능을 멈추게 하는 함수이며 제일 상단에 넣는다. -> submit해도 안넘어간다.)
		//alert("서브밋");
		
		//validation check
		let name = $('#name').val().trim();
		if (name.length < 1) {
			alert("이름을 입력하세요.");
			return false;
		} 
		
		let yyyymmdd = $('#yyyymmdd').val().trim();
		if (yyyymmdd == "") {
			alert("생년월일을 입력하세요");
			return false;
		}
		
		let email = $('#email').val().trim();
		if (email = "") {
			alert("이메일을 입력하세요");
			return false;
		}
		
		// 유효성 체크 통과=> 여기까지 도달하면 submit
	}); */
	
	// 2) jquery의 Ajax통신 이용하기(submit있으면 안된다. -> 그러니 굳이 form태그를 사용하지 않아도 된다.)
	//-- 버튼의 타입을 submit -> button 변경
	// event를 버튼이 눌리면으로 할것이기에 버튼에 id명 넣어주고 그걸로 event만든다.
	$("#addBtn").on('click', function(e){
		//alert("클릭");
		
		//validation check
		let name = $('#name').val().trim();
		if (name.length < 1) {
			alert("이름을 입력하세요.");
			return;
		} 
		
		let yyyymmdd = $('#yyyymmdd').val().trim();
		if (yyyymmdd == "") {
			alert("생년월일을 입력하세요");
			return;
		}
		
		// 모두 숫자인지 확인
		if (isNaN(yyyymmdd)) { //isNaN 숫자가 아닌 문자가 있을때 true
			alert("숫자만 입력해주세요");
			return;
		}
		
		let email = $('#email').val();
		if (email == "") {
			alert("이메일을 입력하세요");
			return;
		}
		
		let introduce = $('#introduce').val();
		
		console.log(name);
		console.log(yyyymmdd);
		console.log(email);
		console.log(introduce);
		
		//AJAX통신: form태그와 상관없이 비동기로 요청(request)
		$.ajax({
			type:'POST'
			, url:'/lesson06/add_user'
			, data: {'name':name, 'yyyymmdd':yyyymmdd, 'email':email, 'introduce':introduce} //JSON으로 구성
			, success: function(data) {//완전한 성공 200, response로 넘어온 값을 넣는다. 보통 JSON으로 값들을 주고 받는다.
				alert(data);
				location.href ="https://google.com" // form태그와 동일하게 화면이 전환된다.
				//location.reload(); //새로고침 
			}
			, complete: function(data) { // 성공하든 실패하든, 실행이 되면 -> 잘 쓰진않는다
				alert("완료");
			}
			, error: function(e) { // 에러가 날때
				alert("error: " + e);
			}
		});
		
	});
	
	
	
});


</script>
</body>
</html>