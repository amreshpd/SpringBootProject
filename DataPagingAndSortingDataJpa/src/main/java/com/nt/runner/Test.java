package com.nt.runner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IDoctorService;

@Component
public class Test implements CommandLineRunner {
	@Autowired
	private IDoctorService service;
	@Override
	public void run(String... args) throws Exception {
	 // Sorting Object
	System.out.println("Sorting object.....");
	service.showDoctorBySorting(true, "docName").forEach(System.out::println);
	System.out.println("..............................");
	service.showDoctorBySorting(false, "income","docName").forEach(System.out::println);
		/*
		try {
			System.out.println(".........pritntall pageable.......................");
		   //service.showDoctorBySortBypageNo(1, 3, true, "docName").forEach(System.out::println);
			Page<Doctor> page = service.showDoctorBySortBypageNo(0, 1, true, "docName");
			
		System.out.println(page.getNumber());
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		*/
	//Paging and sorting both
	service.showDataThroughPagination(2);

	
	}	
}