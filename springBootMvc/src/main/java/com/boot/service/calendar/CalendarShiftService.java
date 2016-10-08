package main.java.com.boot.service.calendar;

import main.java.com.boot.dto.calendar.CalendarShiftDto;

import java.util.Collection;

/**
 * Created by hao huang on 19/09/2016.
 */
public interface CalendarShiftService {

    Collection<CalendarShiftDto> findAllCalendarShifts();

    void saveCalendarShift(CalendarShiftDto calendarShiftDto);

    void deleteCalendarShiftById(String id);

    CalendarShiftDto findCalendarShiftById(String id);
}
