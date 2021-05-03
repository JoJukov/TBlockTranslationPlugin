import conversion.impl.MessageParser;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CaseConversionTest {

    private MessageParser messageParser;

    @Before
    public void setUp() throws IOException {
        messageParser = new MessageParser();
    }

    @Test
    public void snakeCaseToNormalCaseTest() {
        assertEquals("a bo ba_", messageParser.convert("a_bo_ba_"));
    }

    @Test
    public void kebabCaseToNormalCaseTest() {
        assertEquals(" - a bo ba", messageParser.convert(" - a-bo-ba"));
    }

    @Test
    public void kebabAndSnakeCaseToNormalCaseTest1() {
        assertEquals("a bo ba a bi ba", messageParser.convert("a-bo_ba-a_bi-ba"));
    }

    @Test
    public void kebabAndSnakeCaseToNormalCaseTest2() {
        assertEquals("a bo ba a bi ba", messageParser.convert("a-bo_ba a_bi-ba"));
    }

    @Test
    public void kebabAndSnakeCaseToNormalCaseTest3() {
        assertEquals("a bo ba a bi ba", messageParser.convert("a-bo_ba a_bi_ba"));
    }

    @Test
    public void camelCaseToNormalCaseTest() {
        assertEquals("A Bo Ba", messageParser.convert("ABoBa"));
    }

    @Test
    public void camelFullUpperCaseToNormalCaseTest() {
        assertEquals("ABOBA", messageParser.convert("ABOBA"));
    }

    @Test
    public void camelAndKebabCasesToNormalCaseTest() {
        assertEquals("a Bo Ba a bi", messageParser.convert("aBoBa a-bi"));
    }

    @Test
    public void allCasesToNormalCaseTest() {
        assertEquals("a Bo Ba a bi wi ba a bu bu", messageParser.convert("aBoBa a-bi-wi ba_a_bu_bu"));
    }

    @Test
    public void deleteExtraSpacesTest() {
        assertEquals(" a m l ", messageParser.convert("                       a         m     l     "));
    }

    @Test
    public void AllTest1() {
        assertEquals("a bo bo a bob bo", messageParser.convert("a_bo-bo_a_bob-bo"));
    }

    @Test
    public void AllTest2() {
        assertEquals("A Bo a bo bo a bob bo", messageParser.convert("ABo        a_bo-bo_a_bob-bo"));
    }

    @Test
    public void AllTest3() {
        assertEquals("Big Camel Case Test For All Of Us", messageParser.convert("BigCamelCaseTestForAllOfUs"));
    }

    @Test
    public void AllTest4() {
        assertEquals("a a a a a a a a a a a a a a a", messageParser.convert("a_a-a_a-a_a_a-a-a_a-a_a_a_a-a"));
    }

    @Test
    public void AllTest5() {
        assertEquals("Just a SM test", messageParser.convert("Just-a-SM-test"));
    }

    @Test
    public void AllTest6() {
        assertEquals("Aa Aa Aa", messageParser.convert("AaAaAa"));
    }

    @Test
    public void AllTest7() {
        assertEquals("o o o", messageParser.convert("o o o"));
    }

    @Test
    public void AllTest8() {
        assertEquals("o o o", messageParser.convert("o__________________o------------o"));
    }

    @Test
    public void AllTest9() {
        assertEquals("o o o", messageParser.convert("o___________o o"));
    }
}
