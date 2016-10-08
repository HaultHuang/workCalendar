package main.java.com.boot.conifg;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import main.java.com.boot.converter.EntitiesToArrayConverter;
import main.java.com.boot.converter.OrikaDateConverter;
import main.java.com.boot.dto.*;
import main.java.com.boot.dto.calendar.*;
import main.java.com.boot.interceptor.ThymeleafLayoutInterceptor;
import main.java.com.boot.model.jpa.Menu;
import main.java.com.boot.model.jpa.SubMenu;
import main.java.com.boot.model.jpa.calendar.*;
import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.resource.*;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import java.util.*;

/**
 * Created by hao huang on 05/07/2016.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Autowired
    private ThymeleafLayoutInterceptor thymeleafLayoutInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(thymeleafLayoutInterceptor);
    }

    @Bean
    public ServletContextTemplateResolver templateResolver() {
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
        resolver.setPrefix("/templates/views/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");
        resolver.setCharacterEncoding("UTF-8");
        resolver.setOrder(1);
        return resolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        Set<IDialect> dialects = new HashSet<>();
        dialects.add(new LayoutDialect());
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver());
        engine.setAdditionalDialects(dialects);
        return engine;
    }

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        resolver.setViewNames(new String[]{"*"});
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }

    @Bean
    public SimpleUrlHandlerMapping simpleUrlHandlerMapping() {
        SimpleUrlHandlerMapping simpleUrlHandlerMapping = new SimpleUrlHandlerMapping();
        Map<String, Object> map = new LinkedHashMap<>();
        ResourceHttpRequestHandler resourceHttpRequestHandler = new ResourceHttpRequestHandler();
        List<Resource> locations = new ArrayList<>();
        locations.add(new ServletContextResource(getServletContext(), "/"));
        locations.add(new ClassPathResource("META-INF/resources"));
        locations.add(new ClassPathResource("resources/"));
        locations.add(new ClassPathResource("static/"));
        locations.add(new ClassPathResource("public/"));
        resourceHttpRequestHandler.setLocations(locations);
        resourceHttpRequestHandler.setApplicationContext(getApplicationContext());

        List<ResourceResolver> resourceResolvers = new ArrayList<>();
        PathResourceResolver resourceResolver = new PathResourceResolver();
        resourceResolver.setAllowedLocations(new ServletContextResource(getServletContext(), "/"), new ClassPathResource("META-INF/resources"), new ClassPathResource("resources/"), new ClassPathResource("static/"), new ClassPathResource("public/"));
        resourceResolvers.add(resourceResolver);

        resourceHttpRequestHandler.setResourceResolvers(resourceResolvers);
        map.put("/**", resourceHttpRequestHandler);
        simpleUrlHandlerMapping.setUrlMap(map);
        ResourceUrlProvider resourceUrlProvider = new ResourceUrlProvider();
        Map<String, ResourceHttpRequestHandler> handlerMap = new LinkedHashMap<>();
        handlerMap.put("/**", resourceHttpRequestHandler);
        resourceUrlProvider.setHandlerMap(handlerMap);
        ResourceUrlProviderExposingInterceptor interceptor = new ResourceUrlProviderExposingInterceptor(resourceUrlProvider);
        simpleUrlHandlerMapping.setInterceptors(new Object[]{interceptor});
        return simpleUrlHandlerMapping;
    }

    @Bean
    public MapperFacade mapperFacade() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(Menu.class, MenuDto.class).field("subMenus", "subMenuDtos").byDefault().register();
        mapperFactory.classMap(SubMenu.class, SubMenuDto.class).byDefault().register();
        mapperFactory.classMap(CalendarEvent.class,CalendarEventDto.class).field("calendarResources","resourceIds").byDefault().register();
        mapperFactory.classMap(CalendarResource.class,CalendarResourceDto.class).byDefault().register();
        mapperFactory.classMap(BusinessHour.class,BusinessHourDto.class).byDefault().register();
        mapperFactory.classMap(CalendarClass.class,CalendarClassDto.class).field("employees","employeeDtos").byDefault().register();
        mapperFactory.classMap(CalendarShift.class,CalendarShiftDto.class).field("workHours","workHourDtos").byDefault().register();
        mapperFactory.classMap(WorkHour.class,WorkHourDto.class).byDefault().register();
        mapperFactory.classMap(Employee.class,EmployeeDto.class).byDefault().register();
        mapperFactory.getConverterFactory().registerConverter(new OrikaDateConverter());
        mapperFactory.getConverterFactory().registerConverter(new EntitiesToArrayConverter());
        return mapperFactory.getMapperFacade();
    }
}
