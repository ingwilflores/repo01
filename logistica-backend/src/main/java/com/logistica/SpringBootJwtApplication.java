package com.logistica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
//import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication(
//        exclude = {
//                BatchAutoConfiguration.class,
//                JmxAutoConfiguration.class
//        },
//        excludeName = {
//                "org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration",
//        }
//)
@SpringBootApplication
@Configuration
//@ComponentScan(basePackages = {"com.logistica.*"})
//@EnableFeignClients
//@EntityScan(basePackages = "com.logistica.model")
//@EnableJpaRepositories(basePackages = "com.logistica.repo", entityManagerFactoryRef="entityManagerFactory")
//@EnableJpaRepositories(basePackages = "com.logistica.repo")
public class SpringBootJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJwtApplication.class, args);
	}

}
