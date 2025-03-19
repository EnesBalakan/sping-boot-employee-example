package com.suphanBirlik.SuphanBirlikElemanlar.dao;

import com.suphanBirlik.SuphanBirlikElemanlar.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

// Mapping Name
@RepositoryRestResource(path = "eleman")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
