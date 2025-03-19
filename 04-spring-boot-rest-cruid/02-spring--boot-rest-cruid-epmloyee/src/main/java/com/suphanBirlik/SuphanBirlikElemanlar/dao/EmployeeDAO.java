package com.suphanBirlik.SuphanBirlikElemanlar.dao;

import com.suphanBirlik.SuphanBirlikElemanlar.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void delete(int theId);

}
