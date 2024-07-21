package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.service.DoctorMgtServiceImpl;

@Component
public class Test implements CommandLineRunner {
	@Autowired
	private DoctorMgtServiceImpl service;

	@Override
	public void run(String... args) throws Exception {
	/*	System.out.println(service.deleteDoctorByIdInBatch(List.of(2304,2352)));
		//Null value are not used
		//System.out.println(service.deleteDoctorByIdInBatch(List.of(2304,null)));
		//here null are allowed
	     System.out.println(service.deleteDoctorByIdInBatch(Arrays.asList(2304,null)));
	     */
	System.out.println("..........Example Object create and findAll(-) method implemention");
	Doctor doctor=new Doctor();
	
	doctor.setIncome(90000.0);
	doctor.setSpecialization("Cardio");
	
	
	service.showDoctorsByExampleData(doctor, true, "income").forEach(System.out::println);
	System.out.println("GetRefrenceById(-) method is invoked");
	Doctor d = service.getDetailsRefrenceById(1001);
	System.out.println(d);
	}
}
