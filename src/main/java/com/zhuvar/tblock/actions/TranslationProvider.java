package com.zhuvar.tblock.actions;

import com.intellij.openapi.startup.StartupActivity;
import groovy.lang.Singleton;
import com.zhuvar.tblock.text.formatting.impl.MessageConverter;
import com.zhuvar.tblock.text.translation.impl.GoogleTranslator;

@Singleton
public class TranslationProvider {

    private static TranslationProvider instance = null;
    private final GoogleTranslator googleTranslator;
    private final MessageConverter messageConverter;

    private TranslationProvider() {
        this.googleTranslator = new GoogleTranslator();
        this.messageConverter = new MessageConverter();
    }

    public static TranslationProvider getInstance() {
        if (instance == null) {
            instance = new TranslationProvider();
        }
        return instance;
    }

    public GoogleTranslator getGoogleTranslator() {
        return instance.googleTranslator;
    }

    public MessageConverter getMessageConverter() {
        return instance.messageConverter;
    }
}
