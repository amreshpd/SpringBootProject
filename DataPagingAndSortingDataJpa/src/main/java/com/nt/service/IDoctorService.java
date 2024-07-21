package com.nt.service;

import org.springframework.data.domain.Page;

import com.nt.entity.Doctor;

public interface IDoctorService {
	//create or insertion object
      public Iterable<Doctor> showDoctorBySorting(boolean asc,String ...props);
      public Page<Doctor> showDoctorBySortBypageNo(int pageNo,int pageSize,boolean ascOrder,String props);
      public void showDataThroughPagination(int pageSize);

}
