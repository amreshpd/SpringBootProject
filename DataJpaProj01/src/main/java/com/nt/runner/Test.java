package com.nt.runner;

import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.service.DoctorMgtServiceImpl;

@Component
public class Test implements CommandLineRunner {
	@Autowired
	private DoctorMgtServiceImpl dms;
	@Override
	public void run(String... args) throws Exception {
		Doctor doctor1=new Doctor(101,"Amresh","Bones",47856.12f);
		Doctor doctor2=new Doctor(102,"Devika","Breast",78457.12f);
//		doctor.setDocId(101);
//       doctor.setDocName("Amresh");
//       doctor.setSpecialization("Bones");
//       doctor.setIncome(456123.5f);
       try {
    	   //save method
       System.out.println(".............Save Method..............");
      
       String result=dms.registerDoctor(new Doctor(1000, "Sarkar", "Chest", 78457.45f));
       System.out.println(result);
       
       
       System.out.println("---------------SaveAll Method-------------------");
    	   //saveAll Method
    	   List<Doctor> list = List.of(doctor1,doctor2);   //java 9 features
    	   String saveall = dms.registerAllDoctor(list);  
	       System.out.println(saveall);
	       
	       //Count()
	       System.out.println("................Count Method ............");
	       long total = dms.countAllDoctor();
	       System.out.println(total);
	       
	       //ExixtById
	       System.out.println("................ExistById Method..........");
	       boolean chk = dms.checkDoctorAvailabilty(1202);
	       System.out.println("Doctor are  available? :"+chk);
	       
	       //FindAll Method
	       System.out.println(" .................Find All Method......");
	       Iterable<Doctor> show = dms.showAllDoctor();
	       show.forEach(doc->{
	    	   System.out.println(doc);
	       });
	       System.out.println("======================");
	       show.forEach(doc->System.out.println(doc));
	       System.out.println("............................");
	       show.forEach(System.out::println);
	       System.out.println("...........................");
	       ((List<Doctor>)show).stream().forEach(System.out::println);
	       
	       //findAllById()
	       System.out.println("Find all By Id object are call here............");
	       dms.showAllDoctorById(List.of(1,2,102)).forEach(System.out::println);
	       
	       //optional FindByID
	       System.out.println("optional class.............");
	       Doctor sh = dms.showById(1021);
	       System.out.println(sh);
       }catch (Exception e) {
    	   e.printStackTrace();
	}
	//update fully
       try {
    	   System.out.println("..........UpdateFully.................");
    	   Doctor doc =new Doctor();
    	   doc.setDocId(1111); doc.setDocName("Kajal"); doc.setIncome(14578.2f);
    	   doc.setSpecialization("Lung Cancer");
    	   String updateFull = dms.updateOrRegisterDoctor(doc);
    	   System.out.println(updateFull);
       }catch (Exception e) {
    	   e.printStackTrace();
	}
      //partial update
       try {
    	   System.out.println("Partially update...............");
    	   String status = dms.updateDoctor(953, "Alok", "Eye", 1452.2f);
    	   System.out.println(status);
       }catch (Exception e) {
		e.printStackTrace();
	}
       /*
      //DeleteById
       try {
    	   System.out.println("...........Delete object...........");
    	System.out.println(dms.deleteByIdDoctor(2254));   
       }catch (Exception e) {
		e.printStackTrace();
	}
      //Delete By Entity
       try {
    	   System.out.println("Delete By Entity..............");
    	   Doctor doctor=new Doctor();
    	   doctor.setDocId(1); doctor.setDocName("sarkar");
    	   System.out.println(dms.deleteByDoctor(doctor));
    	   
    	   
       }catch (Exception e) {
		e.printStackTrace();
	}
     
  try {
    	 System.out.println("Delete all object are created....");
    	 String remove = dms.removeAllDoctor();
       System.out.println(remove);
       }catch (Exception e) {
		e.printStackTrace();
	}
   
       try {
    	   System.out.println(dms.removeAllDoctorById(List.of(10,20)));
    	   
       }catch (Exception e) {
		e.printStackTrace();
	}
        */
       
       
       
       
	}

}
