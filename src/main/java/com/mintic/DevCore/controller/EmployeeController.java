package com.mintic.DevCore.controller;

import com.mintic.DevCore.interfaceServices.IEmployeeService;
import com.mintic.DevCore.model.Employee;
import com.mintic.DevCore.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController implements IEmployeeService {
    @Autowired
    private EmployeeService service;

    @Override
    public List<Employee> getAllEmployees()
    {return service.listAllEmployees();}

    @Override
    public ResponseEntity<Employee> getEmployeeById(Long id){
        return service.listEmployeeById(id);
    }
    @Override
    public ResponseEntity<Employee> saveEmployee(Employee employee){
        return service.saveEmployee(employee);
    }

    @Override
    public ResponseEntity<Employee> updateEmployee(Long id, Map<Object, Object> fields)
    {
        return service.updateEmployee(id, fields);
    }

    @Override
    public ResponseEntity<Void> deleteEmployee( Long id){
        return service.deleteEmployee(id);
    }
}
