package com.nit;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.PayController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootProj04LayeredApp2Application {

	public static void main(String[] args) {
		ApplicationContext ctx=
		SpringApplication.run(BootProj04LayeredApp2Application.class, args);
		PayController cont =
				ctx.getBean("p", PayController.class);
		
		System.out.println("hiii");
		try {
			List<Employee>list=cont.showEmployeeByDesgs(7902, 7698, 7839);
			list.forEach(emp->{
				System.out.println(emp);
			});
		}catch (Exception e) {
e.printStackTrace();
System.out.println("BootProj04LayeredApp2Application.main()");

		}
		((ConfigurableApplicationContext)ctx).close();
	}

}
