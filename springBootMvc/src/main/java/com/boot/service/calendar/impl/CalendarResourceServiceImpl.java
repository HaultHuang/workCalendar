package main.java.com.boot.service.calendar.impl;

import ma.glasnost.orika.MapperFacade;
import main.java.com.boot.dto.calendar.CalendarResourceDto;
import main.java.com.boot.repository.jpa.calendar.CalendarResourceRepository;
import main.java.com.boot.service.calendar.CalendarResourceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hao huang on 14/09/2016.
 */
@Service
@Transactional
public class CalendarResourceServiceImpl implements CalendarResourceService{

    @Resource
    private CalendarResourceRepository calendarResourceRepository;

    @Resource
    private MapperFacade mapperFacade;

    @Override
    public List<CalendarResourceDto> findAllCalendarResources() {
        return mapperFacade.mapAsList(calendarResourceRepository.findAll(),CalendarResourceDto.class);
    }
}
