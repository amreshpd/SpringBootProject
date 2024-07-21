package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.ICallerTuneInfoService;

@Component("callerTuneRunner")
public class CallerTuneInfoTest implements CommandLineRunner {
	@Autowired
	private ICallerTuneInfoService service;
	@Override
	public void run(String... args) throws Exception {
	/*	try {
		CallerTuneInfo callerObject = new CallerTuneInfo("PUSHPA","SOUTH");
		String callerInfo = service.saveCallerInfo(callerObject);
		System.out.println(callerInfo);
		}catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		try {
		/*	System.out.println(service.updateCallerInfo(1, "ago reel ke banaval","Pushpa"));
			System.out.println("............First time updated.....");
			System.out.println(service.updateCallerInfo(1, "Lollypop Lagelu","Album"));
			System.out.println("............Second time updated.....");
		*/	
			System.out.println("..............................................");
			
			System.out.println(service.showAllDataById(1));
			}catch (Exception e) {
		e.printStackTrace();
		}
		
	}

}
