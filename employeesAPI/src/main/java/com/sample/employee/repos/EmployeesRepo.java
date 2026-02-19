package com.sample.employee.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.employee.models.Employee;

@Repository
public interface EmployeesRepo extends JpaRepository<Employee, Integer> {

}
