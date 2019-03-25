package com.c2t.journaldev.spring.service;

import java.util.List;


import org.springframework.web.bind.annotation.ResponseBody;

import com.c2t.annotation.basic.Employee;
import com.c2t.annotation.basic.EmployeeVO;

public interface EmpService {

	public @ResponseBody Employee getDummyEmployee() ;
	
	
	public @ResponseBody Employee getDummyEmployeeFromDB();
	public @ResponseBody List<Employee> getDummyEmployeeLiist() ;
	
	public @ResponseBody EmployeeVO getDummyEmployeeList();
	public @ResponseBody void setDummyEmployee() ;
	public @ResponseBody Employee getemp(int empid);
	public @ResponseBody void deleteEmp(int empid);
}
