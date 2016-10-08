package main.java.com.boot.controller;

import main.java.com.boot.common.Constants;
import main.java.com.boot.dto.calendar.CalendarEventDto;
import main.java.com.boot.dto.calendar.CalendarEventDto;
import main.java.com.boot.service.calendar.CalendarEventService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Created by hao huang on 18/09/2016.
 */
@Controller
@RequestMapping("calendarEvent")
public class CalendarEventController {

    @Resource
    private CalendarEventService calendarEventService;

    @RequestMapping
    public String setUpForm(){
        return "calendarEvent";
    }

    @RequestMapping("/loadCalendarEventAjax")
    public @ResponseBody String loadCalendarEvent(Model model){
        JSONObject obj = new JSONObject();
        JSONArray array = new JSONArray();
        Collection<CalendarEventDto> calendarEventDtos = calendarEventService.findAllCalendarEvents();
        for (CalendarEventDto dto : calendarEventDtos) {
            JSONObject object = new JSONObject();
            object.put("id", dto.getId());
            object.put("title", dto.getTitle());
            object.put("start", dto.getStart());
            object.put("end", dto.getEnd());
            object.put("color", dto.getColor());
            object.put("textColor",dto.getTextColor());
            object.put("allDay", dto.getAllDay());
            array.add(object);
        }
        obj.put(Constants.DATA_TABLE_DRAW, 1);
        obj.put(Constants.DATA_TABLE_RECORDS_TOTAL, calendarEventDtos.size());
        obj.put(Constants.DATA_TABLE_RECORDS_FILTERED, calendarEventDtos.size());
        obj.put(Constants.DATA_TABLE_DATA, array);
        return obj.toString();
    }

    @RequestMapping(value = "/saveCalendarEvent", method = RequestMethod.POST)
    public String saveCalendarEvent(@ModelAttribute("calendarEvent") CalendarEventDto calendarEventDto, BindingResult result) {
        if (result.hasErrors()) {
        }
        calendarEventService.saveCalendarEvent(calendarEventDto);
        return "redirect:/calendarEvent";
    }

    @RequestMapping(value = "/deleteCalendarEvent", method = RequestMethod.POST)
    public String deleteCalendarEvent(@RequestParam("ids") Collection<String> ids) {
        for (String id : ids) {
            calendarEventService.deleteCalendarEventById(id);
        }
        return "redirect:/calendarEvent";
    }

    @RequestMapping("/createCalendarEvent")
    public String createCalendarEvent(Model model){
        model.addAttribute("calendarEvent", new CalendarEventDto());
        return "saveCalendarEventDialog";
    }

    @RequestMapping("/updateCalendarEvent")
    public String updateCalendarEvent(Model model, @RequestParam("id") String id){
        model.addAttribute("calendarEvent", calendarEventService.findCalendarEventById(id));
        return "saveCalendarEventDialog";
    }
}
