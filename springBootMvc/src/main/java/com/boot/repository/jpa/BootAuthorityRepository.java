package main.java.com.boot.repository.jpa;

import main.java.com.boot.model.jpa.BootAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by hao huang on 20/07/2016.
 */
@Repository
public interface BootAuthorityRepository extends JpaRepository<BootAuthority,Long>{

    Collection<BootAuthority> findByUserId(Long userId);
}
