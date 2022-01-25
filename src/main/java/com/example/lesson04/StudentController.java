package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson04.model.Student;

@Controller
public class StudentController {
	//코드가 잘못되지않았는데 무언가 서버가 안켜질때 : project - clean : 새롭게 빌드가 된다.
	
	@Autowired
	private StudentBO studentBO;
	
	//http://localhost:8080/lesson04/ex02/1 -> 학생 추가 화면
	@GetMapping("/lesson04/ex02/1")
	public String ex02_1() {
		return "lesson04/addStudent";
	}
	
	@PostMapping("/lesson04/ex02/add_student")
	public String addStudent( //내가 입력하자마자 바로 그 값을 돌려받는다.
			@ModelAttribute Student student, //name 속성의 이름과 일치하는 필드에 값이 들어간다.
			Model model
			) {
		
		// db insert
		studentBO.addStudent(student);
		// System.out.println("################id: " + student.getId());

		// db select 넣은 값을 꺼낸다. - 위에것을 바로 뽑아내는 것보다는 db에서 가지고 오는게 더 정확하기때문에 아예 새롭게 select를 하는게 관례적이다.
		Student result = studentBO.getStudentById(student.getId()); //여기에 id를 보냈다.
		model.addAttribute("result", result);
		model.addAttribute("subject", "학생 정보");
		
		return "lesson04/afterAddStudent"; // 추가된 학생정보의 jsp
	}
	
}
