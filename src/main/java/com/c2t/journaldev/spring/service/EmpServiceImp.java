package com.c2t.journaldev.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.c2t.annotation.basic.Employee;
import com.c2t.annotation.basic.EmployeeVO;
import com.c2t.journaldev.spring.dao.EmpDao;

@Service
public class EmpServiceImp implements EmpService {

	@Autowired
	EmpDao empDao;
	
	
	public @ResponseBody Employee getDummyEmployee() {
		
		return empDao.getDummyEmployee();
		
	}
	
	public @ResponseBody Employee getDummyEmployeeFromDB() {
	
		return empDao.getDummyEmployeeFromDB();
		
	}
	
	public @ResponseBody List<Employee> getDummyEmployeeLiist() {
		
		return empDao.getDummyEmployeeLiist();
	}
	
	public @ResponseBody EmployeeVO getDummyEmployeeList() {
		
		return empDao.getDummyEmployeeList();

	}
	
	public @ResponseBody void setDummyEmployee() {
		
		empDao.setDummyEmployee();
		
	}
	
	public @ResponseBody Employee getemp(@PathVariable ("id") int empid)
	{
		return empDao.getemp(empid);
	}

	public @ResponseBody void deleteEmp(@PathVariable ("id") int empid)
	{
		empDao.deleteEmp(empid);
			
	}
	
	
}
