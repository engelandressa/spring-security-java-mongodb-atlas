package com.exemplo.seguranca.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin/users")
public class AdminUserController {

    private final UserRepository repository;
    private final UserMapper mapper;

    public AdminUserController(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @GetMapping
    public List<AdminUserResponse> list() {
        return repository.findAll().stream().map(mapper::toAdminResponse).toList();
    }
}
