package com.example;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}) - 이제 DB연동해서 쓸거기때문에 지운다 
//@ComponentScan(basePackages = "com.marobiana") : 처음 설정한 패키지 안의 파일만 탐색한다. - 추가 안해도된다.

@MapperScan(basePackages = "com.example.*")  // 베이스 패키지를 설정하고 이 안에 있는 모든 클래스들을 탐색한다. mapper scan 추가!!!

@SpringBootApplication
public class SpringExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringExampleApplication.class, args);
	}

	 @Bean // 보라색 아이콘으로 import한다.
	    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception { // bean은 객체, DB와 관련된 빈을 생성한다. - 설정검색 후 사용하는걸로! 외울수없음
	        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
	        sessionFactory.setDataSource(dataSource);

	        Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*Mapper.xml"); // 이 이름 잘보기 : mappers폴더 안에 Mapper.xml에서 SQL찾는다.
	        sessionFactory.setMapperLocations(res);

	        return sessionFactory.getObject();
	    }
}
