package main.java.com.boot.service.impl;

import main.java.com.boot.constants.Constants;
import main.java.com.boot.repository.jpa.UserRepository;
import main.java.com.boot.excpetion.BootServiceException;
import main.java.com.boot.model.jpa.User;
import main.java.com.boot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Created by hao huang on 29/06/2016.
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserRepository userRepository;

    @Override
    public User findUserById(Long id) throws BootServiceException {
        try {
            return userRepository.findOne(id);
        } catch (Exception e) {
            LOGGER.error(Constants.SERVICE_ERROR_MSG, e);
            throw new BootServiceException(e);
        }
    }

    @Override
    public Collection<User> findUsersByName(String name) throws BootServiceException {
        try {
            return userRepository.findByName(name);
        } catch (Exception e) {
            LOGGER.error(Constants.SERVICE_ERROR_MSG, e);
            throw new BootServiceException(e);
        }
    }

    @Override
    public Collection<User> findUsersLikeName(String name) throws BootServiceException {
        try {
            return userRepository.findLikeName(name);
        } catch (Exception e) {
            LOGGER.error(Constants.SERVICE_ERROR_MSG, e);
            throw new BootServiceException(e);
        }
    }

    @Override
    public Collection<User> findAllUser() throws BootServiceException {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            LOGGER.error(Constants.SERVICE_ERROR_MSG, e);
            throw new BootServiceException(e);
        }
    }
}
