package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepo;

@Component
public class Test implements CommandLineRunner {
	@Autowired
	private IDoctorRepo repo;  //in memory proxy obj

	@Override
	public void run(String... args) throws Exception {
	System.out.println("FindByName()...");
	List<Doctor> list1 = repo.findBydocName("Amresh");
	System.out.println(list1.toString());
	System.out.println("FindByEqulas().....");
	List<Doctor> list2 = repo.findBydocNameEquals("devika");
	System.out.println(list2.toString());
	System.out.println("FindByIs(-) method......");
	List<Doctor> list3 = repo.findBydocNameIs("sarkar");
	System.out.println(list3.toString());
	System.out.println("getByX(-) method are invoked.....");
	List<Doctor> list4 = repo.getBydocName("sarkar");
	System.out.println(list4.toString());
	System.out.println("readByxx(-) method are invoked...");
	List<Doctor> list5 = repo.readBydocName("sarkar");
	System.out.println(list5.toString());
	//not allowed
//	System.out.println("showByxxx() /fetchByxx() method are invked and checked");
//	List<Doctor> list6 = repo.showBydocName("sarkar");
//	System.out.println(list6.toString());
	System.out.println("Some more method.........");
	List<Doctor> list6 = repo.findBydocNameStartingWith("s");
	System.out.println(list6.toString());
	System.out.println("...............................");
	Iterable<Doctor> list7 = repo.findBydocNameEndingWith("r");
	System.out.println(list7.toString());
	System.out.println("...........................");
	Iterable<Doctor> list8 = repo.findBydocNameContaining("r");
	list8.forEach(System.out::println);
	System.out.println(".....................");
	List<Doctor> list9 = repo.findBydocNameContainingIgnoreCase("S");
	list9.forEach(System.out::println);
	
	System.out.println(".....................");
	List<Doctor> list10 = repo.findBydocNameLike("s%");
	list10.forEach(System.out::println);
	
	}
}
