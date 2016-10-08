package main.java.com.boot.model.jpa.calendar;

import main.java.com.boot.model.BaseEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by hao huang on 14/09/2016.
 */
@Entity
@Table(name="CALENDAR_EVENT")
public class CalendarEvent extends BaseEntity {

    @Column(name="TITLE")
    private String title;

    @Column(name="START")
    private String start;

    @Column(name="END")
    private String end;

    @Column(name="COLOR")
    private String color;

    @Column(name="TEXT_COLOR")
    private String textColor;

    @Column(name="ALL_DAY")
    @Type(type = "yes_no")
    private Boolean allDay;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "CALENDAR_EVENT_ID", referencedColumnName = "ID")
    private Collection<CalendarResource> calendarResources;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Collection<CalendarResource> getCalendarResources() {
        return calendarResources;
    }

    public void setCalendarResources(Collection<CalendarResource> calendarResources) {
        this.calendarResources = calendarResources;
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
