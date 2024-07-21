package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	public Iterable<Doctor> showDoctorBySorting(boolean asc, String... props) {
		//prepare sort object
		Sort sort = Sort.by(asc?Direction.ASC:Direction.DESC,props);
		Iterable<Doctor> it = doctRepo.findAll(sort);
		return it;
	} 
	
	@Override
	public Page<Doctor> showDoctorBySortBypageNo(int pageNo, int pageSize,boolean asc, String props) {
		System.out.println("paging............");
		Sort sort=Sort.by(asc?Direction.ASC:Direction.DESC,props);
		 Pageable page1 = PageRequest.of(pageNo, pageSize, sort);
		Page<Doctor> it1 = doctRepo.findAll(page1);
		return it1;
	}
	@Override
	public void showDataThroughPagination(int pageSize) {
		System.out.println("paging and sorting.............");
		long count=doctRepo.count();
		
		long pagesCounts=(count/pageSize);
		if(count%pagesCounts!=0) {
			pagesCounts++;
		}
	
		for(int i=0;i<pagesCounts;i++) {
		Pageable page = PageRequest.of(i, pageSize);
		Page<Doctor> page1=doctRepo.findAll(page);		
	    System.out.println("Page::"+(page1.getNumber()+1)+" records of : "+page1.getTotalPages());
		page1.getContent().forEach(System.out::println);
		System.out.println("...........................");
		}
		
	}
	
}
