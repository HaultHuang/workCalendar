package main.java.com.boot.service.calendar;

import main.java.com.boot.dto.calendar.WorkHourDto;

import java.util.Collection;

/**
 * Created by hao huang on 22/09/2016.
 */
public interface WorkHourService {

    Collection<WorkHourDto> findAllWorkHourByShiftId(String shiftId);
}
