package com.Management.feeTraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class FeeTrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeeTrainingApplication.class, args);
	}

}
