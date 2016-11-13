package main.java.com.boot.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * Created by hao huang on 22/06/2016.
 */
@SpringBootApplication(scanBasePackages = "main.java.com.boot")
@EntityScan("main.java.com.boot.model.jpa")
@EnableJpaRepositories("main.java.com.boot.repository.jpa")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringMvcApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringMvcApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcApplication.class, args);
    }

}

