package com.clbs.services;

import java.util.List;

import com.clbs.model.Employee;

public interface EmployeeServices {
    /*
     * add,update and delete section
     */
    public boolean add(Employee employee) throws Exception;
    public boolean update(Employee employee) throws Exception;
    public boolean delete(long id) throws Exception;
    
    /*
     * query section
     */
    public Employee getEmployeeById(long id) throws Exception;
    public List<Employee> getEmployeeList() throws Exception;
}
