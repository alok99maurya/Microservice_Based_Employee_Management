package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.employee.model.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
