package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.service.IProductOrder;


@SpringBootApplication
public class MailApiExample01Application {

	public static void main(String[] args) {
		//get application context container
		ApplicationContext ctx=
		SpringApplication.run(MailApiExample01Application.class, args);
	//get service class object
	IProductOrder service=ctx.getBean("purchaseOrder",IProductOrder.class);
	//invoke the b.method
	try {
		String resultMsg=service.shopping(new String[] {"trouser","shirt","pant"},new float[] {2000.0f,3000.0f,4000.0f},new String[] {"amreshpd12@gmail.com","amreshpd23@gmail.com"});
	System.out.println(resultMsg);
	
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	
	}

}
