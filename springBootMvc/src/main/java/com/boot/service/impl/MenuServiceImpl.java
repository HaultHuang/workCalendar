package main.java.com.boot.service.impl;

import ma.glasnost.orika.MapperFacade;
import main.java.com.boot.dto.MenuDto;
import main.java.com.boot.model.jpa.Menu;
import main.java.com.boot.repository.jpa.MenuRepository;
import main.java.com.boot.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Created by hao huang on 13/07/2016.
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuRepository menuRepository;

    @Resource
    private MapperFacade mapperFacade;

    @Override
    public Collection<MenuDto> findAllMenus() {
        Collection<Menu> menus = menuRepository.findAll();
        // when use orika and jpa, spring-devtools.properties should be added.
        // otherwise, there would be an error: main.java.com.boot.model.jpa.Menu can not be cast to main.java.com.boot.model.jpa.Menu
        return mapperFacade.mapAsList(menus, MenuDto.class);
    }

    @Override
    public Collection<MenuDto> findAllActiveMenus() {
        return mapperFacade.mapAsList(menuRepository.findByFlagActive(true),MenuDto.class);
    }
}
