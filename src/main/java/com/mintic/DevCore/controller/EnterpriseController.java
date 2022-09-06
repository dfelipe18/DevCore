package com.mintic.DevCore.controller;
import com.tools.springBoot.project.interfaceService.IpersonaService;
import com.tools.springBoot.project.modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services")
@Controller
public class EnterpriseController{
    @Autowired
    private IEnterprise service;

    @GetMapping("/listar")
    public String listar(Model model) {
        List<Enterprise> enterprise = service.listar();
        model.addAttribute("enterprise", enterprise);
        return "index";
    }

    @GetMapping("/crear")
    public String agregar(Model model) {
        model.addAttribute("enterprise", new enterprise());
        return "form";
    }

    @PostMapping("/guardar")
    public String save(@Validated Enterprise p, Model model) {
        service.save(p);
        return "redirect:/listar";
    }

    @GetMapping("/editar/{id}")
    public String edit(@PathVariable int id, Model model) {
        Optional<Enterprise> enterprise = service.listarId(id);
        model.addAttribute("enterprise", enterprise);
        return "form";
    }

    @GetMapping("/eliminar/{id}")
    public String delete(Model model, @PathVariable int id) {
        service.delete(id);
        return "redirect:/listar";
    }
}