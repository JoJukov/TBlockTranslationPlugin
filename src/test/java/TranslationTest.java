import com.zhuvar.tblock.exceptions.TranslationException;
import org.junit.Before;
import org.junit.Test;
import com.zhuvar.tblock.text.translation.Translator;
import com.zhuvar.tblock.text.translation.impl.GoogleTranslator;

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
