package com.mintic.DevCore.controller;

import com.mintic.DevCore.model.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public String createEnterprises(Model model) {
        model.addAttribute("enterprise", new Enterprise());
        model.addAttribute("message", "Crear empresas:");
        return "create-enterprise";
    }

    @PostMapping("/save-enterprise")
    public String saveEnterprise(Enterprise enterprise) {
        ResponseEntity<Enterprise> response = enterpriseRepo.saveEnterprise(enterprise);
        if (response.getStatusCodeValue() == 200) {
            return "redirect:/get-enterprises";
        } else {
            return "create-enterprise";
        }
    }

    @GetMapping("/update-enterprise/{id}")
    public String updateEnterprise(@PathVariable Long id, Model model) {
        Optional<Enterprise> enterprise = enterpriseRepo.getEnterpriseById(id);
        model.addAttribute("enterprise", enterprise);
        model.addAttribute("message", "Actualizar empresas:");
        return "create-enterprise";
    }

    @GetMapping("/delete-enterprise/{id}")
    public String deleteEnterprise(Model model, @PathVariable Long id) {
        enterpriseRepo.deleteEnterprise(id);
        return "redirect:/get-enterprises";
    }
}
