package org.java.spring_web_test2.db.service;

import java.util.List;
import java.util.Optional;

import org.java.spring_web_test2.db.pojo.Role;
import org.java.spring_web_test2.db.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    RoleRepo rr;

    public List<Role> getAll(){
        return rr.findAll();
    }

    public Optional<Role> getById(int id){
        return rr.findById(id);
    }

    public void save(Role r){
        rr.save(r);
    }

    public void delete(Role r){
        rr.delete(r);
    }
}
