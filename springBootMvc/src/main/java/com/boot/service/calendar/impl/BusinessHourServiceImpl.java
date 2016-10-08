package main.java.com.boot.service.calendar.impl;

import ma.glasnost.orika.MapperFacade;
import main.java.com.boot.dto.calendar.BusinessHourDto;
import main.java.com.boot.repository.jpa.calendar.BusinessHourRepository;
import main.java.com.boot.service.calendar.BusinessHourService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Created by hao huang on 18/09/2016.
 */
@Service
@Transactional
public class BusinessHourServiceImpl implements BusinessHourService {

    @Resource
    private BusinessHourRepository businessHourRepository;

    @Resource
    private MapperFacade mapperFacade;

    @Override
    public Collection<BusinessHourDto> findAllBusinessHours() {
        return mapperFacade.mapAsList(businessHourRepository.findAll(), BusinessHourDto.class);
    }
}
