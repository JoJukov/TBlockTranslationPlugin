package actions;

import groovy.lang.Singleton;
import text.formatting.impl.MessageConverter;
import text.translation.impl.GoogleTranslator;

import java.io.IOException;

@Singleton
public class TranslationProvider {

    private static TranslationProvider instance = null;
    private final GoogleTranslator googleTranslator;
    private final MessageConverter messageConverter;

    private TranslationProvider() throws IOException {
        this.googleTranslator = new GoogleTranslator();
        this.messageConverter = new MessageConverter();
    }

    public static TranslationProvider getInstance() throws IOException {
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
