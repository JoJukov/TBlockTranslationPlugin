import org.junit.Before;
import org.junit.Test;
import translation.Destination;
import translation.impl.GoogleTranslator;
import translation.Translator;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TranslationTest {

    private Translator translator;

    @Before
    public void setUp() throws IOException {
        translator = new GoogleTranslator();
    }

    @Test
    public void FirstTest() {
        assertEquals("Мама", translator.translate("mom", Destination.Ru));
    }

//    @Test
//    public void SecondTest() {
//        assertEquals("мама с мухомором", translator.translate("мама с мухомором", Destination.Ru));
//    }
}
