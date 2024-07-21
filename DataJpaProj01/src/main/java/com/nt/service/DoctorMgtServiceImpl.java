package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepo;

@Service("Dct")
public class DoctorMgtServiceImpl implements IDoctorService {
	
	@Autowired
	public IDoctorRepo doctRepo;
	
	@Override
	public String registerDoctor(Doctor doctor) {
		System.out.println("Save Method Object are created");
		System.out.println("doc id before save:: "+doctor.getDocId());
		Doctor doc=doctRepo.save(doctor);
		return "Doctor Obj after Save::"+doc.getDocId()+"...."+doc.toString();
	}
	
	@Override
	public String registerAllDoctor(List<Doctor> list) {
		System.out.println("Save ALL OBJECT are created");
		Iterable<Doctor> list1 = doctRepo.saveAll(list);
		return list1.toString()+" Doctor are saved";
	}

	@Override
	public long countAllDoctor() {
		System.out.println("Count Method Object Are created...");
		long count = doctRepo.count();
		return count;
	}
   
	@Override
	public boolean checkDoctorAvailabilty(Integer id) {
		System.out.println("ExistById method are invoked......");
		boolean exist = doctRepo.existsById(id);
		return exist;
	}
	
	@Override
	public Iterable<Doctor> showAllDoctor() {
		System.out.println("findAll() method are invoked......");
		return doctRepo.findAll();
	}
	
	@Override
	public Iterable<Doctor> showAllDoctorById(Iterable<Integer> id) {
		System.out.println("findAllById() method are invoked.....");
		Iterable<Doctor> all = doctRepo.findAllById(id);
		return all;
	}

	@Override
	public Doctor showById(Integer id) {
		System.out.println("Optional Object is invoked......");
		Doctor doctor=new Doctor();
		doctor.setSpecialization("Child");
		Doctor d = doctRepo.findById(id).orElse(doctor);
		return d;
	}
	/*
	@Override
	public Doctor showById(Integer id) {
		Doctor doctor = doctRepo.findById(id).orElseThrow(()->new IllegalArgumentException());
		return doctor;
	}
	*/
	
	//fully update
	@Override
	public String updateOrRegisterDoctor(Doctor doctor) {
		//load doctor object
		System.out.println("Fully Update object");
		Optional<Doctor> did = doctRepo.findById(doctor.getDocId());
		if(did.isPresent()) {
			doctRepo.save(doctor);   //for update object
			return doctor.getDocId()+" Doctor details are updated and found";
		}else {
			return "Doctor is saved with id value "+doctRepo.save(doctor).getDocId(); 
		}
	}
	//partially updated
	@Override
	public String updateDoctor(Integer id, String name, String Special, Float rate) {
		Optional<Doctor> find = doctRepo.findById(id);
		System.out.println("Partially object updated");
		if(find.isPresent()) {
			Doctor doct=find.get();
			doct.setDocId(id); doct.setDocName(name); doct.setSpecialization(Special);
			doct.setIncome(rate);
			doctRepo.save(doct);
			return "Doctor id "+find+" is found and updated";
		
		}else
		return "Doctor object is not found";
	}
	
	//Delete Object
	@Override
	public String deleteByIdDoctor(Integer id) {
		System.out.println("Delete Object by id...................");
		Optional<Doctor> find = doctRepo.findById(id);
		if(find.isPresent()) {
			doctRepo.deleteById(id);
			return "Delete Object By id: "+find;
		}else
			return find+" id is not found";
	}
	@Override
	public String deleteByDoctor(Doctor doctor) {
		System.out.println("Delete by doctor..................");
		Optional<Doctor> did = doctRepo.findById(doctor.getDocId());
		if(did.isEmpty()) {
			return doctor.getDocId()+" is not found";
		}else
			doctRepo.delete(did.get());		
		return "doctor id is found and deleted";
	}
	@Override
	public String removeAllDoctor() {
		long count=doctRepo.count();
		if(count>0) {
			doctRepo.deleteAll();
			return count+"Records are deleted";
		}else
		return "no records are deleted";
	}
	
	@Override
	public String removeAllDoctorById(Iterable<Integer> ids) {
		List<Doctor> list= (List<Doctor>)doctRepo.findAllById(ids);
		doctRepo.deleteAllById(ids);
	   return list.size()+" no. of records deleted";
	}
	
	
	
}
