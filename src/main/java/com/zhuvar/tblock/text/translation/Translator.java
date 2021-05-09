package com.zhuvar.tblock.text.translation;

import com.zhuvar.tblock.exceptions.TranslationException;

public interface Translator {

    String translate(String text) throws TranslationException;
}
