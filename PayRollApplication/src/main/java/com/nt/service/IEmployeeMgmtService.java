package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeMgmtService {
	
	public List<Employee>fetchEmpByJobs(Integer mgr1,Integer mgr2,Integer mgr3)throws Exception;

	
}

