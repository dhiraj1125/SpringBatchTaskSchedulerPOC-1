package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author NISUM
 *
 */
@EnableScheduling
@SpringBootApplication
public class SpringBatchTaskSchedulerPoc1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchTaskSchedulerPoc1Application.class, args);
	}
}
