import exceptions.TranslationException;
import org.junit.Before;
import org.junit.Test;
import text.translation.Translator;
import text.translation.impl.GoogleTranslator;

import static org.junit.Assert.assertEquals;

public class TranslationTest {

    private Translator translator;

    @Before
    public void setUp() {
        translator = new GoogleTranslator();
    }

    @Test
    public void FirstTest() throws TranslationException {
        assertEquals("Мама", translator.translate("mom"));
    }
}
