package main.java.com.boot.service.calendar;

import main.java.com.boot.dto.calendar.CalendarClassDto;

import java.util.Collection;

/**
 * Created by hao huang on 19/09/2016.
 */
public interface CalendarClassService {

    Collection<CalendarClassDto> findAllCalendarClasses();

    void saveCalendarClass(CalendarClassDto calendarClassDto);

    void deleteCalendarClassById(String id);

    CalendarClassDto findCalendarClassById(String id);
}
