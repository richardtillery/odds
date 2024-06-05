package com.tillery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@ComponentScan
@EnableAspectJAutoProxy
public class OddsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OddsApplication.class, args);
	}

}
