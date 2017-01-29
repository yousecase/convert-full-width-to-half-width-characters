package yousecase.format.character;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import yousecase.format.character.CharacterFormatTestTool.Fixture;

@RunWith(Theories.class)
public class SymbolHalfToFullTest {
    @DataPoint
    public static final Fixture fixture = new Fixture(SymbolHalfToFull.getInstance(), createExpectedValue());

    private static Map<Character, Character> createExpectedValue() {
        StringBuilder keys = new StringBuilder();
        StringBuilder values = new StringBuilder();

        // Unicodeの「！」から「～」に含まれる記号
        keys.append('!');
        values.append('！');
        keys.append("\"");
        values.append("”");
        keys.append("#$%&");
        values.append("＃＄％＆");
        keys.append("'");
        values.append("’");
        keys.append("()*+,-./");
        values.append("（）＊＋，－．／");
        keys.append(":;<=>?@");
        values.append("：；＜＝＞？＠");
        keys.append("[\\]^_`");
        values.append("［＼］＾＿｀");
        keys.append("{|}~");
        values.append("｛｜｝～");

        return CharacterFormatTestTool.associateSameOrderCharacter(keys.toString(), values.toString());
    }

    @Theory
    public void testFormat(Fixture fixture) {
        assertTrue(CharacterFormatTestTool.verify(fixture.getCharacterFormat(), fixture.getExpectedValueMap()));
    }
}
