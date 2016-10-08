package main.java.com.boot.repository.jpa;

import main.java.com.boot.model.jpa.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by hao huang on 29/06/2016.
 */
public interface UserRepository extends JpaRepository<User,Long> {

    Collection<User> findByName(String name);

    @Query(value = "from User where name like %?1%")
    Collection<User> findLikeName(String name);

    Collection<User> findByCode(String code);
}
