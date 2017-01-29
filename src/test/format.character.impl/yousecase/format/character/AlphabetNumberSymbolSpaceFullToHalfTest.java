package yousecase.format.character;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import yousecase.format.character.CharacterFormatTestTool.Fixture;
import yousecase.util.SerialCharacterMaker;

@RunWith(Theories.class)
public class AlphabetNumberSymbolSpaceFullToHalfTest {
    @DataPoint
    public static final Fixture fixture = new Fixture(AlphabetNumberSymbolSpaceFullToHalf.getInstance(),
            createExpectedValue());

    private static Map<Character, Character> createExpectedValue() {
        StringBuilder keys = new StringBuilder();
        StringBuilder values = new StringBuilder();

        // アルファベット大文字
        SerialCharacterMaker.append(keys, 'Ａ', 'Ｚ');// 全角
        SerialCharacterMaker.append(values, 'A', 'Z');// 半角

        // アルファベット小文字
        SerialCharacterMaker.append(keys, 'ａ', 'ｚ');
        SerialCharacterMaker.append(values, 'a', 'z');

        // 数字
        SerialCharacterMaker.append(keys, '０', '９');
        SerialCharacterMaker.append(values, '0', '9');

        // スペース
        keys.append("　");
        values.append(" ");

        // unicodeの「！」から「～」に含まれる記号
        keys.append('！');
        values.append('!');
        keys.append("”");
        values.append("\"");
        keys.append("＃＄％＆");
        values.append("#$%&");
        keys.append("’");
        values.append("'");
        keys.append("（）＊＋，－．／");
        values.append("()*+,-./");
        keys.append("：；＜＝＞？＠");
        values.append(":;<=>?@");
        keys.append("［＼］＾＿｀");
        values.append("[\\]^_`");
        keys.append("｛｜｝～");
        values.append("{|}~");

        return CharacterFormatTestTool.associateSameOrderCharacter(keys.toString(), values.toString());
    }

    @Theory
    public void testFormat(Fixture fixture) {
        assertTrue(CharacterFormatTestTool.verify(fixture.getCharacterFormat(), fixture.getExpectedValueMap()));
    }
}
