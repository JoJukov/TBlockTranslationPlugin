import com.zhuvar.tblock.exceptions.TranslationException;
import org.junit.Before;
import org.junit.Test;
import com.zhuvar.tblock.text.translation.impl.GoogleTranslator;

import static org.junit.Assert.assertEquals;

public class TranslationTest {

    private GoogleTranslator translator;

    @Before
    public void setUp() {
        translator = new GoogleTranslator();
        translator.setDestLang("En");
    }

    @Test
    public void FirstTest() throws TranslationException {
        assertEquals("dad", translator.translate("папа"));
    }
}
