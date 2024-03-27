package com.ibm.application.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.application.employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
