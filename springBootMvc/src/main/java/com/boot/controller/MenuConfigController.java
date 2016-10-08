package main.java.com.boot.controller;

import main.java.com.boot.dto.MenuDto;
import main.java.com.boot.model.jpa.Menu;
import main.java.com.boot.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * Created by hao huang on 13/07/2016.
 */
@Controller
public class MenuConfigController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/menuConfig")
    public String loadMenusTable(Model model){
        Collection<MenuDto> menus = menuService.findAllMenus();
        model.addAttribute("menus",menus);
        return "menuConfig";
    }
}
