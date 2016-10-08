package main.java.com.boot.model.jpa.calendar;

import main.java.com.boot.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by hao huang on 14/09/2016.
 */
@Entity
@Table(name="BUSINESS_HOUR")
public class BusinessHour extends BaseEntity{

    @Column(name="CALENDAR_SHIFT_ID")
    private Long calendarShiftId;

    @Column(name="CODE")
    private String code;

    @Column(name="NAME")
    private String name;

    @Column(name="START")
    private String start;

    @Column(name="END")
    private String end;

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

    public Long getCalendarShiftId() {
        return calendarShiftId;
    }

    public void setCalendarShiftId(Long calendarShiftId) {
        this.calendarShiftId = calendarShiftId;
    }
}
