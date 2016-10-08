package main.java.com.boot.dto.calendar;

import main.java.com.boot.dto.BaseDto;

/**
 * Created by hao huang on 14/09/2016.
 */
public class BusinessHourDto extends BaseDto{

    private String code;

    private String name;

    private String start;

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
}
