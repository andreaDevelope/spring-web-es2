package org.java.spring_web_test2.web.dto;

import org.java.spring_web_test2.db.pojo.Employee;

public class RoleDto {

    private String name;

    private Employee employee;

    public RoleDto(){

    }

    public RoleDto(String name, Employee employee){
        setName(name);
        setEmployee(employee);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
