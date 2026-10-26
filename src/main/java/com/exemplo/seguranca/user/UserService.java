package com.exemplo.seguranca.user;

import com.exemplo.seguranca.auth.RegisterRequest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(RegisterRequest request) {
        String email = request.email().trim().toLowerCase();

        if (repository.existsByEmail(email)) {
            throw new EmailAlreadyUsedException(email);
        }

        var user = new User(
                email,
                request.name().trim(),
                passwordEncoder.encode(request.password()),
                Set.of(Role.USER)            // papel definido pelo servidor, nunca pelo cliente
        );

        try {
            return repository.save(user);
        } catch (DuplicateKeyException e) {
            // corrida: outro cadastro com o mesmo e-mail passou entre o exists e o save
            throw new EmailAlreadyUsedException(email);
        }
    }
}
