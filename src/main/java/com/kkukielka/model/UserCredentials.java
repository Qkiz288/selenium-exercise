package com.kkukielka.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserCredentials {
    private final String login;
    private final String password;
}
