package com.ylpms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;


@Configuration
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})//去掉自动装配数据源
public class AppApiApplication extends SpringBootServletInitializer{

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AppApiApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(AppApiApplication.class, args);
	}
}
