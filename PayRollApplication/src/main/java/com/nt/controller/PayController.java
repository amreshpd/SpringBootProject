package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller("p")
public class PayController {
	
	 @Autowired
	  private IEmployeeMgmtService service;
		
	  public List<Employee> showEmployeeByDesgs(Integer mgr1, Integer mgr2, Integer mgr3) throws Exception{
		  System.out.println("PayrolOperationController.showEmployeeByDesgs()");
	      List<Employee>list=service.fetchEmpByJobs(mgr1, mgr2, mgr3);
	     
	      return list;
	  }

}
