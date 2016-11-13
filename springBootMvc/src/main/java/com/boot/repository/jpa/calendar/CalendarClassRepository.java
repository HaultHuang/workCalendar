package main.java.com.boot.repository.jpa.calendar;

import main.java.com.boot.model.jpa.calendar.CalendarClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hao huang on 19/09/2016.
 */
@Repository
public interface CalendarClassRepository extends JpaRepository<CalendarClass,Long> {

    CalendarClass findByCode(String code);
}
