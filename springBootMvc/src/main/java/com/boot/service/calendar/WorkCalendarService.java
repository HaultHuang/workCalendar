package main.java.com.boot.service.calendar;

import java.util.Date;

/**
 * Created by Hao on 2016/11/12.
 */
public interface WorkCalendarService {

    void generate(String idShift, String idClass, Date startDate, Date endDate);
}
