package main.java.com.boot.service.calendar;

import main.java.com.boot.dto.calendar.BusinessHourDto;

import java.util.Collection;

/**
 * Created by hao huang on 18/09/2016.
 */
public interface BusinessHourService {

    Collection<BusinessHourDto> findAllBusinessHours();
}
