package com.Bhealthy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

// @EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "com.Bhealthy")  // com.Bhealthy 패키지 아래에 있는 스프링빈들 탐색
@SpringBootApplication
public class BhealthyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BhealthyApplication.class, args);
	}

}
