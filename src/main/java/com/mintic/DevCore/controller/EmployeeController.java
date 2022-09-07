package com.mintic.DevCore.controller;

import com.mintic.DevCore.model.Employee;
import com.mintic.DevCore.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping("/employee")
    private List<Employee> getAllEmployees(){return service.listAll();}

    @PostMapping("/employee")
    private Employee saveEmployee(@RequestBody Employee employee){
        service.save(employee);

        return employee;
    }

    @PatchMapping("/employee/{id}")
    private Employee update(@PathVariable Long id, @RequestBody Employee employee)
    {
        Employee employee1 = service.get(id);

        employee1.setEmail(employee.getEmail());
        employee1.setRole(employee.getRole());
        employee1.setCreatedAt(employee.getCreatedAt());
        employee1.setUpdateAt(employee.getUpdateAt());

        if(!Objects.isNull(employee.getEnterprise().getId())){
            employee1.setEnterprise(employee.getEnterprise());
        }

        if(!Objects.isNull(employee.getProfile().getId())){
            employee1.setProfile(employee.getProfile());
        }

        service.save(employee1);

        return employee1;
    }

    @DeleteMapping("/employee/{id}")
    private boolean deleteEmployee(@PathVariable Long id){
        service.delete(id);
        return true;
    }

    @GetMapping("/employee/{id}")
    private Employee getEmployee(@PathVariable Long id){
        Employee employee = service.get(id);

        return employee;
    }
}
