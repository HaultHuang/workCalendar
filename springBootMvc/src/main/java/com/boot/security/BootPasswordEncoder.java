package main.java.com.boot.security;

import main.java.com.boot.common.Constants;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by hao huang on 20/07/2016.
 */
@Service
public class BootPasswordEncoder extends BCryptPasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return super.encode(rawPassword+ Constants.SECURITY_SALT);
    }
}
