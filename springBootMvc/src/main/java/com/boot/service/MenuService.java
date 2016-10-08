package main.java.com.boot.service;

import main.java.com.boot.dto.MenuDto;
import main.java.com.boot.model.jpa.Menu;

import java.util.Collection;

/**
 * Created by hao huang on 13/07/2016.
 */
public interface MenuService {

    Collection<MenuDto> findAllMenus();

    Collection<MenuDto> findAllActiveMenus();
}
