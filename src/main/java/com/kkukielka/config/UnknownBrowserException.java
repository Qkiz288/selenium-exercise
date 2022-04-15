package com.kkukielka.config;

public class UnknownBrowserException extends RuntimeException {
    public UnknownBrowserException(String browser) {
        super(String.format("Unknown browser: %s", browser));
    }
}
