package com.nt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.entity.Doctor;


public interface IDoctorRepo extends PagingAndSortingRepository<Doctor, Integer>,CrudRepository<Doctor, Integer> {

}
