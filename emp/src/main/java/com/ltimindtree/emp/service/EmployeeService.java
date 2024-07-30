package com.ltimindtree.emp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltimindtree.emp.entity.Employee;
import com.ltimindtree.emp.respository.EmployeeRespository;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRespository employeeRespository;

    public Employee createEmployee(Employee employee){
        return employeeRespository.save(employee);

    }
    
    public Employee getEmployeeById(Long id){
        return employeeRespository.findById(id).get();
    }
    
}
