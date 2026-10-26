package com.exemplo.seguranca.user;

import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProfileController {

    @GetMapping("/me")
    public Map<String, Object> me(Authentication auth) {
        return Map.of("email", auth.getName(), "roles", auth.getAuthorities().toString());
    }

    @GetMapping("/admin/painel")
    public String admin() {
        return "Área restrita a administradores";
    }
}
