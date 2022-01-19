package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.model.Review;

@RestController
public class Lesson03Ex01RestController {
	
	@Autowired
	private ReviewBO reviewBO;
	
	// 하나만 가지고 올것이다.
	// http://localhost:8080/lesson03/ex01
	// http://localhost:8080/lesson03/ex01?id=7
	@RequestMapping("/lesson03/ex01")
	public Review ex01(	//넘어오는 값인 id를 int id에 담을것이다. 이렇게 쓰면 필수파라미터라는 전제하에 아래와 같이 쓴거임
			//@RequestParam("id") int id //하나만 있을때는 value없어도 된다. 띄어쓰기 안하는걸 권장
			//@RequestParam(value="id", required=true) int id  //여기선 value 필수임, 필수파라미터의 여부: true = 필수파라미터이다.
			//@RequestParam(value="id", required=false) Integer id //비필수, null이 들어올수있음-> Integer로 선언(int는 오류생김)
			@RequestParam(value="id", defaultValue="1") int id // 비필수 + 기본값 , 여긴 항상 값이 있으니까 int로 해도된다. int와 Integer의 사용은 명확하게 한다. 다른 개발자끼리 보면서 nullable을 판단하기때문
			
			) {
		
		System.out.println("####################### id: " + id); //console에 뜬다.
		return reviewBO.getReview(id); // BO에 id전달
		// id가 null이다 -> BO에게 전달 -> BO가 int로 받고 있음 -> BO는 null 저장못함 오류생김
		// 1. BO의 type을 Integer로 바꾸든 2) null값이 들어올경우 값을 넘기지않는다고 예외처리하든
		// null이 절대 안들어온다 -> int쓰기
	}
}
