package com.sem4.suncompany.service.impl;

import com.sem4.suncompany.entity.EmployeeEntity;
import com.sem4.suncompany.repo.EmployeeRepo;
import com.sem4.suncompany.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public void createNewEmployee(EmployeeEntity employeeEntity) throws Exception {
        if (ObjectUtils.isEmpty(employeeEntity)) {
            throw new NullPointerException("EmployeeEntity is empty !");
        }

        Optional<EmployeeEntity> employeeOptional = employeeRepo.findByName(employeeEntity.getName());
        if (employeeOptional.isPresent()) {
            throw new IllegalAccessException("Employee is ready existing !");
        }

        employeeRepo.save(employeeEntity);
    }

    @Override
    public List<EmployeeEntity> getListEmployee() {
        return employeeRepo.findAll();
    }

    @Override
    public void deleteEmployeeById(Long id) throws IllegalAccessException {
        if (ObjectUtils.isEmpty(id)) {
            throw new NullPointerException("id is empty !");
        }

        Optional<EmployeeEntity> employeeOptional = employeeRepo.findById(id);
        if (!employeeOptional.isPresent()) {
            throw new IllegalAccessException("Employee is not existing !");
        }

        employeeRepo.deleteById(id);
    }
}
