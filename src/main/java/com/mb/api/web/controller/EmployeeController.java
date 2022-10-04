package com.mb.api.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mb.api.business.service.EmployeeService;
import com.mb.api.persistance.entity.Employee;

/*
 * Reference : https://howtodoinjava.com/spring-boot2/pagination-sorting-example/
 * 
 * */

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController
{

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public ResponseEntity<Page<Employee>> getAllEmployee(@RequestParam(required = false, defaultValue = "0", name = "pageNo") Integer pageNo, @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize)
	{
		Page<Employee> result = employeeService.getAllEmployee(pageSize, pageSize);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	
	@GetMapping("/filter")
	public ResponseEntity<List<Employee>> getEmployeeSortedByFirstName(@RequestParam(name = "sortBy", required = false, defaultValue = "id") String sortBy) {
		return new ResponseEntity<> (employeeService.getEmployeeSortedByFirstName(sortBy), HttpStatus.OK);
	}

} 
