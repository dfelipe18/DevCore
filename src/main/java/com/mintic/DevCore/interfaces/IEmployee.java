package com.mintic.DevCore.interfaces;

import com.mintic.DevCore.model.Employee;
import com.mintic.DevCore.model.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface IEmployee extends JpaRepository<Employee, Long> {
    @Query("SELECT u FROM Employee u WHERE u.email = ?1")
    public Employee findByEmail(String email);

    @Query(value = "SELECT * FROM employee WHERE employee.enterprise_id = ?1", nativeQuery = true)
    List<Employee> findByEnterpriseIs(long id);

}
