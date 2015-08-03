package com.clbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clbs.model.Employee;
import com.clbs.model.Message;
import com.clbs.services.EmployeeServices;

@Controller
@RequestMapping("/employee")
public class RestController {

    @Autowired
    EmployeeServices employeeServices;
    /*
     * add,update and delete section
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Message addEmployee(@RequestBody Employee employee) {
        try {
            employeeServices.add(employee);
            return new Message("Success", "Employee added Successfully !");
        } catch (Exception e) {
            return new Message("Error", e.toString());
        }

    }
    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Message updateEmployee(@RequestBody Employee employee) {
        try {
            employeeServices.update(employee);
            return new Message("Success", "Employee added Successfully !");
        } catch (Exception e) {
            return new Message("Error", e.toString());
        }

    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Message deleteEmployee(@PathVariable("id") long id) {

        try {
            employeeServices.delete(id);
            return new Message("Success", "Employee deleted Successfully !");
        } catch (Exception e) {
            return new Message("Error", e.toString());
        }

    }
    
    /*
     * query section
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Employee getEmployee(@PathVariable("id") long id) {
        Employee employee = null;
        try {
            employee = employeeServices.getEmployeeById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
    List<Employee> getEmployee() {

        List<Employee> employeeList = null;
        try {
            employeeList = employeeServices.getEmployeeList();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return employeeList;
    }

}
