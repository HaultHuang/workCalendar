package main.java.com.boot.dto.calendar;

import main.java.com.boot.dto.BaseDto;

/**
 * Created by hao huang on 14/09/2016.
 */
public class CalendarEventDto extends BaseDto{

    private String title;

    private String[] resourceIds;

    private String start;

    private String end;

    private String color;

    private String textColor;

    private Boolean allDay;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String[] resourceIds) {
        this.resourceIds = resourceIds;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public Boolean getAllDay() {
        return allDay;
    }

    public void setAllDay(Boolean allDay) {
        this.allDay = allDay;
    }
}
