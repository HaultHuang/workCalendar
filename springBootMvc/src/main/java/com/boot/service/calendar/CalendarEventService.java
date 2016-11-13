package main.java.com.boot.service.calendar;

import main.java.com.boot.dto.calendar.CalendarEventDto;

import java.util.Collection;
import java.util.List;

/**
 * Created by hao huang on 14/09/2016.
 */
public interface CalendarEventService {

    List<CalendarEventDto> findAllCalendarEvents();

    void saveCalendarEvent(CalendarEventDto calendarEventDto);

    void deleteCalendarEventById(String id);

    CalendarEventDto findCalendarEventById(String id);

    void deleteAllInBatch();

}
