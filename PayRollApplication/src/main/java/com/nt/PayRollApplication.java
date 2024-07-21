package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.controller.PayController;
import com.nt.model.Employee;

@SpringBootApplication
public class PayRollApplication {

	public static void main(String[] args) throws Exception {
	ApplicationContext ctx=SpringApplication.run(PayRollApplication.class, args);
	PayController controller = ctx.getBean("p",PayController.class);
	
	try {
		List<Employee>list=controller.showEmployeeByDesgs(7902, 7698, 7839);
		list.forEach(emp->{
			System.out.println(emp);
		});
	}catch (Exception e) {
		e.printStackTrace();
	}	
}
}
