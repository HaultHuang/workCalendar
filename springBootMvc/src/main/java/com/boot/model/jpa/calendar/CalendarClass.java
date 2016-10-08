package main.java.com.boot.model.jpa.calendar;

import main.java.com.boot.model.BaseEntity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by hao huang on 19/09/2016.
 */
@Entity
@Table(name = "CALENDAR_CLASS")
public class CalendarClass extends BaseEntity {

    @Column(name = "CODE")
    private String code;

    @Column(name = "NAME")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    @JoinTable(name="CALENDAR_CLASS_EMPLOYEE",joinColumns = {@JoinColumn(name="CALENDER_CLASS_ID",referencedColumnName = "ID")}, inverseJoinColumns = {@JoinColumn(name="EMPLOYEE_ID",referencedColumnName = "ID")})
    private Collection<Employee> employees;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Collection<Employee> employees) {
        this.employees = employees;
    }
}
