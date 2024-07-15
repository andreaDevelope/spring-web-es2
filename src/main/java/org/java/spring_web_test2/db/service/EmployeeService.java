package org.java.spring_web_test2.db.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.java.spring_web_test2.db.pojo.Employee;
import org.java.spring_web_test2.db.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo er;

    public List<Employee> getAll(){
        return er.findAll();
    }

    public Optional<Employee> getById(int id){
        return er.findById(id);
    }

    public void save(Employee e){
        er.save(e);
    }

    public void delete(Employee e){
        er.delete(e);
    }

    // PER OTTENERE I ROLES ASSOCIATI A UN EMPLOYEE
    @Transactional
    public Optional<Employee> getEmployeeWhitRoleById(int id) {
    Optional<Employee> optE = getById(id);
    
        if (optE.isEmpty())
            return Optional.empty();
    
        Hibernate.initialize(optE.get().getRoles());
    
        return optE;
    }

}
