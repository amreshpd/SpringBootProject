package com.nt.service;

import java.util.List;

import com.nt.entity.Doctor;

public interface IDoctorService {
	public String deleteDoctorByIdInBatch(List<Integer> ids);
    public List<Doctor> showDoctorsByExampleData(Doctor exDoctor,boolean ascOrder,String ...props);
    public Doctor getDetailsRefrenceById(Integer id); 
}
