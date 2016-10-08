package main.java.com.boot.repository.jpa.calendar;

import main.java.com.boot.model.jpa.calendar.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hao huang on 19/09/2016.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
}
