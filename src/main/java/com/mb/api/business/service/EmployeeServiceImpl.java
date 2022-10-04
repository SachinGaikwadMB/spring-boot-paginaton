package com.mb.api.business.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.mb.api.persistance.entity.Employee;
import com.mb.api.persistance.repository.EmployeeRepository;

@Service

public class EmployeeServiceImpl implements EmployeeService
{
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Page<Employee> getAllEmployee(Integer pageNo, Integer pageSize)
	{
		try
		{
			logger.debug("Success :: Data fetched successfully !");
			return employeeRepository.findAll(PageRequest.of(pageNo, pageSize));	

		}
		catch (Exception e)
		{
			throw new RuntimeException("Error  :: Internal Server Error !!!");
		}
		
	        
	}

	@Override
	public List<Employee> getEmployeeSortedByFirstName(String sortBy)
	{
		
		return employeeRepository.findAll(Sort.by(sortBy).descending());
	}

}
