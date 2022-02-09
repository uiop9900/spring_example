package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.dao.UserDAO;
import com.example.lesson04.model.User;

@Service
public class UserBO {
	@Autowired
	private UserDAO userDAO;
	
	public void addUser(String name, String yyyymmdd, String email, String introduce) {
		userDAO.insertUser(name, yyyymmdd, email, introduce); // 순서 잘봐야 한다. 입력순서와 넘기는 순서 동일해야한다.
	}
	
	//한 행을 전체로 가지고 올건데 map으로 가져오는 것보다 아예 class를 만들어서 가지고 오는게 좋다.
	public User getLastUser() { //마지막 하나 가져오는거라 파라미터 필요없음
		return userDAO.selectLastUser();
	}
	
	public boolean existUserByName(String name) {
		return userDAO.existUserByName(name);
	}
	
	
}
