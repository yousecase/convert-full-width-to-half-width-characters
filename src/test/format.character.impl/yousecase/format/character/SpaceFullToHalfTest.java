package yousecase.format.character;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import yousecase.format.character.CharacterFormatTestTool.Fixture;

@RunWith(Theories.class)
public class SpaceFullToHalfTest {
    @DataPoint
    public static final Fixture fixture = new Fixture(SpaceFullToHalf.getInstance(), createExpectedValue());

    private static Map<Character, Character> createExpectedValue() {
        return CharacterFormatTestTool.associateSameOrderCharacter("　", " ");
    }

    @Theory
    public void testFormat(Fixture fixture) {
        assertTrue(CharacterFormatTestTool.verify(fixture.getCharacterFormat(), fixture.getExpectedValueMap()));
    }
}
