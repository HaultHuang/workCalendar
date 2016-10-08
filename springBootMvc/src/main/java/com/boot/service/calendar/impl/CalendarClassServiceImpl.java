package main.java.com.boot.service.calendar.impl;

import ma.glasnost.orika.MapperFacade;
import main.java.com.boot.dto.calendar.CalendarClassDto;
import main.java.com.boot.model.jpa.calendar.CalendarClass;
import main.java.com.boot.model.jpa.calendar.Employee;
import main.java.com.boot.repository.jpa.calendar.CalendarClassRepository;
import main.java.com.boot.repository.jpa.calendar.EmployeeRepository;
import main.java.com.boot.service.calendar.CalendarClassService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Created by hao huang on 19/09/2016.
 */
@Service
@Transactional
public class CalendarClassServiceImpl implements CalendarClassService {

    @Resource
    private CalendarClassRepository calendarClassRepository;

    @Resource
    private EmployeeRepository employeeRepository;

    @Resource
    private MapperFacade mapperFacade;

    @Override
    public Collection<CalendarClassDto> findAllCalendarClasses() {
        return mapperFacade.mapAsList(calendarClassRepository.findAll(), CalendarClassDto.class);
    }

    @Override
    public void saveCalendarClass(CalendarClassDto calendarClassDto) {
        CalendarClass cc = mapperFacade.map(calendarClassDto, CalendarClass.class);
        Collection<Employee> employes = cc.getEmployees();
        for(Employee employee : employes){
            employee = employeeRepository.findOne(employee.getId());
        }
        calendarClassRepository.save(cc);
    }

    @Override
    public void deleteCalendarClassById(String id) {
        calendarClassRepository.delete(Long.valueOf(id));
    }

    @Override
    public CalendarClassDto findCalendarClassById(String id) {
        return mapperFacade.map(calendarClassRepository.findOne(Long.valueOf(id)), CalendarClassDto.class);
    }
}
