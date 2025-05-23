package com.suphanBirlik.SuphanBirlikElemanlar.dao;

import com.suphanBirlik.SuphanBirlikElemanlar.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJplampl implements EmployeeDAO{

    // define field for entityManager
    private EntityManager entityManager;

    //set up constructur injection
    @Autowired
    public EmployeeDAOJplampl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }


    @Override
    public List<Employee> findAll() {

        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        // execute query and get results list
        List<Employee> employees = theQuery.getResultList();

        // return the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        // get employee
        Employee theEmployee = entityManager.find(Employee.class, theId);
        // return employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        // save employee
        Employee dbEmployee = entityManager.merge(theEmployee);

        // return the dbEmployee
        return dbEmployee;
    }

    @Override
    public void delete(int theId) {
        // find removing employee
        Employee theEmployee =  entityManager.find(Employee.class, theId);

        // remove employee
        entityManager.remove(theEmployee);

    }
}
