package com.mintic.DevCore.interfaceServices;

import com.mintic.DevCore.model.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public interface IProfileService {

    @GetMapping("/get-all-profiles")
    List<Profile> getAllProfiles();

    @GetMapping("/get-profile/{id}")
    ResponseEntity<Profile> getProfileById(@PathVariable Long id);

    @PostMapping("/save-profile")
    ResponseEntity<Profile> createProfile(@RequestBody Profile profile);

    @PatchMapping("/update-profile/{id}")
    ResponseEntity<Profile> updateProfile(@PathVariable Long id, @RequestBody Map<Object, Object> fields);

    @DeleteMapping("/delete-profile/{id}")
    ResponseEntity<Void> deleteProfile(@PathVariable("id") Long id);
}
