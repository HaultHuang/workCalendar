package main.java.com.boot.service.calendar.impl;

import ma.glasnost.orika.MapperFacade;
import main.java.com.boot.dto.calendar.CalendarEventDto;
import main.java.com.boot.model.jpa.calendar.CalendarEvent;
import main.java.com.boot.repository.jpa.calendar.CalendarEventRepository;
import main.java.com.boot.service.calendar.CalendarEventService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * Created by hao huang on 14/09/2016.
 */
@Service
@Transactional
public class CalendarEventServiceImpl implements CalendarEventService {

    @Resource
    private MapperFacade mapperFacade;

    @Resource
    private CalendarEventRepository calendarEventRepository;

    @Override
    public List<CalendarEventDto> findAllCalendarEvents() {
        return mapperFacade.mapAsList(calendarEventRepository.findAll(), CalendarEventDto.class);
    }

    @Override
    public void saveCalendarEvent(CalendarEventDto calendarEventDto) {
        calendarEventRepository.save(mapperFacade.map(calendarEventDto, CalendarEvent.class));
    }

    @Override
    public void deleteCalendarEventById(String id) {
        calendarEventRepository.delete(Long.valueOf(id));
    }

    @Override
    public CalendarEventDto findCalendarEventById(String id) {
        return mapperFacade.map(calendarEventRepository.findOne(Long.valueOf(id)), CalendarEventDto.class);
    }

    @Override
    public void deleteAllInBatch() {
        calendarEventRepository.deleteAllInBatch();
    }
}
