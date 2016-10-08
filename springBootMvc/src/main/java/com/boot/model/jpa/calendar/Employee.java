package main.java.com.boot.model.jpa.calendar;

import main.java.com.boot.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by hao huang on 19/09/2016.
 */
@Entity
@Table(name="EMPLOYEE")
public class Employee extends BaseEntity{

    @Column(name="CODE")
    private String code;

    @Column(name="NAME")
    private String name;

    @Column(name="AGE")
    private Integer age;

    @Column(name="SEX")
    private String sex;

    @Column(name="DESCRIPTION")
    private String description;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
