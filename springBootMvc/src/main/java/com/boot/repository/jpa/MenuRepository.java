package main.java.com.boot.repository.jpa;

import main.java.com.boot.model.jpa.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * Created by hao huang on 13/07/2016.
 */

public interface MenuRepository extends JpaRepository<Menu,Long> {

    Collection<Menu> findByFlagActive(boolean flagActive);
}
