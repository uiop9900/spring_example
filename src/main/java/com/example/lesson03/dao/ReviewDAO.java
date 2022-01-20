package com.example.lesson03.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.model.Review;

@Repository
public interface ReviewDAO {
	
	public Review selectReview(@Param("id") int id); //id값을 id의 이름으로 넘기는걸 어노테이션 
	
	public int insertReview(Review review);//하나라서 @Param안해도 된다. 2개이상이면 @Param해줘야 한다. 하지만 여기서는 잘 없음
	//int는 몇개의 행이 insert되었는지 알려주고 해주는건 myBatis가 해주는 기능이다.
}
