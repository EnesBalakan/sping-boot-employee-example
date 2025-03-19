package com.suphanBirlik.SuphanBirlikElemanlar.rest;

import com.suphanBirlik.SuphanBirlikElemanlar.entity.Employee;
import com.suphanBirlik.SuphanBirlikElemanlar.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
   private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    //expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    // add mapping for GET /employees /{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee thEmployee = employeeService.findById(employeeId);

        if(thEmployee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        return thEmployee;
    }

    // add mapping for POST /employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee thEmployee){

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update
        thEmployee.setId(0);

        Employee dbEmployee = employeeService.save(thEmployee);

        return dbEmployee;
    }

    // add mapping for put /employees - update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    // add mapping for DELETE /employees /{employeeId} - delete employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        //find employee
        Employee tempEmployee = employeeService.findById(employeeId);

        //trow exeption if null
        if(tempEmployee == null){
            throw new RuntimeException("Employee Id not found -- " + employeeId);
        }

        employeeService.delete(employeeId);

        return "Deleted Employee - " + employeeId;
    }
}
