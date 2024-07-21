package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nit.html.Hotel;

@SpringBootApplication
public class Project05BulkInjection2Application {

	public static void main(String[] args) {
		ApplicationContext ctx=
		SpringApplication.run(Project05BulkInjection2Application.class, args);
		Hotel hot = ctx.getBean("htm",Hotel.class);
		System.out.println(hot);
	}

}
