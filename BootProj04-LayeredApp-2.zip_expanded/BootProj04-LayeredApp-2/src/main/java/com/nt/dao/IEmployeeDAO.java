package com.nt.dao;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeDAO {
 public List<Employee>getEmployeesByDesgs(Integer mgr1,Integer mgr2,Integer mgr3) throws Exception;
}
