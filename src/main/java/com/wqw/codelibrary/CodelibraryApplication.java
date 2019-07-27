package com.wqw.codelibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class CodelibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodelibraryApplication.class, args);
	}

}
