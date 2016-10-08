package main.java.com.boot.model.jpa.calendar;

import main.java.com.boot.model.BaseEntity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by hao huang on 19/09/2016.
 */
@Entity
@Table(name="CALENDAR_SHIFT")
public class CalendarShift extends BaseEntity{

    @Column(name="CODE")
    private String code;

    @Column(name="NAME")
    private String name;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="SHIFT_ID",referencedColumnName = "ID")
    private Collection<WorkHour> workHours;

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

    public Collection<WorkHour> getWorkHours() {
        return workHours;
    }

    public void setWorkHours(Collection<WorkHour> workHours) {
        this.workHours = workHours;
    }
}
