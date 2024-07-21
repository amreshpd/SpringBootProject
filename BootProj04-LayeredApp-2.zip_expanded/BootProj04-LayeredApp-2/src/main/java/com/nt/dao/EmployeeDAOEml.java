package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("empDAO")
public class EmployeeDAOEml implements IEmployeeDAO{
	private static final String GET_EMPS_BY_JOBS="select empno,ename,desg,sal,deptno from emp2 where desg in(?,?,?)order by desg";
	@Autowired	
	private DataSource ds;	
		
	@Override
	public List<Employee> getEmployeesByDesgs(Integer mgr1, Integer mgr2, Integer mgr3) {
		System.out.println("EmployeeDAOEml.getEmployeesByDesgs()");
	    List<Employee> list=null;
	    try(Connection con=ds.getConnection();
	    	PreparedStatement ps=con.prepareStatement(GET_EMPS_BY_JOBS)){
	    	
	    	ps.setInt(1, mgr1);
	    	ps.setInt(2, mgr2);
	    	ps.setInt(3, mgr3);
	    	
	    	try(ResultSet eq = ps.executeQuery()){
	    		list=new ArrayList();
	    		while(eq.next()) {
	    			Employee emp=new Employee();
	    			emp.setEno(eq.getInt(1));
	    			emp.setEname(eq.getString(2));
	    			emp.setDesg(eq.getString(3));
	    			emp.setSalary(eq.getDouble(4));
	    			emp.setDeptno(eq.getInt(5));
	    			
	    			list.add(emp);
	    		}//while
	               }//try2 with res
	}//try1 with res
	    catch (Exception e) {
		e.printStackTrace();
		
	}
	    return list;
	}

}
