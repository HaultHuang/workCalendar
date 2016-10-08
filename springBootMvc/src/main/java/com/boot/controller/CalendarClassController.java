package main.java.com.boot.controller;

import main.java.com.boot.common.Constants;
import main.java.com.boot.dto.calendar.CalendarClassDto;
import main.java.com.boot.dto.calendar.CalendarClassDto;
import main.java.com.boot.service.calendar.CalendarClassService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Created by hao huang on 19/09/2016.
 */
@Controller
@RequestMapping("calendarClass")
public class CalendarClassController {

    @Resource
    private CalendarClassService calendarClassService;

    @RequestMapping
    public String setUpForm(){
        return "calendarClass";
    }

    @RequestMapping("loadCalendarClassAjax")
    public @ResponseBody String loadCalendarClass(){
        JSONObject obj = new JSONObject();
        JSONArray array = new JSONArray();
        Collection<CalendarClassDto> calendarClassDtos = calendarClassService.findAllCalendarClasses();
        for (CalendarClassDto dto : calendarClassDtos) {
            JSONObject object = new JSONObject();
            object.put("id", dto.getId());
            object.put("code", dto.getCode());
            object.put("name", dto.getName());
            array.add(object);
        }
        obj.put(Constants.DATA_TABLE_DRAW, 1);
        obj.put(Constants.DATA_TABLE_RECORDS_TOTAL, calendarClassDtos.size());
        obj.put(Constants.DATA_TABLE_RECORDS_FILTERED, calendarClassDtos.size());
        obj.put(Constants.DATA_TABLE_DATA, array);
        return obj.toString();
    }


    @RequestMapping(value = "/saveCalendarClass", method = RequestMethod.POST)
    public String saveCalendarClass(@ModelAttribute("calendarClass") CalendarClassDto calendarClassDto, BindingResult result) {
        if (result.hasErrors()) {
        }
        calendarClassService.saveCalendarClass(calendarClassDto);
        return "redirect:/calendarClass";
    }

    @RequestMapping(value = "/deleteCalendarClass", method = RequestMethod.POST)
    public String deleteCalendarClass(@RequestParam("ids") Collection<String> ids) {
        for (String id : ids) {
            calendarClassService.deleteCalendarClassById(id);
        }
        return "redirect:/calendarClass";
    }

    @RequestMapping("/createCalendarClass")
    public String createCalendarClass(Model model){
        model.addAttribute("calendarClass", new CalendarClassDto());
        return "saveCalendarClassDialog";
    }

    @RequestMapping("/updateCalendarClass")
    public String updateCalendarClass(Model model, @RequestParam("id") String id){
        model.addAttribute("calendarClass", calendarClassService.findCalendarClassById(id));
        return "saveCalendarClassDialog";
    }

    @RequestMapping("/addEmployeeDialog")
    public String addEmployeeDetail(){
        return "addEmployeeDialog";
    }
}
