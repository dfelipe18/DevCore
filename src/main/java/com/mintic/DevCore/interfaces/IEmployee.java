package com.mintic.DevCore.interfaces;

import com.mintic.DevCore.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface IEmployee extends CrudRepository<Employee, Long> {
}
