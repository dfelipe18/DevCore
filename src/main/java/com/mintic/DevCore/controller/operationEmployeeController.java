package com.mintic.DevCore.controller;

import com.mintic.DevCore.model.Employee;
import com.mintic.DevCore.model.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
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
    public String createEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "create-employee";
    }

    @PostMapping("/save-employee")
    public String saveEmployee(Employee employee) {
        ResponseEntity<Employee> response = employeesRepo.saveEmployee(employee);
        if (response.getStatusCodeValue() == 200) {
            return "redirect:/get-employee";
        } else {
            return "create-employee";
        }
    }

    @GetMapping("/update-employee/{id}")
    public String updateEmployee(@PathVariable Long id, Model model) {
        Optional<Employee> employee = employeesRepo.getEmployeeById(id);
        model.addAttribute("employee", employee);
        model.addAttribute("message", "Actualizar empleado:");
        return "create-employee";
    }

    @GetMapping("/delete-employee/{id}")
    public String deleteEmployee(Model model, @PathVariable Long id) {
        employeesRepo.deleteEmployee(id);
        return "redirect:/get-employee";
    }
}
