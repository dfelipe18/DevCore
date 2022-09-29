package com.mintic.DevCore.controller;

import com.mintic.DevCore.interfaces.IEmployee;
import com.mintic.DevCore.interfaces.IEnterprise;
import com.mintic.DevCore.interfaces.ITransaction;
import com.mintic.DevCore.model.Employee;
import com.mintic.DevCore.model.Enterprise;
import com.mintic.DevCore.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class operationEnterpriseController {

    @Autowired
    private EnterpriseController enterpriseRepo;

    @GetMapping("/get-enterprises")
    public String getEnterprises(Model model) {
        List <Enterprise> enterprises = enterpriseRepo.getAllEnterprises();
        model.addAttribute("enterprises", enterprises);
        return "get-enterprises";
    }
    @GetMapping("/create-enterprise")
    public String createEnterprises() {
        return "create-enterprise";
    }
}
