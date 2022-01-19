package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.dao.ReviewDAO;
import com.example.lesson03.model.Review;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewDAO reviewDAO; // private 관례적으로 붙인다. 
	
	public Review getReview(int id) {
		return reviewDAO.selectReview(id); //dao에 전달
	}
}
