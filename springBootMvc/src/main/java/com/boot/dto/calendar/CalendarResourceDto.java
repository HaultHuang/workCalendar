package main.java.com.boot.dto.calendar;

import main.java.com.boot.dto.BaseDto;

/**
 * Created by hao huang on 14/09/2016.
 */
public class CalendarResourceDto extends BaseDto{

    private String title;

    private BusinessHourDto businessHours;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BusinessHourDto getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(BusinessHourDto businessHours) {
        this.businessHours = businessHours;
    }
}
