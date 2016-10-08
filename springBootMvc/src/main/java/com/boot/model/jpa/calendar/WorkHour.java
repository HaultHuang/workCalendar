package main.java.com.boot.model.jpa.calendar;

import main.java.com.boot.model.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by hao huang on 19/09/2016.
 */
@Entity
@Table(name = "WORK_HOUR")
public class WorkHour extends BaseEntity {

    @Column(name = "SHIFT_ID")
    private Long shiftId;

    @Column(name = "START_TIME")
    @Temporal(value = TemporalType.TIME)
    private Date startTime;

    @Column(name = "END_TIME")
    @Temporal(value = TemporalType.TIME)
    private Date endTime;

    @Column(name="`ORDER`")
    private int order;

    public Long getShiftId() {
        return shiftId;
    }

    public void setShiftId(Long shiftId) {
        this.shiftId = shiftId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
