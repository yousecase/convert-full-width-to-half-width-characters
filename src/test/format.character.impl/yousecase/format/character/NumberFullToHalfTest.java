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
public class NumberFullToHalfTest {
    @DataPoint
    public static final Fixture fixture = new Fixture(NumberFullToHalf.getInstance(), createExpectedValue());

    private static Map<Character, Character> createExpectedValue() {
        String keys = SerialCharacterMaker.newString('０', '９');
        String values = SerialCharacterMaker.newString('0', '9');
        return CharacterFormatTestTool.associateSameOrderCharacter(keys, values);
    }

    @Theory
    public void testFormat(Fixture fixture) {
        assertTrue(CharacterFormatTestTool.verify(fixture.getCharacterFormat(), fixture.getExpectedValueMap()));
    }
}
