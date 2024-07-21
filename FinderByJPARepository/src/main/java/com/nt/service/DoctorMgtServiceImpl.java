package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepo;

@Service("Dct")
public class DoctorMgtServiceImpl implements IDoctorService {
	
	@Autowired
	public IDoctorRepo doctRepo;
	
	@Override
	public String deleteDoctorByIdInBatch(List<Integer> ids) {
		//load the entities
		System.out.println("List object and deleteAllByIdInBatch");
		List<Doctor> list = doctRepo.findAllById(ids);
		doctRepo.deleteAllByIdInBatch(ids);
		return list.size()+" rows are deleted";
	}

	@Override
	public List<Doctor> showDoctorsByExampleData(Doctor exDoctor, boolean ascOrder, String... props) {
	//	Sort sort = Sort.by(ascOrder?Direction.ASC:Direction.DESC,props);
		Sort sort = Sort.by(ascOrder?Direction.ASC:Direction.DESC,props);
		Example<Doctor> example = Example.of(exDoctor);
		List<Doctor> list = doctRepo.findAll(example,sort);
		return list;
	}
	
	@Override
	public Doctor getDetailsRefrenceById(Integer id) {
		Doctor doctor = doctRepo.getReferenceById(id);
		return doctor;
	}
	
}
