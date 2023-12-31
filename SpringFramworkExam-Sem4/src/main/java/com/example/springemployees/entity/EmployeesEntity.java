package com.example.springemployees.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "employees")
public class EmployeesEntity {
    @Id
    private long id;
    private String name;
    private BigDecimal wage;



    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWage(BigDecimal wage) {
        this.wage = wage;
    }

    public BigDecimal getWage() {
        return wage;
    }

    public Employees() {

    }

    public Employees(String name, long id, BigDecimal wage) {
        this.name = name;
        this.id = id;
        this.wage = wage;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
