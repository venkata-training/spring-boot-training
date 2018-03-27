package org.mycompany.test.start_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SpringBootDemoApplication {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

}
