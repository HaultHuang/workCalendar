package main.java.com.boot.service.calendar;

import main.java.com.boot.dto.calendar.CalendarResourceDto;

import java.util.List;

/**
 * Created by hao huang on 14/09/2016.
 */
public interface CalendarResourceService {

    List<CalendarResourceDto> findAllCalendarResources();
}
