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
public class AlphabetHalfToFullTest {
    @DataPoint
    public static final Fixture fixture = new Fixture(AlphabetHalfToFull.getInstance(), createExpectedValue());

    private static Map<Character, Character> createExpectedValue() {
        StringBuilder keys = new StringBuilder();
        StringBuilder values = new StringBuilder();

        // アルファベット大文字
        SerialCharacterMaker.append(keys, 'A', 'Z');// 半角
        SerialCharacterMaker.append(values, 'Ａ', 'Ｚ');// 全角

        // アルファベット小文字
        SerialCharacterMaker.append(keys, 'a', 'z');
        SerialCharacterMaker.append(values, 'ａ', 'ｚ');

        return CharacterFormatTestTool.associateSameOrderCharacter(keys.toString(), values.toString());
    }

    @Theory
    public void testFormat(Fixture fixture) {
        assertTrue(CharacterFormatTestTool.verify(fixture.getCharacterFormat(), fixture.getExpectedValueMap()));
    }
}
