package com.ibm.application.employee.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.application.employee.customeException.EmployeeResourceException;
import com.ibm.application.employee.model.Employee;
import com.ibm.application.employee.repository.EmployeeRepository;

@RestController
@RequestMapping("/ibm/employee/")
public class EmployeeController {
	
@Autowired	
private EmployeeRepository empRep; // Interface imported


//add employee

@PostMapping("/add")
public Employee createEmployee(@RequestBody Employee emp)
{
	
	return empRep.save(emp);
	
}

// view all emp

@GetMapping("/allemp")
public List<Employee>getAllEmployee(){
	return empRep.findAll();
}

// veiw emp by using id

@GetMapping("/allemp/{id}")
public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) throws EmployeeResourceException{
Employee emp=empRep.findById(id).orElseThrow(()-> new
			EmployeeResourceException("Employee Resource Not Found"));
return ResponseEntity.ok(emp);
}

// update employee info

@PutMapping("/allemp/{id}")
public ResponseEntity<Employee> UpdateEmployeeById(@PathVariable Long id,@RequestBody Employee emp1) throws EmployeeResourceException
{
Employee emp=empRep.findById(id).orElseThrow(()-> new
			EmployeeResourceException("Employee Resource Not Found"));

       // mahesh employee record displayed
       emp.setFirstname(emp1.getFirstname());  // mahesh
       emp.setLastname(emp1.getLastname());
       emp.setEmail(emp1.getEmail());
       Employee e = empRep.save(emp);
       
       return ResponseEntity.ok(emp);
}

// Delete employee info

@DeleteMapping("/allemp/{id}")
public ResponseEntity<Employee> DeleteEmployeeById(@PathVariable Long id) throws EmployeeResourceException{
Employee emp=empRep.findById(id).orElseThrow(()-> new
			EmployeeResourceException("Employee Resource Not Found"));
empRep.delete(emp);
return ResponseEntity.ok(emp);
}
}
