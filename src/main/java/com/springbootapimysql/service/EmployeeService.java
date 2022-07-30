package com.springbootapimysql.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springbootapimysql.entity.Employee;
import com.springbootapimysql.exception.EmployeeAlreadyExistsException;
import com.springbootapimysql.repository.EmployeeRepository;
@Service
public class EmployeeService {
	 @Autowired
	    private EmployeeRepository repository;

//	 public Employee addEmployee(Employee employee){
//	       return repository.save(employee);
//	    }
	    public Employee addEmployee(Employee employee)
	    {
		 Employee existingEmployee= repository.findById(employee.getId())
	                  .orElse(null);
	        if (existingEmployee == null) {
	        return	repository.save(employee); 
	        }
	        else
	            throw new EmployeeAlreadyExistsException(
	                "Employee already exists in the database!!");
	    }

	    public List<Employee> getEmployees(String field){
	    	
	    	List<Employee> list=repository.findAll();
	    	list.sort(new Comparator<Employee>(){
	    		public int compare(Employee o1,Employee o2) {
	    			if(o2.getSalary()==o1.getSalary()) {
	    				return o1.getName().compareTo(o2.getName());
	    			}
	    			return (int) (o2.getSalary()-o1.getSalary());
	    		}
	    	});
	    	return list;
	    	
	    }
   
	    
		
		public Employee updateEmployee(Employee employee) {
			Employee existingEmployee = repository.findById(employee.getId()).orElse(null);
	        existingEmployee.setName(employee.getName());
	        existingEmployee.setSalary(employee.getSalary());
	        existingEmployee.setDesignation(employee.getDesignation());
	        return repository.save(existingEmployee);
		}
		
		
		public String deleteEmployee(int id) {
	        repository.deleteById(id);
	        return "Employee removed !! " + id;
	    }

		public Employee updateEmployeeWithPathVariable(Integer id, Integer salary) {
			Employee employee=repository.findById(id).get();
			employee.setSalary(salary);
			repository.save(employee);
			return repository.findById(id).get();
		}

		
		
}
