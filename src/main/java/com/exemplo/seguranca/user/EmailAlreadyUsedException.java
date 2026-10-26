package com.exemplo.seguranca.user;

public class EmailAlreadyUsedException extends RuntimeException {
    public EmailAlreadyUsedException(String email) {
        super("E-mail já cadastrado");
    }
}
