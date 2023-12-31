package com.example.intensiveimmersiontrainingboardproject_cqrs_board_command;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class IntensiveImmersionTrainingBoardProjectCqrsBoardCommandApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntensiveImmersionTrainingBoardProjectCqrsBoardCommandApplication.class, args);
	}

}
