package main.java.com.boot.service.calendar.impl;

import ma.glasnost.orika.MapperFacade;
import main.java.com.boot.dto.calendar.EmployeeDto;
import main.java.com.boot.model.jpa.calendar.Employee;
import main.java.com.boot.repository.jpa.calendar.EmployeeRepository;
import main.java.com.boot.service.calendar.CalendarEmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Created by hao huang on 19/09/2016.
 */
@Service
@Transactional
public class CalendarEmployeeServiceImpl implements CalendarEmployeeService {

    @Resource
    private MapperFacade mapperFacade;

    @Resource
    private EmployeeRepository employeeRepository;

    @Override
    public Collection<EmployeeDto> findAllEmployees() {
        return mapperFacade.mapAsList(employeeRepository.findAll(), EmployeeDto.class);
    }

    @Override
    public void saveEmployee(EmployeeDto employeeDto) {
        Employee employee = mapperFacade.map(employeeDto, Employee.class);
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(String id) {
        employeeRepository.delete(Long.valueOf(id));
    }

    @Override
    public EmployeeDto findEmployeeById(String id) {
        return mapperFacade.map(employeeRepository.findOne(Long.valueOf(id)), EmployeeDto.class);
    }
}
