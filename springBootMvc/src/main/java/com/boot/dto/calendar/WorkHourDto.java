package main.java.com.boot.dto.calendar;

import main.java.com.boot.dto.BaseDto;

/**
 * Created by hao huang on 19/09/2016.
 */
public class WorkHourDto extends BaseDto {

    private String shiftId;

    private String startTime;

    private String endTime;

    private String order;

    public String getShiftId() {
        return shiftId;
    }

    public void setShiftId(String shiftId) {
        this.shiftId = shiftId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
