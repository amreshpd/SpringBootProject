
package com.nt;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.sbeans.Test1;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j   //lombok api annotation
public class DemoApplication {
	@Bean(name="id")
	public LocalDate createDate() {
	log.debug("from createDate() method");
		return LocalDate.now();
	}
	public static void main(String[] args) {
		log.trace("App is started");
		log.debug("start of main method");
		System.out.println("Spring boot start");
		//create IOC container
		ApplicationContext ctx=
		SpringApplication.run(DemoApplication.class, args);
		//get target spring bean obj
		log.info("ioc container is created");
		Test1 b = ctx.getBean("sf",Test1.class);
		//invoke the b.method
		String season = b.findSeason();
		System.out.println(season);
		((ConfigurableApplicationContext)ctx).close();
		log.info("ioc container ended");
		System.out.println("Spring boot end");
	log.info("end of main method");
	}

}
