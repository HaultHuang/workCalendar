package main.java.com.boot.controller;

import main.java.com.boot.dto.calendar.CalendarEventDto;
import main.java.com.boot.dto.calendar.CalendarResourceDto;
import main.java.com.boot.service.calendar.*;
import main.java.com.boot.service.calendar.impl.WorkCalendarServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by hao huang on 14/09/2016.
 */
@Controller
public class WorkCalendarController {

    @Resource
    private CalendarResourceService calendarResourceService;

    @Resource
    private CalendarEventService calendarEventService;

    @Resource
    private CalendarClassService calendarClassService;

    @Resource
    private CalendarShiftService calendarShiftService;

    @Resource
    private WorkCalendarService workCalendarService;

    @RequestMapping("workCalendar")
    public String loadWorkCalendar(Model model) {
        model.addAttribute("calendarClasses",calendarClassService.findAllCalendarClasses());
        model.addAttribute("calendarShifts",calendarShiftService.findAllCalendarShifts());
        return "workCalendar";
    }

    @RequestMapping("loadResource")
    public
    @ResponseBody
    List<CalendarResourceDto> loadResource() {
        return calendarResourceService.findAllCalendarResources();
    }

    @RequestMapping("loadEvent")
    public
    @ResponseBody
    List<CalendarEventDto> loadEvent() {
        return calendarEventService.findAllCalendarEvents();
    }

    @RequestMapping("generate")
    public String generate(String idShift,String idClass,Date startDate,Date endDate){
        workCalendarService.generate(idShift,idClass,startDate,endDate);
        return "redirect:/workCalendar";
    }
}
