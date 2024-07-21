package com.nt.service;

import java.util.List;

import com.nt.entity.Doctor;

public interface IDoctorService {
	//create or insertion object
    public String registerDoctor(Doctor doctor);
    public String registerAllDoctor(List<Doctor> list);
    public long countAllDoctor();
    public boolean checkDoctorAvailabilty(Integer id);
    public Iterable<Doctor> showAllDoctor();
    public Iterable<Doctor> showAllDoctorById(Iterable<Integer> id);
    public Doctor showById(Integer id);
    //fully update object 
    public String updateOrRegisterDoctor(Doctor doctor);
    //partially updation object
    public String updateDoctor(Integer id,String name,String Special,Float rate);
    //delete object
    public String deleteByIdDoctor(Integer id);
    public String deleteByDoctor(Doctor doctor);
    public String removeAllDoctor();
    public String removeAllDoctorById(Iterable<Integer> ids);
    
}
