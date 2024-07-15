package org.java.spring_web_test2.db.pojo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String lastname;
    private int salary;
    private int bonus;

    @OneToMany(mappedBy = "employee")
    private List<Role> roles;

    public Employee() {
        
    }

    public Employee(String name, String lastname, int salary, int bonus) {
        setName(name);
        setLastname(lastname);
        this.salary = salary;
        setBonus(bonus);
        setSalary(salary);
    }

    public int getId() {
        return id;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary + (salary * bonus / 100);
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "EMPLOYEE ID [" + getId() + "]" + " | name: " + getName() + " | lastname: " + getLastname() +
        " | salary: " + getSalary();
    }
}
