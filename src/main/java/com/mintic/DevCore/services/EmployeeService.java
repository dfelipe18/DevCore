package com.mintic.DevCore.services;

import com.mintic.DevCore.interfaces.IEmployee;
import com.mintic.DevCore.model.Employee;
import com.mintic.DevCore.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    public IEmployee repository;

    public List<Employee> listAllEmployees(){
        List<Employee> employees = new ArrayList<>();
        employees.addAll(repository.findAll());
        return employees;
    }

    public Optional<Employee>  listEmployeeById(long id){
        Optional<Employee> employee = repository.findById(id);
        return employee;
    }

    public ResponseEntity<Employee> saveEmployee(Employee employee) {
        if(!employee.equals(null)){
            repository.save(employee);
            return ResponseEntity.ok(employee);
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    public ResponseEntity<Employee> updateEmployee(Long id, Map<Object, Object> fields) {
        Optional<Employee> employee = repository.findById(id);

        if(employee.isPresent()){
            Employee updateEmployee = employee.get();
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Employee.class,(String) key);
                field.setAccessible(true);

                ReflectionUtils.setField(field, updateEmployee, value);
            });
            repository.save(updateEmployee);
            return ResponseEntity.ok(updateEmployee);
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    public ResponseEntity<Void> deleteEmployee(long id){
        Optional<Employee> employee = repository.findById(id);

        if(employee.isPresent()){
            repository.deleteById(id);
        }

        return ResponseEntity.ok(null);
    }

    public List<Employee> getEmployeesByEnterprise(long id) throws Exception {
        try {
            List<Employee> employees = repository.findByEnterpriseIs(id);
            return employees;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
}
