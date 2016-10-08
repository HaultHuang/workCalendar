package main.java.com.boot.model.jpa.calendar;

import main.java.com.boot.model.BaseEntity;

import javax.persistence.*;

/**
 * Created by hao huang on 14/09/2016.
 */
@Entity
@Table(name="CALENDAR_RESOURCE")
public class CalendarResource extends BaseEntity {

    @Column(name="TITLE")
    private String title;

    @Column(name="CALENDAR_EVENT_ID")
    private Long calendarEventId;

    @OneToOne
    @JoinColumn(name="BUSINESS_HOURS_ID")
    private BusinessHour businessHours;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCalendarEventId() {
        return calendarEventId;
    }

    public void setCalendarEventId(Long calendarEventId) {
        this.calendarEventId = calendarEventId;
    }

    public BusinessHour getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(BusinessHour businessHours) {
        this.businessHours = businessHours;
    }
}
