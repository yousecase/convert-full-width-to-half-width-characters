package yousecase.format.character;

import java.util.Map;
import java.util.TreeMap;

class CharacterFormatTestTool {

    // 引数で指定されたCharacterFormatの振る舞いが期待通りであるか検証し期待通りであればtrueを返す。
    // CharacterFormatがフォーマットすべき文字をキーとして、フォーマット後の文字を値として関連付けたMapを引数で指定する。
    public static boolean verify(CharacterFormat characterFormat, Map<Character, Character> expectedValueMap) {
        for (int unicode = Character.MIN_VALUE; unicode <= Character.MAX_VALUE; unicode++) {
            char ch = (char) unicode;
            char formattedCh = characterFormat.format(ch);
            if (ch != formattedCh) {// フォーマットされている
                if (expectedValueMap.containsKey(ch)) {// フォーマットされた文字がフォーマットされるべき文字である
                    char expectedCh = expectedValueMap.get(ch).charValue();
                    if (formattedCh != expectedCh) {// フォーマット後の文字と期待値が一致しない
                        return false;
                    }
                } else {// フォーマットされた文字がフォーマットされるべき文字ではない(フォーマットされるべきでない文字がフォーマットされている)
                    return false;
                }
            } else if (expectedValueMap.containsKey(ch)) {// フォーマットされていないかつ、フォーマットされるべき文字である
                return false;
            }
        }
        return true;
    }

    // JUnitの@Theory用
    public static class Fixture {
        private final CharacterFormat characterFormat;
        private final Map<Character, Character> expectedValueMap;

        public Fixture(CharacterFormat characterFormat, Map<Character, Character> expectedValueMap) {
            this.characterFormat = characterFormat;
            this.expectedValueMap = expectedValueMap;
        }

        public CharacterFormat getCharacterFormat() {
            return characterFormat;
        }

        public Map<Character, Character> getExpectedValueMap() {
            return expectedValueMap;
        }

        @Override
        public String toString() {
            return "Fixture [characterFormat=" + characterFormat + ", expectedValueMap=" + expectedValueMap + "]";
        }
    }

    // 引数で指定されたkeysとvaluesの同順の文字の前者をキーとして後者を値として関連付けられているMapを返す。
    // Mapはキーの昇順でソート済み。
    public static Map<Character, Character> associateSameOrderCharacter(String keys, String values) {
        if (keys == null || values == null || keys.isEmpty() || keys.length() != values.length()) {
            throw new IllegalArgumentException();
        }

        Map<Character, Character> map = new TreeMap<>();
        for (int i = 0; i < keys.length(); i++) {
            map.put(keys.charAt(i), values.charAt(i));
        }
        return map;
    }

    // 引数で指定されたCharacterFormatの振る舞いが一致した場合trueを返す。
    public static boolean formatEquals(CharacterFormat format1, CharacterFormat format2) {
        for (int unicode = Character.MIN_VALUE; unicode <= Character.MAX_VALUE; unicode++) {
            char ch = (char) unicode;
            if (format1.format(ch) != format2.format(ch)) {
                return false;
            }
        }
        return true;
    }

    private CharacterFormatTestTool() {
    }
}