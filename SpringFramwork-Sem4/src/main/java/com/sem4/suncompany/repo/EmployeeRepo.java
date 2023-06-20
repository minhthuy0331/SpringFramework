package com.sem4.suncompany.repo;

import com.sem4.suncompany.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long> {

    Optional<EmployeeEntity> findByName(String name);

}
