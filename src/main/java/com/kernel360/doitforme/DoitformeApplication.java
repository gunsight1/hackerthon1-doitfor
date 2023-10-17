package com.kernel360.doitforme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DoitformeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoitformeApplication.class, args);
	}

}
