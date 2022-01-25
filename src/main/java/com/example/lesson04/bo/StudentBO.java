package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.dao.StudentDAO;
import com.example.lesson04.model.Student;

@Service
public class StudentBO {
	
	@Autowired
	private StudentDAO studentDAO;
	
	public void addStudent(Student student) { // 객체가 통으로 넘어온다.
		studentDAO.insertStudent(student);
	}
	
	//비오의 입장) 나는 뭘 받고, 뭘 건네줄까? 나는 id를 무조건 받아야 겠어
	public Student getStudentById(int id) {
		return studentDAO.selectStudentById(id);
	}
}
