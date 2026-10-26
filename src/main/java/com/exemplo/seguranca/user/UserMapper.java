package com.exemplo.seguranca.user;

import com.exemplo.seguranca.auth.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponse toResponse(User user) {
        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }

    public AdminUserResponse toAdminResponse(User user) {
        return new AdminUserResponse(user.getId(), user.getName(), user.getEmail(),
                user.getRoles(), user.isEnabled(), user.getCreatedAt());
    }
}
