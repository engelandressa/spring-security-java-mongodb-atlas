package com.exemplo.seguranca.config;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.exemplo.seguranca.user.Role;
import com.exemplo.seguranca.user.User;
import com.exemplo.seguranca.user.UserRepository;

@Configuration
@Profile("dev")
public class DevDataSeeder {

    @Bean
    CommandLineRunner seedAdmin(UserRepository repo, PasswordEncoder encoder) {
        return args -> {
            if (!repo.existsByEmail("admin@exemplo.com")) {
                repo.save(new User("admin@exemplo.com", "Admin",
                        encoder.encode("Admin@12345"), Set.of(Role.USER, Role.ADMIN)));
            }
        };
    }
}
