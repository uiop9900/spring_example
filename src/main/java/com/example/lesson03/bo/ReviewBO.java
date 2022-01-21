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
	
	
	public int addReview(Review review) {//insert는 값을 넣고 끝이기에 void로 해도 되지만, int로 하면 몇 행이 insert가 되었는지 알수있다.
		return reviewDAO.insertReview(review);
	}
	
	public int addReviewAsField(int storeId, String menu, String userName, double point, String review) {
		//storeId는 null값허용X -> int(값 무조건 전달해라), point는 디폴트값있어서 double괜찮음
		// BO의 규칙임, 여기서 어떻게 값을 받을건지 정해야한다.
		
		return reviewDAO.insertReviewAsField(storeId, menu, userName, point, review); //자동완성 한번 꼭 확인하기
	}

	public int updateReviewById(int id, String review) { //id를 통해 행을 찾아서 review를 업데이트 할것이다.
		return reviewDAO.updateReviewById(id, review);
	}
	
	public int deleteReviewById(int id) {
		return reviewDAO.deleteReviewById(id);
	}
}
