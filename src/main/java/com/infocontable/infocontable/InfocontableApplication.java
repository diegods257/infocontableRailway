package com.infocontable.infocontable;

import com.infocontable.infocontable.config.Rol;
import com.infocontable.infocontable.model.User;
import com.infocontable.infocontable.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class InfocontableApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfocontableApplication.class, args);
    }

  
}
