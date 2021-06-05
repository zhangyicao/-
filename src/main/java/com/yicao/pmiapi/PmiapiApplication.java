package com.yicao.pmiapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement//开启事务管理
@MapperScan("com.yicao.pmiapi.mapper")
public class PmiapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PmiapiApplication.class, args);
	}

}
