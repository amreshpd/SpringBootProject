package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.ViewHotelInfo;
import com.nt.model.HotelBean;

@SpringBootApplication
public class Project03MiniProjectHotelInformationApplication {

	public static void main(String[] args) {
		
		/*SpringApplication application = new SpringApplication(Project03MiniProjectHotelInformationApplication.class);
		application.setAdditionalProfiles("dev");
		ApplicationContext ctx = application.run(args);
		*/
		ApplicationContext ctx=
		SpringApplication.run(Project03MiniProjectHotelInformationApplication.class, args);
		
	  ViewHotelInfo hf = ctx.getBean("view",ViewHotelInfo.class);
	try {
		System.out.println(ctx.getClass());
		System.out.println(ctx.getClassLoader());
		
		List<HotelBean> list=hf.viewInfo("Hyderabad", "Pune", "Delhi");
		list.forEach(hotel->{
		System.out.println(hotel);
		});
	}catch (Exception e) {
		System.err.println(e.getMessage());
	}	
	}

}
