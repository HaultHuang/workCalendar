package main.java.com.boot.service;

import main.java.com.boot.excpetion.BootServiceException;
import main.java.com.boot.model.jpa.User;

import java.util.Collection;

/**
 * Created by hao huang on 29/06/2016.
 */
public interface UserService {

    User findUserById(Long id) throws BootServiceException;

    Collection<User> findUsersByName(String name) throws BootServiceException;

    Collection<User> findUsersLikeName(String name) throws BootServiceException;

    Collection<User> findAllUser()throws BootServiceException;
}
