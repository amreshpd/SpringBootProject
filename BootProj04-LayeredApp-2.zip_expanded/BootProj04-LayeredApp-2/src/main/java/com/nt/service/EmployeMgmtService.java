package com.nt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nt.dao.EmployeeDAOEml;
import com.nt.model.Employee;

@Service("empService")
public class EmployeMgmtService implements IEmployeeMgmtService{

	private EmployeeDAOEml empDAO;
	
	@Override
	public List<Employee> fetchEmpByJobs(Integer mgr1, Integer mgr2, Integer mgr3) throws Exception {
		List<Employee> list=empDAO.getEmployeesByDesgs(mgr1, mgr2, mgr3);
		return list;
	}

}
