package main.java.com.boot.repository.jpa.calendar;

import main.java.com.boot.model.jpa.calendar.WorkHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by hao huang on 19/09/2016.
 */
@Repository
public interface WorkHourRepository extends JpaRepository<WorkHour,Long> {

    Collection<WorkHour> findByShiftId(Long shiftId);

}
