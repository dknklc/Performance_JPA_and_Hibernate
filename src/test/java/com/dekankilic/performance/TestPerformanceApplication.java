package com.dekankilic.performance;

import org.springframework.boot.SpringApplication;

public class TestPerformanceApplication {

	public static void main(String[] args) {
		SpringApplication.from(PerformanceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
