package com.yida;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.yida.mapper")
public class HladminApplication extends SpringBootServletInitializer{

    protected SpringApplicationBuilder configure(SpringApplicationBuilder
                                                         builder){ return builder.sources(HladminApplication.class); }

    public static void main(String[] args) {
        SpringApplication.run(HladminApplication.class, args);
    }

}
