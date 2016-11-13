package main.java.com.boot.service.calendar.impl;

import main.java.com.boot.dto.calendar.*;
import main.java.com.boot.model.jpa.calendar.CalendarEvent;
import main.java.com.boot.model.jpa.calendar.Employee;
import main.java.com.boot.service.calendar.CalendarClassService;
import main.java.com.boot.service.calendar.CalendarEventService;
import main.java.com.boot.service.calendar.CalendarShiftService;
import main.java.com.boot.service.calendar.WorkCalendarService;
import org.apache.commons.collections.FastArrayList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.*;

/**
 * Created by Hao on 2016/11/12.
 */
@Service
public class WorkCalendarServiceImpl implements WorkCalendarService {

    @Resource
    private CalendarClassService calendarClassService;

    @Resource
    private CalendarShiftService calendarShiftService;

    @Resource
    private CalendarEventService calendarEventService;

    @Override
    public void generate(String idShift, String idClass, Date startDate, Date endDate) {
        CalendarClassDto classDto = calendarClassService.findCalendarClassById(idClass);
        CalendarShiftDto shiftDto = calendarShiftService.findCalendarShiftById(idShift);
        Collection<EmployeeDto> employeeDtos = classDto.getEmployeeDtos();
        Collection<WorkHourDto> workHourDtos = shiftDto.getWorkHourDtos();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);

        calendarEventService.deleteAllInBatch();

        List<EmployeeDto> employees = (List<EmployeeDto>) classDto.getEmployeeDtos();
        int indexEmployee = 1;
        int employeeSize = employeeDtos.size();
        for (Date date = calendar.getTime(); date.compareTo(endDate)<=0;  date=calendar.getTime()){
            for (WorkHourDto workHourDto : workHourDtos) {
                String[] startTime = workHourDto.getStartTime().split(":");
                String[] endTime = workHourDto.getEndTime().split(":");
                Calendar newCalendar = Calendar.getInstance();
                newCalendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
                newCalendar.set(Calendar.HOUR_OF_DAY,Integer.valueOf(startTime[0]));
                newCalendar.set(Calendar.MINUTE,Integer.valueOf(startTime[1]));
                newCalendar.set(Calendar.SECOND,0);
                Date newStartDate = newCalendar.getTime();
                newCalendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
                newCalendar.set(Calendar.HOUR_OF_DAY,Integer.valueOf(endTime[0]));
                newCalendar.set(Calendar.MINUTE,Integer.valueOf(endTime[1]));
                Date newEndDate = newCalendar.getTime();
                System.out.println(format.format(newStartDate)+":"+format.format(newEndDate));
                CalendarEventDto calendarEvent = new CalendarEventDto();
                calendarEvent.setStart(format.format(newStartDate));
                calendarEvent.setEnd(format.format(newEndDate));
                calendarEvent.setAllDay(false);
                calendarEvent.setColor("green");
                calendarEvent.setTextColor("white");
                calendarEvent.setTitle(employees.get(indexEmployee%employeeSize).getName());
                calendarEventService.saveCalendarEvent(calendarEvent);
                indexEmployee++;
            }
            calendar.add(Calendar.DAY_OF_MONTH,1);
        }
    }


}
