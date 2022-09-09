package com.mintic.DevCore.services;

import com.mintic.DevCore.interfaces.IProfile;
import com.mintic.DevCore.interfaces.ITransaction;
import com.mintic.DevCore.model.Profile;
import com.mintic.DevCore.model.Transaction;
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
public class ProfileService {

    @Autowired
    private IProfile repository;

    /*
     * Método para listar todas las transacciones.
     * Creamos una lista de transacciones y luego realizamos la búsqueda
     * de todos los registros y los añadimos a la lista, luego retornamos la lista.
     */
    public List<Profile> listAllProfiles() {
        List<Profile> profiles = new ArrayList<>();
        profiles.addAll(repository.findAll());
        return profiles;
    }

    /*
     * Método para listar una transacción por el ID, primero buscamos
     * la transacción por su ID, luego valdiamos si está presente en la consulta
     * y por último retornamos el objeto encontrado.
     */
    public ResponseEntity<Profile> listProfileById(long id) {
        Optional<Profile> profile = repository.findById(id);
        if(profile.isPresent()) {
            return ResponseEntity.ok(profile.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    /*
     * Método para guardar una transacción.
     * Validamos que el objeto sea diferente de nulo, y luego pasamos
     * el objeto al método de guardar y retornamos el HTTP RESPONSE.
     */
    public ResponseEntity<Profile> saveProfile(Profile profile) {
        if (!profile.equals(null)) {
            repository.save(profile);
            return ResponseEntity.ok(profile);
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

    public ResponseEntity<Profile> updateProfile(Long id, Map<Object, Object> fields) {
        Optional<Profile> profile = repository.findById(id);
        if (profile.isPresent()) {
            Profile updateProfile = profile.get();
            fields.forEach((key, value) -> {
                // use reflection to get field k on Transaction and set it to value v
                Field field = ReflectionUtils.findField(Profile.class, (String) key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, updateProfile, value);
            });
            repository.save(updateProfile);
            return ResponseEntity.ok(updateProfile);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    /*
     * Método para eliminar una transacción.
     * Validamos que el objeto esté presente y luego le pasamos el ID,
     * para su eliminación, por último retornamos el HTTP RESPONSE.
     */
    public ResponseEntity<Void> deleteProfile(Long id) {
        Optional<Profile> profile = repository.findById(id);
        if (profile.isPresent()) {
            repository.deleteById(id);
        }
        return ResponseEntity.ok(null);
    }
}
