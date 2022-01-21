package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;

@RestController
public class Lesson03Ex04RestController {
	
	@Autowired
	private ReviewBO reviewBO;
	
	//http://localhost:8080/lesson03/ex04?id=23
	@RequestMapping("/lesson03/ex04")
	public String quiz04(
			@RequestParam("id") int id
			) {
		
		int rowCount = reviewBO.deleteReviewById(id);
		return "삭제완료: " + rowCount;
	}
}
