package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Doctor;


public interface IDoctorRepo extends JpaRepository<Doctor, Integer> {
	// All 3 methods are equal(-)
	public List<Doctor> findBydocName(String docName);
	public List<Doctor> findBydocNameIs(String docName);
	public List<Doctor> findBydocNameEquals(String docName);
	// getBy() and readBy() method
	public List<Doctor> getBydocName(String name);
	public List<Doctor> readBydocName(String name);
	// showByxx() and fetchByxx() method ...note-> both are not supported
//	public List<Doctor> fecthBydocName(String name);
//	public List<Doctor> showBydocName(String name);
	//some more method
	public List<Doctor> findBydocNameStartingWith(String initChars);
	public Iterable<Doctor> findBydocNameEndingWith(String lastChars);
	public Iterable<Doctor> findBydocNameContaining(String chars);
	public List<Doctor> findBydocNameEqualsIgnoreCase(String chars);
	public List<Doctor> findBydocNameContainingIgnoreCase(String chars);
	public List<Doctor> findBydocNameLike(String chars);
}
