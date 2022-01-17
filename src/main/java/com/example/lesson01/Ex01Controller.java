package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Ex01Controller {

	// String 출력하기
	//http://localhost:8080/lesson01/ex01/1 - path를 만드는 것은 개발자 마음대로!
	//누군가가 request가 날리면 controller가 mapping을 뒤져서 같은 mapping찾아서 호출된다.
	
	@ResponseBody // return되는 값을 Response로 보낸다.(내가 return되는게 responseBody에 들어간다.) - annotation의 순서는 상관없음
	@RequestMapping("/lesson01/ex01/1") // 주소 매핑
	public String printString() {
		String text = "<h1>예제1번</h1> 문자열을 response body로 보내는 예제";
		return text;
	}
	
	
	// Map 리턴하기 => JSON 리턴하기
	// http://localhost:8080/lesson01/ex01/2
	@RequestMapping("/lesson01/ex01/2") // 메소드위에 있어야 한다.
	public @ResponseBody Map<String, Object> printMap() { //  @ResponseBody가 return되는 거기때문에 여기서 선언해줘도 된다. - 회사가서 따라하기
		Map<String, Object> map = new HashMap<>();
		map.put("apple", 4);
		map.put("banana", 10);
		map.put("orange", 125);
		map.put("grape", 167); // map은 =인데 json:
		
		// Map을 리턴하면 JSON으로 나타난다.
		// Web starter에 Jackson 라이브러리가 포함되어 있기 때문 
		return map;
	}
	
	
}
