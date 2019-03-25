package com.journaldev.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.c2t.annotation.basic.Employee;
import com.c2t.annotation.basic.EmployeeVO;
import com.c2t.journaldev.spring.service.EmpService;


//import com.journaldev.spring.model.Employee;


@Controller
public class EmpController {
	
	@Autowired
	EmpService service;
	
	@RequestMapping(value="/rest/emp/dummy", method = RequestMethod.GET)
	public @ResponseBody Employee getDummyEmployee() {
		
		return service.getDummyEmployee();
		
	}
	
	@RequestMapping(value="/rest/emp/dummy1", method = RequestMethod.GET)
	public @ResponseBody Employee getDummyEmployeeFromDB() {
	
		return service.getDummyEmployeeFromDB();
		
	}
	
	@RequestMapping(value="/rest/emp/dummy2", method = RequestMethod.GET)
	public @ResponseBody List<Employee> getDummyEmployeeLiist() {
		
		return service.getDummyEmployeeLiist();
	}
	

	@RequestMapping(value="/rest/emp/list", method = RequestMethod.GET)
	public @ResponseBody EmployeeVO getDummyEmployeeList() {
		
		return service.getDummyEmployeeList();

	}
	
	@RequestMapping(value="/rest/emp/dummy3", method = RequestMethod.GET)
	public @ResponseBody void setDummyEmployee() {
		
		service.setDummyEmployee();
		
	}
	
	@RequestMapping(value="/rest/emp/{id}",method = RequestMethod.GET)
	public @ResponseBody Employee getemp(@PathVariable ("id") int empid)
	{
		return service.getemp(empid);
	}

	@RequestMapping(value="/rest/emp/delete/{id}",method = RequestMethod.GET)
	public @ResponseBody void deleteEmp(@PathVariable ("id") int empid)
	{
		service.deleteEmp(empid);
			
	}
	
}
