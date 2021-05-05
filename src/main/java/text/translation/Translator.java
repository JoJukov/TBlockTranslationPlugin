package text.translation;

import exceptions.TranslationException;

public interface Translator {

    String translate(String text) throws TranslationException;
}
