package com.mintic.DevCore.interfaces;

import com.mintic.DevCore.model.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnterprise extends JpaRepository<Enterprise,Long> {
}
