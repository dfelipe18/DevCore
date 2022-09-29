package com.mintic.DevCore.interfaceServices;

import com.mintic.DevCore.model.Enterprise;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IEnterpriseService {

    @GetMapping("/get-all-enterprises")
    List<Enterprise> getAllEnterprises();

    @GetMapping("/get-enterprise/{id}")
    Optional<Enterprise> getEnterpriseById(@PathVariable Long id);

    @PostMapping("/save-enterprise")
    ResponseEntity<Enterprise> saveEnterprise(@RequestBody Enterprise transaction);

    @PatchMapping("/update-enterprise/{id}")
    ResponseEntity<Enterprise> updateEnterprise(@PathVariable Long id, @RequestBody Map<Object, Object> fields);

    @DeleteMapping("/delete-enterprise/{id}")
    ResponseEntity<Void> deleteEnterprise(@PathVariable("id") Long id);

}
