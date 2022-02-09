package com.example.lesson06;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.UserBO;

@Controller
public class Lesson06Ex02Controller {
	//data베이스를 연동해야 알 수 있기때문에 단순히 수식이 아니라 ajax를 이용했다.
	
	@Autowired
	private UserBO userBO;
	
	//http://localhost:8080/add_name_view
	@RequestMapping("/add_name_view")
	public String addNameView() {
		return "lesson06/addName";
	}
	
	@ResponseBody
	@RequestMapping("/is_duplication") //ajax에 대한 리턴이라 뷰로 바로 가는게 아님
	public Map<String, Boolean> isDuplication(
			@RequestParam("name") String name) {
		
		// 중복 확인 DB 
		boolean existUser = userBO.existUserByName(name);
		
		// Map 구성 후 리턴
		Map<String, Boolean> result = new HashMap<>();
		result.put("is_duplication", existUser); // 중복이면 true다.
		
		return result;
	}
	
	
}
