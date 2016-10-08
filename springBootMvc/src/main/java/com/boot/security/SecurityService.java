package main.java.com.boot.security;

import main.java.com.boot.model.jpa.BootAuthority;
import main.java.com.boot.repository.jpa.BootAuthorityRepository;
import main.java.com.boot.repository.jpa.UserRepository;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by hao huang on 19/07/2016.
 */
@Service
public class SecurityService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BootAuthorityRepository bootAuthorityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        Collection<main.java.com.boot.model.jpa.User> users = userRepository.findByCode(username);

        if (CollectionUtils.isEmpty(users)) {
            return null;
        }
        main.java.com.boot.model.jpa.User user = users.iterator().next();

        Collection<BootAuthority> bootAuthorities = bootAuthorityRepository.findByUserId(user.getId());

        bootAuthorities.stream().map(a -> a.getAuthority()).forEach(a -> authorities.add(new SimpleGrantedAuthority(a)));

        return new User(username, user.getPassword(), authorities);
    }
}
