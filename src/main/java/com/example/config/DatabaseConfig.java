package com.example.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@MapperScan(basePackages = "com.example.*")  // 베이스 패키지를 설정하고 이 안에 있는 모든 클래스들을 탐색한다. mapper scan 추가!!!
@Configuration //설정파일이다. 이 어논테이션이 있으면 '설정파일' 이라는 뜻, SpringBootApplication가 찾는다.
public class DatabaseConfig { //데이터베이스의 관한 설정들
	 @Bean // 보라색 아이콘으로 import한다.
	    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception { // bean은 객체, DB와 관련된 빈을 생성한다. - 설정검색 후 사용하는걸로! 외울수없음
	        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
	        sessionFactory.setDataSource(dataSource);

	        Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*Mapper.xml"); // 이 이름 잘보기 : mappers폴더 안에 Mapper.xml에서 SQL찾는다.
	        sessionFactory.setMapperLocations(res);

	        return sessionFactory.getObject();
	    }
	


}
