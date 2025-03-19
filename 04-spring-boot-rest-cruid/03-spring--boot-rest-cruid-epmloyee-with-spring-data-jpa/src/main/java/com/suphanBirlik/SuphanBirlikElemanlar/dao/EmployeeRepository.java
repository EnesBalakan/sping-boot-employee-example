package com.suphanBirlik.SuphanBirlikElemanlar.dao;

import com.suphanBirlik.SuphanBirlikElemanlar.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
