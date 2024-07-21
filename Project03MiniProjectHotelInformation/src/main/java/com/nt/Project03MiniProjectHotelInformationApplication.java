package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.controller.ViewHotelInfo;
import com.nt.model.HotelBean;

@SpringBootApplication
public class Project03MiniProjectHotelInformationApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=
		SpringApplication.run(Project03MiniProjectHotelInformationApplication.class, args);
	  ViewHotelInfo hf = ctx.getBean("view",ViewHotelInfo.class);
	try {
		List<HotelBean> list=hf.viewInfo("Hyderabad", "Pune", "Delhi");
		list.forEach(hotel->{
		System.out.println(hotel);
		});
	}catch (Exception e) {
		System.err.println(e.getMessage());
	}
	
	}

}
