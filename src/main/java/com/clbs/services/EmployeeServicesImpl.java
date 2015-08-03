package com.clbs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.clbs.dao.EmployeeDao;
import com.clbs.model.Employee;

public class EmployeeServicesImpl implements EmployeeServices {
    /*
     * add,update and delete section
     */
    @Autowired
    EmployeeDao employeeDao;
    
    @Override
    public boolean add(Employee employee) throws Exception {
        return employeeDao.add(employee);
    }

    @Override
    public boolean update(Employee employee) throws Exception {
        return employeeDao.update(employee);
    }

    @Override
    public boolean delete(long id) throws Exception {
        return employeeDao.delete(id);
    }

    /*
     * query section
     */
    @Override
    public Employee getEmployeeById(long id) throws Exception {
        return employeeDao.getEmployeeById(id);
    }

    @Override
    public List<Employee> getEmployeeList() throws Exception {
        return employeeDao.getEmployeeList();
    }

}
