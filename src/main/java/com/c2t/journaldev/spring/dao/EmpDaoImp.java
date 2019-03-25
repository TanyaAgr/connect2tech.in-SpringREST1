package com.c2t.journaldev.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.c2t.annotation.basic.Employee;
import com.c2t.annotation.basic.EmployeeVO;

@Repository
public class EmpDaoImp implements EmpDao {
	
	
	@Autowired
	SessionFactory sf;
	
	Map<Integer,Employee> empData=new HashMap<Integer,Employee>();
	
	
	public @ResponseBody Employee getDummyEmployee() {
		
		//logger.info("start getDummyEmployee");
		Employee emp=new Employee();
		emp.setId(9999l);
		emp.setFirstname("mannu");
		emp.setLastname("kumar");
		//emp.setBirthDate(Date.parse("02/02/1200"));
		emp.setCellphone("8765432");
		empData.put(9999, emp);
		return emp;
		
	}
	
	
	public @ResponseBody Employee getDummyEmployeeFromDB() {
		
		//logger.info("start getDummyEmployee");
		
		return (Employee)sf.openSession().get(Employee.class, 104l);
		
	}
	
	
	public @ResponseBody List<Employee> getDummyEmployeeLiist() {
		
		//logger.info("start getDummyEmployee");
		Session ses=sf.openSession();
		ses.beginTransaction();
		
		Query q=ses.createQuery("from Employee");
		List<Employee> emp=q.list();
		ses.getTransaction().commit();
		ses.close();
		
		return emp;
	}
	

	
	public @ResponseBody EmployeeVO getDummyEmployeeList() {
		
		//logger.info("start getDummyEmployee");
		Session ses=sf.openSession();
		
		Query q=ses.createQuery("from Employee");
		List<Employee> emp=q.list();
		
		EmployeeVO e1=new EmployeeVO();

	     e1.setEmployees(emp);

		return e1;

	}
	
	public @ResponseBody void setDummyEmployee() {
		
		//logger.info("start getDummyEmployee");
		Session ses=sf.openSession();
		ses.beginTransaction();
		Employee emp=new Employee();
		emp.setId(9999l);
		emp.setFirstname("man");
		emp.setLastname("kish");
		emp.setBirthDate(new java.sql.Date(1996, 06, 23));
		emp.setCellphone("8765432");
		empData.put(9999, emp);
		ses.save(emp);
		ses.getTransaction().commit();
		ses.close();
		
	}
	

	public @ResponseBody Employee getemp(@PathVariable ("id") int empid)
	{
		Session s = sf.openSession();

		Employee emp = (Employee)s.get(Employee.class, new Long(empid));
		System.out.println("----------------------------------");
		System.out.println(emp);
		System.out.println(emp.getId());
		return emp;	
	}

	public @ResponseBody void deleteEmp(@PathVariable ("id") int empid)
	{
		Session s = sf.openSession();
		s.beginTransaction();
		
		Employee emp = (Employee)s.get(Employee.class, new Long(empid));
		s.delete(emp);
		s.getTransaction().commit();
			
	}

}
