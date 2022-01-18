package com.example.lesson02.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.lesson02.model.UsedGoods;

@Repository
public interface UsedGoodsDAO { // xml이랑 연동, 데이터 가져오는 것임
	
	public List<UsedGoods> selectUsedGoodsList(); // interface라 구현체 없음.

}
