package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}) - 이제 DB연동해서 쓸거기때문에 지운다 
//@ComponentScan(basePackages = "com.marobiana") : 처음 설정한 패키지 안의 파일만 탐색한다. - 추가 안해도된다.

@SpringBootApplication
public class SpringExampleApplication { //설정값들이 너무 많으면 무겁고 알아보기 힘드니 영역마다 분리해서 정리한다.

	public static void main(String[] args) {
		SpringApplication.run(SpringExampleApplication.class, args);
	}

}
