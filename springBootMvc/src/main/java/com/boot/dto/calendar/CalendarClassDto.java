package main.java.com.boot.dto.calendar;

import main.java.com.boot.dto.BaseDto;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by hao huang on 19/09/2016.
 */
public class CalendarClassDto extends BaseDto {

    private String code;

    private String name;

    private Collection<EmployeeDto> employeeDtos = new ArrayList<>();

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

    public Collection<EmployeeDto> getEmployeeDtos() {
        return employeeDtos;
    }

    public void setEmployeeDtos(Collection<EmployeeDto> employeeDtos) {
        this.employeeDtos = employeeDtos;
    }
}
