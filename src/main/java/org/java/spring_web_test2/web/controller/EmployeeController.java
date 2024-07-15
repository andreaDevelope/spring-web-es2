package org.java.spring_web_test2.web.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.java.spring_web_test2.db.pojo.Employee;
import org.java.spring_web_test2.db.pojo.Role;
import org.java.spring_web_test2.db.service.EmployeeService;
import org.java.spring_web_test2.db.service.RoleService;
import org.java.spring_web_test2.web.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeService es;

    @Autowired
    private RoleService rs;

    @GetMapping("add")
    public ResponseEntity<Void> addEmployee() {
        Employee e1 = new Employee("Gigi", "Erpuzza", 100, 10);
        Employee e2 = new Employee("Carlo", "Magno", 200, 10);

        es.save(e1);
        es.save(e2);

        System.out.println("Hai salvato i seguenti employee: " + e1 + " | " + e2);

        return ResponseEntity.ok().build();
    }

    @GetMapping("add-role")
    public ResponseEntity<List<Role>> addRole() {
        Optional<Employee> optE = es.getById(3);
        if (optE.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Employee e = optE.get();

        Optional<Employee> optE2 = es.getById(5);
        if (optE2.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Employee e2 = optE2.get();

        Role r1 = new Role("full-stack developer", e);
        Role r2 = new Role("back-end developer", e2);

        rs.save(r1);
        rs.save(r2);

        System.out.println("Hai salvato i seguenti Role: " + r1 + " | " + r2);

        return ResponseEntity.ok(rs.getAll());
    }

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> employees = es.getAll();
        return ResponseEntity.ok(employees);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        Optional<Employee> optE = es.getById(id);
        if (optE.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Employee e = optE.get();
        es.delete(e);

        return ResponseEntity.ok(e + " Employee eliminato");
    }

    @PostMapping("create")
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDto ed) {
        Employee e = new Employee(ed.getName(), ed.getLastname(), ed.getSalary(), ed.getBonus());
        es.save(e);
        return ResponseEntity.ok(e);
    }

    @PatchMapping("update/{id}")
    public ResponseEntity<Employee> upDateMachine(@PathVariable int id, @RequestBody EmployeeDto ed) {
        Optional<Employee> optE = es.getById(id);

        if (optE.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Employee e = optE.get();

        if (ed.getName() != null && !ed.getName().isEmpty()) {
            e.setName(ed.getName());
        }

        if (ed.getLastname() != null && !ed.getLastname().isEmpty()) {
            e.setLastname(ed.getLastname());
        }

        if (ed.getSalary() != -1 && ed.getSalary() != 0) {
            e.setSalary(ed.getSalary());
        }

        if (ed.getBonus() != -1 && ed.getBonus() != 0) {
            e.setBonus(ed.getBonus());
        }

        es.save(e);

        return ResponseEntity.ok(e);
    }
}
