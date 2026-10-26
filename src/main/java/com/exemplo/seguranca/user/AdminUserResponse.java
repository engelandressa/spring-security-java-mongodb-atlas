package com.exemplo.seguranca.user;

import java.time.Instant;
import java.util.Set;

public record AdminUserResponse(
        String id, String name, String email,
        Set<Role> roles, boolean enabled, Instant createdAt
) {}
