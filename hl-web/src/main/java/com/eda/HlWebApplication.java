package com.eda;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.eda.dao")
public class HlWebApplication  extends SpringBootServletInitializer  {

	
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder
	  builder){ return builder.sources(HlWebApplication.class); }
	 
	
	public static void main(String[] args) {
		SpringApplication.run(HlWebApplication.class, args);
	}

}
