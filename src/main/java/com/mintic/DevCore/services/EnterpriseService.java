package com.mintic.DevCore.services;

import com.mintic.DevCore.interfaces.IEnterprise;
import com.mintic.DevCore.model.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EnterpriseService {

    @Autowired
    private IEnterprise repository;

    /*
     * Método para listar todas las Empresas.
     * Creamos una lista de Empresas y luego realizamos la búsqueda
     * de todos los registros y los añadimos a la lista, luego retornamos la lista.
     */
    public List<Enterprise> listAllEnterprises() {
        List<Enterprise> Enterprises = new ArrayList<>();
        Enterprises.addAll(repository.findAll());
        return Enterprises;
    }

    /*
     * Método para listar una Empresas por el ID, primero buscamos
     * la Empresa por su ID, luego valdiamos si está presente en la consulta
     * y por último retornamos el objeto encontrado.
     */
    public ResponseEntity<Enterprise> listEnterpriseById(long id) {
        Optional<Enterprise> Enterprise = repository.findById(id);
        if(Enterprise.isPresent()) {
            return ResponseEntity.ok(Enterprise.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    /*
     * Método para guardar una Empresa.
     * Validamos que el objeto sea diferente de nulo, y luego pasamos
     * el objeto al método de guardar y retornamos el HTTP RESPONSE.
     */
    public ResponseEntity<Enterprise> saveEnterprise(Enterprise Enterprise) {
        if (!Enterprise.equals(null)) {
            repository.save(Enterprise);
            return ResponseEntity.ok(Enterprise);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    /*
     * Método para actualizar una transacción.
     * Validamos que exista la transacción, luego recorremos todos los campos
     * que está seteando el usuario y a cada uno de esos campos le seteamos el valor
     * correspondiente, sin afectar los campos que no se necesiten actualizar.
     */

    public ResponseEntity<Enterprise> updateEnterprise(Long id, Map<Object, Object> fields) {
        Optional<Enterprise> Enterprise = repository.findById(id);
        if (Enterprise.isPresent()) {
            Enterprise updateEnterprise = Enterprise.get();
            fields.forEach((key, value) -> {
                // use reflection to get field k on Enterprise and set it to value v
                Field field = ReflectionUtils.findField(Enterprise.class, (String) key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, updateEnterprise, value);
            });
            repository.save(updateEnterprise);
            return ResponseEntity.ok(updateEnterprise);
        } else {
            return ResponseEntity.noContent().build();
        }
    }


    /*
     * Método para eliminar una transacción.
     * Validamos que el objeto esté presente y luego le pasamos el ID,
     * para su eliminación, por último retornamos el HTTP RESPONSE.
     */
    public ResponseEntity<Void> deleteEnterprise(Long id) {
        Optional<Enterprise> Enterprise = repository.findById(id);
        if (Enterprise.isPresent()) {
            repository.deleteById(id);
        }
        return ResponseEntity.ok(null);
    }
}
