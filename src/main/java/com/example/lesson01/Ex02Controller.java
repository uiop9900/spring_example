package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller		//@RestController가 아님 주의!! view(뷰)는 ResponseBody가 없다.
public class Ex02Controller {// view는 무조건 그냥 Controller임
	// 데이터를 내려줄때는 ResponseBody에 JSON을 내려주는 건데
	// 지금은 태그 자체가 응답값이라 Controller이다.
	// 즉, view로 할때는 Controller!!!!
	
	@RequestMapping("/lesson01/ex02/1") 
	public String view() {// 뷰는 항상 String으로 반환, 그냥 String과 뷰는 어떻게 구분? ResponseBody가 있으면 진짜 String이고, 없으면 뷰다!(경로구나!)
		// @ResponseBody가 아닌 상태로 String을 리턴하면  
		// ViewResolver에 의해 리턴된 String의 경로에 해당하는 view를 찾고 view화면이 구성된다.
		
		// 이미 prefix, suffix가 설정을 다 해놨기때문에 사이의 것만 넣어준다.  (/WEB-INF/jsp/         .jsp)
		return "lesson01/ex02"; //경로값
	}
}
