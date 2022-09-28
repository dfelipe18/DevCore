package com.mintic.DevCore.interfaceServices;

import com.mintic.DevCore.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public interface IEmployeeService {

    @GetMapping("/get-all-employees")
    List<Employee> getAllEmployees();

    @GetMapping("/get-employee/{id}")
    ResponseEntity<Employee> getEmployeeById(@PathVariable Long id);

    @PostMapping("/save-employee")
    ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee);

    @PatchMapping("/update-employee/{id}")
    ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Map<Object, Object> fields);

    @DeleteMapping("/delete-employee/{id}")
    ResponseEntity<Void> deleteEmployee(@PathVariable Long id);
}
