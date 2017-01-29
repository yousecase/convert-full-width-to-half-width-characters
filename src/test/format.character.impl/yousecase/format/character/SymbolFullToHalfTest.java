package yousecase.format.character;

import static org.junit.Assert.*;
import static yousecase.format.character.CharacterFormatConstants.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import yousecase.format.character.CharacterFormatTestTool.Fixture;

@RunWith(Theories.class)
public class SymbolFullToHalfTest {
    @DataPoint
    public static final Fixture fixture = new Fixture(SymbolFullToHalf.getInstance(), createExpectedValue());

    private static Map<Character, Character> createExpectedValue() {
        Map<Character, Character> map = new HashMap<>();

        // 英数字記号
        for (int unicode = '！'; unicode <= '～'; unicode++) {
            map.put((char) unicode, (char) (unicode - UNICODE_DISTANCE));
        }

        // ダブルクォーテーション
        map.remove('＂');
        map.put('”', '"');

        // シングルクォーテーション
        map.remove('＇');
        map.put('’', '\'');

        // 英数字を取り除く
        for (int i = 'Ａ'; i <= 'Ｚ'; i++) {
            map.remove((char) i);
        }
        for (int i = 'ａ'; i <= 'ｚ'; i++) {
            map.remove((char) i);
        }
        for (int i = '０'; i <= '９'; i++) {
            map.remove((char) i);
        }

        return map;
    }

    @Theory
    public void testFormat(Fixture fixture) {
        assertTrue(CharacterFormatTestTool.verify(fixture.getCharacterFormat(), fixture.getExpectedValueMap()));
    }
}
