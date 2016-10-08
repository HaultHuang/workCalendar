package main.java.com.boot.interceptor;

import main.java.com.boot.dto.MenuDto;
import main.java.com.boot.model.jpa.Menu;
import main.java.com.boot.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

/**
 * Created by hao huang on 05/07/2016.
 */
@Service
public class ThymeleafLayoutInterceptor extends HandlerInterceptorAdapter {

    private static final String DEFAULT_LAYOUT = "layouts/default";

    private static final String DEFAULT_VIEW_ATTRIBUTE_NAME = "view";

    @Autowired
    private MenuService menuService;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView == null || !modelAndView.hasView()) {
            return;
        }
        String originalViewName = modelAndView.getViewName();
        if(isAjaxMethod(originalViewName) || isDialog(originalViewName)){
            return;
        }
        Collection<MenuDto> menuDtos = menuService.findAllActiveMenus();
        modelAndView.addObject("menus",menuDtos);
        modelAndView.addObject("activeUrl",originalViewName);
        if (isRedirectOrForward(originalViewName)) {
            return;
        }
        modelAndView.setViewName(DEFAULT_LAYOUT);
        modelAndView.addObject(DEFAULT_VIEW_ATTRIBUTE_NAME,originalViewName);
    }

    private boolean isRedirectOrForward(String viewName) {
        return viewName.startsWith("redirect:") || viewName.startsWith("forward:");
    }

    private boolean isAjaxMethod(String viewName){
        return viewName.startsWith("ajax") || viewName.endsWith("Ajax");
    }

    private boolean isDialog(String viewName){
        return viewName.startsWith("dialog") || viewName.endsWith("Dialog");
    }
}
