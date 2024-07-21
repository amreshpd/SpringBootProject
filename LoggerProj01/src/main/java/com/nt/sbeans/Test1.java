package com.nt.sbeans;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sf")
public class Test1 {

	private  static Logger logger=LoggerFactory.getLogger(Test1.class);
	@Autowired
	private LocalDate date;
	
	public Test1() {
		System.out.println("Test1 object created");
	}
	
	public String findSeason() {
		logger.debug("start of season finder method");
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		
		int m=date.getMonthValue();
		logger.debug("end of season finder method");
		if(m>=3 && m<=6) {
			return "Summer Season";
		}else if(m>=7 && m<=10) {
			return "rainy season";
			}else {
				return "Winter season";
			}
	}
}
