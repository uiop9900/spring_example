package com.example.test;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface TestDAO {
	
	public List<Map<String, Object>> selectUser(); //xml의 id를 가져온다
}
