/*

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
*/
//<<<<<<< HEAD
package com.mintic.DevCore.controller;
import com.mintic.DevCore.interfaces.IEnterprise;
import com.mintic.DevCore.model.Enterprise;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enterprises")
public class EnterpriseController {

    @Autowired
    private IEnterprise iEnterprise;

    //Met para obtener todos las Empresas
    @GetMapping
    public ResponseEntity<List<Enterprise>> getEnterprise(){
        List<Enterprise> empresas = iEnterprise.findAll();
        return ResponseEntity.ok(empresas);
    }

    //Met para listar una empresa por su id
    // /Enterprise({enterpriseId -> /Enterprise/1}
    @RequestMapping(value="{enterpriseId}")
    public ResponseEntity<Enterprise> getEnterpriseById(@PathVariable("enterpriseId") Long enterpriseId){
        java.util.Optional<Enterprise> optionalEnterprise = iEnterprise.findById(enterpriseId);
        if(((java.util.Optional<Enterprise>) optionalEnterprise).isPresent()) {
            return ResponseEntity.ok(((java.util.Optional<Enterprise>) optionalEnterprise).get());
        }else
            return ResponseEntity.noContent().build();
    }

    //Met para generar una nueva empresa
    @PostMapping
    public ResponseEntity<Enterprise> createEnterprise(@RequestBody Enterprise enterprise){
        Enterprise newEnterprise = iEnterprise.save(enterprise);
        return ResponseEntity.ok(newEnterprise);
    }

    //Met para eliminar una empresa
    @DeleteMapping(value="{EnterpriseId}")
    public ResponseEntity<Void> deleteEnterprise(@PathVariable("EnterpriseId") Long productId){
        iEnterprise.deleteById(productId);
        return ResponseEntity.ok(null);
    }

    //Met para actualizar una empresa
    @PutMapping
    public ResponseEntity<Enterprise> updateEnterprise(@RequestBody Enterprise enterprise){
        Optional<Enterprise> optionalEnterprise = iEnterprise.findById(enterprise.getId());
        if(optionalEnterprise.isPresent()){
            Enterprise updateProduct = optionalEnterprise.get();
            updateProduct.setName(enterprise.getName());
            iEnterprise.save(updateProduct);
            return ResponseEntity.ok(updateProduct);
        }else
            return ResponseEntity.notFound().build();
    }
}
/*
=======
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
>>>>>>> 3a31c43040b9ae33422a794024bdbcb15df67395
*/