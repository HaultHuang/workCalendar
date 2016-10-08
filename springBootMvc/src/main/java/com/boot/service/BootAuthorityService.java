package main.java.com.boot.service;

import main.java.com.boot.model.jpa.BootAuthority;

import java.util.Collection;

/**
 * Created by hao huang on 20/07/2016.
 */
public interface BootAuthorityService {

    Collection<BootAuthority> findByUserId(Long userId);
}
