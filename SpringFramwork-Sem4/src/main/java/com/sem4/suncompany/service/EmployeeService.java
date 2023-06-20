package com.sem4.suncompany.service;

import com.sem4.suncompany.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

    void createNewEmployee(EmployeeEntity employeeEntity) throws Exception;

    List<EmployeeEntity> getListEmployee();

    void deleteEmployeeById(Long id) throws IllegalAccessException;
}
