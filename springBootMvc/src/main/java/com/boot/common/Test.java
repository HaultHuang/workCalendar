package main.java.com.boot.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by hao huang on 19/07/2016.
 */
public class Test {
    public static void main(String[] args) {
        String a = new BCryptPasswordEncoder().encode("user");
        System.out.printf(a);
    }
}
