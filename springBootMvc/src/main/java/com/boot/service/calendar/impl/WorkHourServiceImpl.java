package main.java.com.boot.service.calendar.impl;

import ma.glasnost.orika.MapperFacade;
import main.java.com.boot.dto.calendar.WorkHourDto;
import main.java.com.boot.repository.jpa.calendar.WorkHourRepository;
import main.java.com.boot.service.calendar.WorkHourService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Created by hao huang on 22/09/2016.
 */
@Service
@Transactional
public class WorkHourServiceImpl implements WorkHourService {

    @Resource
    private WorkHourRepository workHourRepository;

    @Resource
    private MapperFacade mapperFacade;

    @Override
    public Collection<WorkHourDto> findAllWorkHourByShiftId(String shiftId) {
        return mapperFacade.mapAsList(workHourRepository.findByShiftId(Long.valueOf(shiftId)),WorkHourDto.class);
    }
}
