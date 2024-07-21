package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.cmns.Company;
import com.nt.cmns.Company1;

@SpringBootApplication
public class Project04BulkInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=
		SpringApplication.run(Project04BulkInjectionApplication.class, args);
	//	Company1 cmp = ctx.getBean("cmp",Company1.class);
		Company1 cmm = ctx.getBean("cmp",Company1.class);
		System.out.println(cmm);
	}

}
