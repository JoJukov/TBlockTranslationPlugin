package text.translation;

import exception.TranslationException;

public interface Translator {

    String translate(String text, Destination dest) throws TranslationException;
}
