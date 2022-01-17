package com.example.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	
	@RequestMapping("/test1") //test1로 들어오면 여기로 들어온다.
	public @ResponseBody String test1() {
		return "hello world!!!";
	}
	
}


