package com.mintic.DevCore.interfaces;

import com.mintic.DevCore.model.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEnterprise extends JpaRepository<Enterprise,Long> {
}
