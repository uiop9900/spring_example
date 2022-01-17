package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("lesson01/ex01")
@RestController // @Controller + ResponseBody: API를 개발할때
//객체를 Spring이 관리하고 객체를 만들어준다.-Spring Bean(객체) 
public class Ex01RestController {
	
	// http://localhost:8080/lesson01/ex01/3
	@RequestMapping("/3")
	public String printString() {
		return "@RestController를 사용해서 String을 리턴해본다.";
	}
	
	// http://localhost:8080/lesson01/ex01/4
	@RequestMapping("/4")
	public Map<String, String> printMap() {
		Map<String, String> map = new HashMap<>();
		map.put("aaa", "bbb");
		map.put("acc", "bdfg");
		map.put("dd", "bgg");
		
		return map;
	}
	
	// http://localhost:8080/lesson01/ex01/5
	@RequestMapping("/5")
	public Data printData() {
		Data data = new Data(); // new를 하는순간 class의 객체가 생성된다(인스턴스)
		// 이건 내가 new한거 라 Spring한테 맡긴거 아님 -> 일반 자바 bean
		data.setId(1);
		data.setName("이지아");
		
		return data; // 일반 bean객체도 JSON으로 내려간다.(서버에서 결과값을 주는 것 = 내려준다)
	}
	
	// http://localhost:8080/lesson01/ex01/6
	@RequestMapping("/6")
	public ResponseEntity<Data> printEntity() { //spring이 지원해주는 클래스
		Data data = new Data();
		data.setId(2);
		data.setName("정윤오");
		
		//return new ResponseEntity<>(data, HttpStatus.OK); // 생성하면서 return함, 상태숫자를 정할수있다.
		return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR); // 에러처리 디테일하게 잡을때 좋음 
		// 수행은 잘됐는데 내가 에러인걸 알때, 상대에게 알려줘야할때, 내가 에러를 정해서 내려준다.
	}
	
}
