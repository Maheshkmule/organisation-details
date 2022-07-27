package com.springbootapimysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootapimysql.entity.Employee;
import com.springbootapimysql.service.EmployeeService;
@RestController
@RequestMapping
public class EmployeeController {
	@Autowired
    private EmployeeService service;

   
	 @PostMapping("/employee")
	    public Employee addEmployee(@RequestBody Employee employee){
	        return service.addEmployee(employee);
	    }

	  @GetMapping("/employees/{field}")
	    public List<Employee> getEmployees(@PathVariable String field){
	        return service.getEmployees(field);
	    }
	  
    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee) {
    	return service.updateEmployee(employee);
    }  
    @GetMapping("/setSalary/{id}/{salary}")
    public Employee updateEmployeeWithPathVariable(@PathVariable Integer id,@PathVariable Integer salary) {
    	return service.updateEmployeeWithPathVariable(id, salary);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return service.deleteEmployee(id);
    }
}
