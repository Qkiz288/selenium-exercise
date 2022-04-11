package com.kkukielka.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum User {
    STANDARD_USER("standard_user", "secret_sauce");

    private final String login;
    private final String password;

}
