package com.sem4.suncompany.controller;

import com.sem4.suncompany.entity.EmployeeEntity;
import com.sem4.suncompany.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String getListEmployee(Model model) {
        model.addAttribute("employeeList", employeeService.getListEmployee());
        model.addAttribute("employeeEntity", new EmployeeEntity());
        return "index";
    }

    @PostMapping("/create-new-employee")
    public String createNewEmployee(@ModelAttribute(value = "employeeEntity") EmployeeEntity employeeEntity) throws Exception {
        employeeService.createNewEmployee(employeeEntity);
        return "redirect:/";
    }

    @GetMapping("/delete-employee-by-id/{id}")
    public String deleteEmployeeById(@PathVariable(value = "id") Long id) throws Exception {
        employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }

}
