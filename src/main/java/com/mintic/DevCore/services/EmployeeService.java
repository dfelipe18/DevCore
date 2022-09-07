package com.mintic.DevCore.services;

import com.mintic.DevCore.interfaces.IEmployee;
import com.mintic.DevCore.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    public IEmployee repository;

    public List<Employee> listAll(){
        List<Employee> employees = new ArrayList<>();

        repository.findAll().forEach(employee -> employees.add(employee));

        return employees;
    }

    public Employee get(long id){
        return repository.findById(id).get();
    }

    public void save(Employee employee) {repository.save(employee);}

    public void delete(long id){repository.deleteById(id);}
}
