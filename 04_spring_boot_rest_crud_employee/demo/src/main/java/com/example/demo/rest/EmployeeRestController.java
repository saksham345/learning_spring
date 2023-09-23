package com.example.demo.rest;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
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

    //expose "employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeID}")
    public Employee getEmployee(@PathVariable int employeeID){
        Employee theEmployee = employeeService.findById(employeeID);
        if(theEmployee == null){
            throw new RuntimeException("Employee ID not found -"+employeeID);
        }
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        //just in case the pass ID to JSON,.... set it to 0.
        //this is to force save a new item, instead of update.

        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){

        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeID}")
    public String deleteEmployee(@PathVariable int employeeID){
        Employee theEmployee = employeeService.findById(employeeID);
        if(theEmployee == null){
            throw new RuntimeException("Employee ID not found -"+employeeID);
        }
        employeeService.deleteByI(employeeID);

        return "Deleted Employee ID"+employeeID;
    }
}
