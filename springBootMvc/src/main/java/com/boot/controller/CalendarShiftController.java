package main.java.com.boot.controller;

import main.java.com.boot.common.Constants;
import main.java.com.boot.dto.calendar.CalendarShiftDto;
import main.java.com.boot.dto.calendar.WorkHourDto;
import main.java.com.boot.service.calendar.CalendarShiftService;
import main.java.com.boot.service.calendar.WorkHourService;
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
@RequestMapping("calendarShift")
public class CalendarShiftController {

    @Resource
    private CalendarShiftService calendarShiftService;

    @RequestMapping
    public String setUpForm() {
        return "calendarShift";
    }

    @RequestMapping("loadCalendarShiftAjax")
    public
    @ResponseBody
    String loadCalendarShift() {
        JSONObject obj = new JSONObject();
        JSONArray array = new JSONArray();
        Collection<CalendarShiftDto> calendarShiftDtos = calendarShiftService.findAllCalendarShifts();
        for (CalendarShiftDto dto : calendarShiftDtos) {
            JSONObject object = new JSONObject();
            object.put("id", dto.getId());
            object.put("code", dto.getCode());
            object.put("name", dto.getName());
            array.add(object);
        }
        obj.put(Constants.DATA_TABLE_DRAW, 1);
        obj.put(Constants.DATA_TABLE_RECORDS_TOTAL, calendarShiftDtos.size());
        obj.put(Constants.DATA_TABLE_RECORDS_FILTERED, calendarShiftDtos.size());
        obj.put(Constants.DATA_TABLE_DATA, array);
        return obj.toString();
    }


    @RequestMapping(value = "/saveCalendarShift", method = RequestMethod.POST)
    public String saveCalendarShift(@ModelAttribute("calendarShift") CalendarShiftDto calendarShiftDto, BindingResult result) {
        if (result.hasErrors()) {
        }
        calendarShiftService.saveCalendarShift(calendarShiftDto);
        return "redirect:/calendarShift";
    }

    @RequestMapping(value = "/deleteCalendarShift", method = RequestMethod.POST)
    public String deleteCalendarShift(@RequestParam("ids") Collection<String> ids) {
        for (String id : ids) {
            calendarShiftService.deleteCalendarShiftById(id);
        }
        return "redirect:/calendarShift";
    }

    @RequestMapping("/createCalendarShift")
    public String createCalendarShift(Model model) {
        model.addAttribute("calendarShift", new CalendarShiftDto());
        return "saveCalendarShiftDialog";
    }

    @RequestMapping("/updateCalendarShift")
    public String updateCalendarShift(Model model, @RequestParam("id") String id) {
        model.addAttribute("calendarShift", calendarShiftService.findCalendarShiftById(id));
        return "saveCalendarShiftDialog";
    }

}
