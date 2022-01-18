package com.example.test;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@Autowired
	private TestDAO testDAO; // testDAO객체의 메소드를 가져온다
	
	@RequestMapping("/test1") //test1로 들어오면 여기로 들어온다.
	public @ResponseBody String test1() {
		return "hello world!!!";
	}
	
	@ResponseBody
	@RequestMapping("/db_test")
	public List<Map<String, Object>> dbTest() {
		return testDAO.selectUser();
	}
	
}


