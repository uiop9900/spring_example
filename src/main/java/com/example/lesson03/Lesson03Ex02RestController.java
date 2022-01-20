package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.model.Review;

@RequestMapping("/lesson03/quiz02")
@RestController
public class Lesson03Ex02RestController {
	
	@Autowired
	private ReviewBO reviewBO;
	
	// http://localhost/lesson03/ex02/1
	@RequestMapping("/1")
	public String ex02_1() {//ResponseBody있어서 경로아니고 리얼 String
		Review review = new Review(); //일반 자바 빈
		review.setStoreId(7);
		review.setMenu("삼겹혼밥세트");
		review.setUserName("uiop9900");
		review.setPoint(4.5);
		review.setReview("혼자 먹기 딱 적당하네요");
		
 		int rowCount = reviewBO.addReview(review); // insert된 row 수를 리턴받는다.
 		
		return "success row count: " + rowCount;
		
	}
	
}
 