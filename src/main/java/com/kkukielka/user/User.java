package com.kkukielka.user;

import com.kkukielka.model.UserCredentials;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum User {
    STANDARD_USER("standard_user", "secret_sauce");

    private final String login;
    private final String password;

    public UserCredentials toUserCredentials() {
        return new UserCredentials(login, password);
    }

}
