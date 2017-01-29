package yousecase.format.character;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static yousecase.format.character.CharacterFormatTestTool.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class CharacterFormatTestToolTest {
    @RunWith(Theories.class)
    public static class VerifyTest {
        private static final CharacterFormat characterFormat = AlphabetFullToHalf.getInstance();
        private static final Map<Character, Character> baseMap = CharacterFormats.extractLogic(characterFormat);

        @DataPoints
        public static Fixture[] fixtures = { data0(), data1(), data2(), data3() };

        // フォーマットされるべき文字のみがフォーマットされ、フォーマット後の文字が正しい。
        private static Fixture data0() {
            return new Fixture(characterFormat, baseMap, true);
        }

        // フォーマットされるべき文字のみがフォーマットされるが、フォーマット後の文字が間違っている。
        private static Fixture data1() {
            Map<Character, Character> map = new HashMap<>(baseMap);
            map.put('Ａ', 'あ');// フォーマット後の文字が「あ」となるべきだが半角の「A」になる。
            return new Fixture(characterFormat, map, false);
        }

        // フォーマットされるべき文字がフォーマットされない。
        private static Fixture data2() {
            Map<Character, Character> map = new HashMap<>(baseMap);
            map.put('あ', 'い');// 「あ」が「い」にフォーマットされるべきだがされない。
            return new Fixture(characterFormat, map, false);
        }

        // フォーマットされるべきでない文字がフォーマットされる。
        private static Fixture data3() {
            Map<Character, Character> map = new HashMap<>(baseMap);
            map.remove('Ａ');// 「Ａ」はフォーマットされるべきでないがされている。
            return new Fixture(characterFormat, map, false);
        }

        @Theory
        public void testVerify(Fixture fixture) {
            assertThat(verify(fixture.getCharacterFormat(), fixture.getExpectedValueMap()),
                    is(fixture.getExpectedReturnValue()));
        }

        private static class Fixture {
            private final CharacterFormat characterFormat;
            private final Map<Character, Character> expectedValueMap;
            private final boolean expectedReturnValue;

            public Fixture(CharacterFormat characterFormat, Map<Character, Character> expectedValueMap,
                    boolean expectedReturnValue) {
                this.characterFormat = characterFormat;
                this.expectedValueMap = expectedValueMap;
                this.expectedReturnValue = expectedReturnValue;
            }

            public CharacterFormat getCharacterFormat() {
                return characterFormat;
            }

            public Map<Character, Character> getExpectedValueMap() {
                return expectedValueMap;
            }

            public boolean getExpectedReturnValue() {
                return expectedReturnValue;
            }

            @Override
            public String toString() {
                return "Fixture [characterFormat=" + characterFormat + ", expectedValueMap=" + expectedValueMap
                        + ", expectedReturnValue=" + expectedReturnValue + "]";
            }
        }
    }

    @RunWith(Theories.class)
    public static class FormatEqualsTest {
        private static final CharacterFormat alphabetFullToHalf = AlphabetFullToHalf.getInstance();
        private static final CharacterFormat numberFullToHalf = NumberFullToHalf.getInstance();
        private static final CharacterFormat numberFullToHalfDeepCopy = CharacterFormats.optimize(numberFullToHalf);

        @DataPoints
        public static Fixture[] fixtures = {
                // フォーマットの振る舞いが一致する。
                new Fixture(alphabetFullToHalf, alphabetFullToHalf, true),
                // フォーマットの振る舞いが一致しない。
                new Fixture(alphabetFullToHalf, numberFullToHalf, false),
                // 異なるインスタンスでフォーマットの振る舞いが一致する。
                new Fixture(numberFullToHalf, numberFullToHalfDeepCopy, true) };

        @Theory
        public void testFormatEquals(Fixture fixture) {
            assertThat(formatEquals(fixture.getCharacterFormat1(), fixture.getCharacterFormat2()),
                    is(fixture.getExpectedReturnValue()));
        }

        private static class Fixture {
            private final CharacterFormat characterFormat1;
            private final CharacterFormat characterFormat2;
            private final boolean expectedReturnValue;

            public Fixture(CharacterFormat characterFormat1, CharacterFormat characterFormat2,
                    boolean expectedReturnValue) {
                this.characterFormat1 = characterFormat1;
                this.characterFormat2 = characterFormat2;
                this.expectedReturnValue = expectedReturnValue;
            }

            public CharacterFormat getCharacterFormat1() {
                return characterFormat1;
            }

            public CharacterFormat getCharacterFormat2() {
                return characterFormat2;
            }

            public boolean getExpectedReturnValue() {
                return expectedReturnValue;
            }

            @Override
            public String toString() {
                return "Fixture [characterFormat1=" + characterFormat1 + ", characterFormat2=" + characterFormat2
                        + ", expectedReturnValue=" + expectedReturnValue + "]";
            }
        }
    }
}
