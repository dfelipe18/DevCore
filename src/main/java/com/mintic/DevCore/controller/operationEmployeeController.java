package com.mintic.DevCore.controller;

import com.mintic.DevCore.model.Employee;
import com.mintic.DevCore.model.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class operationEmployeeController {

    @Autowired
    private EmployeeController employeesRepo;

    @GetMapping("/get-employee")
    public String getEmployees(Model model) {
        List<Employee> employees = employeesRepo.getAllEmployees();
        model.addAttribute("employees", employees);
        return "get-employee";
    }
    @GetMapping("/create-employee")
    public String createEnterprises() {
        return "create-employee";
    }
}
