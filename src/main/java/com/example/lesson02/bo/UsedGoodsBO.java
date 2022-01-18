package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.dao.UsedGoodsDAO;
import com.example.lesson02.model.UsedGoods;

@Service
public class UsedGoodsBO {
	//제일 상단에서 쓴다. 다른 종류들도 있다.
	@Autowired
	private UsedGoodsDAO usedGoodsDAO; // class명 객체명 , Spring bean이라 우리가 new를 하지않는다. 객체를 가지고와서 Spring에서 new를 맡겨야 한다. 이때 객체를 가져오는데 @Autowired 
	// 여러개의 스프링빈을 가지고 올거면 가지고 올때마다 @ 따로 계속 넣어줘야 한다. 객체마다 위에 있어야 한다.
	
	
	public List<UsedGoods> getUsedGoodsList() { // 관례적으로 get으로 하고 , 가져오는 class와 type써준다.
		return usedGoodsDAO.selectUsedGoodsList(); // 얘가 spring bean이 아니면 null값이라고 오류뜬다.
	}
}
