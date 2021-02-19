package com.spring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmployeesRepo extends JpaRepository<Employees , Integer> {

}
