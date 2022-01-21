package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;

@RestController
public class Lesson03Ex03RestController {
	
	@Autowired
	private ReviewBO reviewBO;
	
	// http://localhost:8080/lesson03/ex03?id=24&review=도미노피자 역시 맛있어~~
	// 받는 파라미터는 내가 정하면 되는것ㅇ임 @RequestParam()
	@RequestMapping("/lesson03/ex03")
	public String ex03(
			@RequestParam(value="id", required=true) int id,
			@RequestParam(value="review", required=true) String review
			) {
		
		//update도 insert와 동일하게 바뀌고 return값이 없어서 int로 성공한 행의 개수를 받을것이다.
		int rowCount = reviewBO.updateReviewById(id, review);
		return "변경 완료: " + rowCount;
	}
}
