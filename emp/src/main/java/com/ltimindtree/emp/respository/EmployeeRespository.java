package com.ltimindtree.emp.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ltimindtree.emp.entity.Employee;

@Repository
public interface EmployeeRespository extends JpaRepository<Employee, Long> {

    
}
