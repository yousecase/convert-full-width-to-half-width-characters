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
public class NumberHalfToFullTest {
    @DataPoint
    public static final Fixture fixture = new Fixture(NumberHalfToFull.getInstance(), createExpectedValue());

    private static Map<Character, Character> createExpectedValue() {
        String keys = SerialCharacterMaker.newString('0', '9');
        String values = SerialCharacterMaker.newString('０', '９');
        return CharacterFormatTestTool.associateSameOrderCharacter(keys, values);
    }

    @Theory
    public void testFormat(Fixture fixture) {
        assertTrue(CharacterFormatTestTool.verify(fixture.getCharacterFormat(), fixture.getExpectedValueMap()));
    }
}
