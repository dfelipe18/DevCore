package com.mintic.DevCore.interfaceServices;

import com.mintic.DevCore.model.Enterprise;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public interface IEnterpriseService {

    @GetMapping("/get-all-enterprise")
    List<Enterprise> getAllEnterprises();

    @GetMapping("/get-enterprise/{id}")
    ResponseEntity<Enterprise> getEnterpriseById(@PathVariable Long id);

    @PostMapping("/save-enterprise")
    ResponseEntity<Enterprise> createEnterprise(@RequestBody Enterprise transaction);

    @PatchMapping("/update-enterprise/{id}")
    ResponseEntity<Enterprise> updateEnterprise(@PathVariable Long id, @RequestBody Map<Object, Object> fields);

    @DeleteMapping("/delete-enterprise/{id}")
    ResponseEntity<Void> deleteEnterprise(@PathVariable("id") Long id);

}
