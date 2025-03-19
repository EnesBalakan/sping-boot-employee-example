package com.suphanBirlik.SuphanBirlikElemanlar.service;

import com.suphanBirlik.SuphanBirlikElemanlar.entity.Employee;


import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void delete(int theId);
}
