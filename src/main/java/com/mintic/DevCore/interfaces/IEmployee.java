package com.mintic.DevCore.interfaces;

import com.mintic.DevCore.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployee extends CrudRepository<Employee, Long> {
}
