package com.springbootapimysql.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootapimysql.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

	


	
}
