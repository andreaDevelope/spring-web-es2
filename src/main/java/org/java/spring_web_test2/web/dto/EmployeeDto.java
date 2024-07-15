package org.java.spring_web_test2.web.dto;


public class EmployeeDto {

    private String name;
    private String lastname;
    private int salary;
    private int bonus;

    public EmployeeDto(){
        setName(name);
        setLastname(lastname);
        setBonus(bonus);
        setSalary(salary);
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


}
