package main.java.com.boot.dto.calendar;

import main.java.com.boot.dto.BaseDto;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by hao huang on 19/09/2016.
 */
public class CalendarShiftDto extends BaseDto {

    private String code;

    private String name;

    private Collection<WorkHourDto> workHourDtos = new ArrayList<>();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<WorkHourDto> getWorkHourDtos() {
        return workHourDtos;
    }

    public void setWorkHourDtos(Collection<WorkHourDto> workHourDtos) {
        this.workHourDtos = workHourDtos;
    }
}
