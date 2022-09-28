package com.mintic.DevCore.controller;

import com.mintic.DevCore.interfaceServices.IProfileService;
import com.mintic.DevCore.model.Profile;
import com.mintic.DevCore.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/profile")
public class ProfileController implements IProfileService {

    @Autowired
    private ProfileService request;

    @Override
    public List<Profile> getAllProfiles() {
        return request.listAllProfiles();
    }

    @Override
    public ResponseEntity<Profile> getProfileById(Long id) {
        return request.listProfileById(id);
    }

    @Override
    public ResponseEntity<Profile> createProfile(Profile profile) {
        return request.saveProfile(profile);
    }

    @Override
    public ResponseEntity<Profile> updateProfile(Long id, Map<Object, Object> fields) {
        return request.updateProfile(id, fields);
    }

    @Override
    public ResponseEntity<Void> deleteProfile(Long id) {
        return request.deleteProfile(id);
    }
}
