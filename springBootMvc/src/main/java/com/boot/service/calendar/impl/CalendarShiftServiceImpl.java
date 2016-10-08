package main.java.com.boot.service.calendar.impl;

import ma.glasnost.orika.MapperFacade;
import main.java.com.boot.dto.calendar.CalendarShiftDto;
import main.java.com.boot.model.jpa.calendar.CalendarShift;
import main.java.com.boot.model.jpa.calendar.WorkHour;
import main.java.com.boot.repository.jpa.calendar.CalendarShiftRepository;
import main.java.com.boot.repository.jpa.calendar.WorkHourRepository;
import main.java.com.boot.service.calendar.CalendarShiftService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Created by hao huang on 19/09/2016.
 */
@Service
@Transactional
public class CalendarShiftServiceImpl implements CalendarShiftService {

    @Resource
    private MapperFacade mapperFacade;

    @Resource
    private CalendarShiftRepository calendarShiftRepository;


    @Override
    public Collection<CalendarShiftDto> findAllCalendarShifts() {
        return mapperFacade.mapAsList(calendarShiftRepository.findAll(), CalendarShiftDto.class);
    }

    @Override
    public void saveCalendarShift(CalendarShiftDto calendarShiftDto) {
        CalendarShift calendarShift = mapperFacade.map(calendarShiftDto, CalendarShift.class);
        calendarShiftRepository.save(calendarShift);
    }

    @Override
    public void deleteCalendarShiftById(String id) {
        calendarShiftRepository.delete(Long.valueOf(id));
    }

    @Override
    public CalendarShiftDto findCalendarShiftById(String id) {
        return mapperFacade.map(calendarShiftRepository.findOne(Long.valueOf(id)),CalendarShiftDto.class);
    }
}
