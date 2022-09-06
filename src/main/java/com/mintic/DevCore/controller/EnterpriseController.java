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
    @DeleteMapping(value="{productId}")

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
