package main.java.com.boot.repository.jpa.calendar;

import main.java.com.boot.model.jpa.calendar.BusinessHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by hao huang on 14/09/2016.
 */
@Repository
public interface BusinessHourRepository extends JpaRepository<BusinessHour,Long>{
}
