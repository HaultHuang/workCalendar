package main.java.com.boot.repository.jpa.calendar;

import main.java.com.boot.model.jpa.calendar.CalendarEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hao huang on 14/09/2016.
 */
@Repository
public interface CalendarEventRepository extends JpaRepository<CalendarEvent,Long>{
}
