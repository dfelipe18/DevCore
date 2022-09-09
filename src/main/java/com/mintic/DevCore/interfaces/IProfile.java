package com.mintic.DevCore.interfaces;

import com.mintic.DevCore.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfile extends JpaRepository<Profile, Long> {
}
