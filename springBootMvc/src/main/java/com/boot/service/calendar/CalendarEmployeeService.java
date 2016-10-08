package main.java.com.boot.service.calendar;

import main.java.com.boot.dto.calendar.EmployeeDto;

import java.util.Collection;

/**
 * Created by hao huang on 19/09/2016.
 */
public interface CalendarEmployeeService {
    Collection<EmployeeDto> findAllEmployees();

    void saveEmployee(EmployeeDto employeeDto);

    void deleteEmployeeById(String id);

    EmployeeDto findEmployeeById(String id);
}
