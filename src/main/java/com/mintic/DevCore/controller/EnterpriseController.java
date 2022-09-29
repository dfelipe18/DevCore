package com.mintic.DevCore.controller;

import com.mintic.DevCore.interfaceServices.IEnterpriseService;
import com.mintic.DevCore.model.Enterprise;
import com.mintic.DevCore.services.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseController implements IEnterpriseService {
    @Autowired
    private EnterpriseService service;

    @Override
    public List<Enterprise> getAllEnterprises()
    {return service.listAllEnterprises();}

    @Override
    public Optional<Enterprise> getEnterpriseById(Long id){
        return service.listEnterpriseById(id);
    }

    @Override
    public ResponseEntity<Enterprise> saveEnterprise(Enterprise employee){
        return service.saveEnterprise(employee);
    }

    @Override
    public ResponseEntity<Enterprise> updateEnterprise(Long id, Map<Object, Object> fields)
    {
        return service.updateEnterprise(id, fields);
    }

    @Override
    public ResponseEntity<Void> deleteEnterprise( Long id){
        return service.deleteEnterprise(id);
    }
}
