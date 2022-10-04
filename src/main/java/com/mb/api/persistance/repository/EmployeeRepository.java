package com.mb.api.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mb.api.persistance.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{

}
