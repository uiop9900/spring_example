package com.example.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson02.bo.UsedGoodsBO;
import com.example.lesson02.model.UsedGoods;

@RestController
public class UsedGoodsRestController { // 결과값이 json일것이라 rest한다.
	@Autowired
	private UsedGoodsBO usedGoodsBo; // 여기서도 BO에서 값을 받기때문에 BO를 new해서 불러야 한다.
	
	@RequestMapping("/lesson02/ex01")
	public List<UsedGoods> ex01() {
		return usedGoodsBo.getUsedGoodsList();
	}
}
