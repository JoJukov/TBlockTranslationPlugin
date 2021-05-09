package com.zhuvar.tblock.exceptions;

public class TranslationException extends Exception {
    public TranslationException(String message) {
        super(message);
    }

    public TranslationException(Throwable cause) {
        super(cause);
    }

    public TranslationException(String message, Throwable cause) {
        super(message, cause);
    }
}
