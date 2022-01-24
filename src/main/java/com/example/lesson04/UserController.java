package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;
import com.example.lesson04.model.User;

@Controller
@RequestMapping("/lesson04/ex01")
public class UserController {
	
	@Autowired
	private UserBO userBO;
	
	//http://localhost:8080/lesson04/ex01/add_user_view
	@RequestMapping(path = "/add_user_view", method = RequestMethod.GET) // method를 설정하려면 이렇게 해줘야 한다. (url치려면 get)  -> GetMapping으로 해도 된다.
	public String addUserView() { // @ResponseBody 없으면 view의 경로를 리턴한다.
		return "lesson04/addUser";	//Application에서 파일명 앞뒤를 선언해줬기에 중앙의 경로만 넣는다. /WEB-INF/jsp/lesson04/addUser.jsp
	}
	
	//http://localhost:8080/lesson04/ex01/add_user  - post이기때문에 바로 url에 들어올수없음. form태그로만 들어와야 한다-> test할때 어려움 -> postman 확장자 사용
	@PostMapping("/add_user") // RequestMapping은 모든 속성을 받고 따로 속성걸려면 위와 같이 설정해야하는데, postMapping은 post만
	public String addUser( // @ResponBody없음-> 경로값
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			@RequestParam(value="introduce", required=false) String introduce //얘는 null값 허용 
			) { // 여기서 값들이 잘 넘어왔는지 return에 포인트 넣고 디버깅해본다. -> 값이 잘 들어가있으면 이제 다음단계로 넘어간다. 
		//뷰에서 넘어온 값들을 받아서 insert해야한다.
		//쿼리파라미터 받는다 
			
		// DB insert한다.
		userBO.addUser(name, yyyymmdd, email, introduce);
		
		return "lesson04/afterAddUser"; // 결과 view화면 
	}
	
	//http://localhost:8080/lesson04/ex01/get_last_user- 이 주소를 치면 가장 마지막에 추가된 사람 한명 정보 가져오기 -> select해야한다.
	@GetMapping("/get_last_user") // 여기서의 model은 우리가 만든 model패키지가 아니라 여기에 값을 담아서 jsp에 운반해주는 매개체이다.
	public String getLastUser(Model model) { //jsp로 보내서 뷰화면에 표를 해보기, model은 스프링 프레임워크가 만들어준 객체
		User lastUser = userBO.getLastUser();
		// model을 통해 그러면 뷰에 우리가 담은 lastUser을 보낼 수있음.
		model.addAttribute("result", lastUser); // 키와 값으로 보낼거다 -> result이름으로 값을 꺼낼수있음.
		model.addAttribute("subject", "회원 정보"); //이렇게 임의의 값을 원하는대로 넣는것도 가능하다.
		
		return "lesson04/getLastUser"; //경로값
	}
		
	
}
