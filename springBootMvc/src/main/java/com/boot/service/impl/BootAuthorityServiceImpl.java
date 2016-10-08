package main.java.com.boot.service.impl;

import main.java.com.boot.model.jpa.BootAuthority;
import main.java.com.boot.repository.jpa.BootAuthorityRepository;
import main.java.com.boot.service.BootAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by hao huang on 20/07/2016.
 */
@Service
public class BootAuthorityServiceImpl implements BootAuthorityService {

    @Autowired
    private BootAuthorityRepository bootAuthorityRepository;

    @Override
    public Collection<BootAuthority> findByUserId(Long userId) {
        return bootAuthorityRepository.findByUserId(userId);
    }
}
