package com.mb.api.business.service;

import java.util.List;
import org.springframework.data.domain.Page;
import com.mb.api.persistance.entity.Employee;

public interface EmployeeService
{
	
	Page<Employee> getAllEmployee(Integer pageNo, Integer pageSize);
	
	List<Employee> getEmployeeSortedByFirstName(String sortBy);
	
}
