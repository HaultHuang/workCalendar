package main.java.com.boot.controller;

import main.java.com.boot.common.Constants;
import main.java.com.boot.dto.calendar.EmployeeDto;
import main.java.com.boot.service.calendar.CalendarEmployeeService;
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
@RequestMapping("employee")
public class EmployeeController {

    @Resource
    private CalendarEmployeeService calendarEmployeeService;


    @RequestMapping
    public String setUpForm() {
        return "employee";
    }

    @RequestMapping("/loadEmployeeAjax")
    public
    @ResponseBody
    String loadEmployee() {
        JSONObject obj = new JSONObject();
        JSONArray array = new JSONArray();
        Collection<EmployeeDto> employeeDtos = calendarEmployeeService.findAllEmployees();
        for (EmployeeDto dto : employeeDtos) {
            JSONObject object = new JSONObject();
            object.put("id", dto.getId());
            object.put("code", dto.getCode());
            object.put("name", dto.getName());
            object.put("age", dto.getAge());
            object.put("sex", dto.getSex());
            object.put("description", dto.getDescription());
            array.add(object);
        }
        obj.put(Constants.DATA_TABLE_DRAW, 1);
        obj.put(Constants.DATA_TABLE_RECORDS_TOTAL, employeeDtos.size());
        obj.put(Constants.DATA_TABLE_RECORDS_FILTERED, employeeDtos.size());
        obj.put(Constants.DATA_TABLE_DATA, array);
        return obj.toString();
    }

    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("employee") EmployeeDto employeeDto, BindingResult result) {
        if (result.hasErrors()) {
        }
        calendarEmployeeService.saveEmployee(employeeDto);
        return "redirect:/employee";
    }

    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
    public String deleteEmployee(@RequestParam("ids") Collection<String> ids) {
        for (String id : ids) {
            calendarEmployeeService.deleteEmployeeById(id);
        }
        return "redirect:/employee";
    }

    @RequestMapping("/createEmployee")
    public String createEmployee(Model model){
        model.addAttribute("employee", new EmployeeDto());
        return "saveEmployeeDialog";
    }

    @RequestMapping("/updateEmployee")
    public String updateEmployee(Model model, @RequestParam("id") String id){
        model.addAttribute("employee", calendarEmployeeService.findEmployeeById(id));
        return "saveEmployeeDialog";
    }
}
