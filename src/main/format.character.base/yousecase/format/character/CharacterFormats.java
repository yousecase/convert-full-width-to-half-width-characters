package yousecase.format.character;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

import yousecase.util.Maps;

public class CharacterFormats {

    /**
     * 引数で指定された{@link Map}を用いてフォーマットを行う{@link CharacterFormat}を生成します。
     * {@link CharacterFormat#format(char)}メソッドで指定された文字が{@link Map}のキーに含まれていた場合、
     * キーに関連付けられている値を返し、含まれていない場合は引数で指定された文字を返します。
     * 
     * @param map
     *            フォーマット対象の文字がキーとして、フォーマット後の文字が値として関連付けられている{@link Map}
     * @return 引数で指定された{@link Map}を用いてフォーマットを行う{@link CharacterFormat}
     */
    public static CharacterFormat newCharacterFormat(Map<Character, Character> map) {
        Objects.requireNonNull(map);
        return new CharacterFormatWithMap(map);
    }

    /**
     * 引数で指定された{@link CharacterFormat}のフォーマット対象の文字とフォーマット後の文字を入れ替えた{@link CharacterFormat}を生成します。
     * 例えば、全角の数字を半角にする{@link CharacterFormat}が引数で指定されると、半角の数字を全角にする{@link CharacterFormat}が生成されます。
     * aを1、bを1にフォーマットする{@link CharacterFormat}等のフォーマット後の値に重複のある{@link CharacterFormat}は引数で指定できません。
     * 
     * @param characterFormat
     *            フォーマット対象の文字とフォーマット後の文字を入れ替える{@link CharacterFormat}
     * @return フォーマット対象の文字とフォーマット後の文字を入れ替えた{@link CharacterFormat}
     */
    public static CharacterFormat newReversedCharacterFormat(CharacterFormat characterFormat) {
        Objects.requireNonNull(characterFormat);
        Map<Character, Character> map = extractLogic(characterFormat);
        Map<Character, Character> swappedMap = Maps.swapKeyValue(map);
        return newCharacterFormat(swappedMap);
    }

    /**
     * 引数で指定された{@link CharacterFormat}のフォーマット対象の文字がキーとして、
     * フォーマット後の文字が値として関連付けられている{@link Map}を生成します。
     * 
     * @param characterFormat
     *            生成される{@link Map}の元となる{@link CharacterFormat}
     * @return 引数で指定された{@link CharacterFormat}のフォーマット対象の文字がキーとして、
     *         フォーマット後の文字が値として関連付けられている{@link Map}
     */
    public static Map<Character, Character> extractLogic(CharacterFormat characterFormat) {
        Objects.requireNonNull(characterFormat);
        Map<Character, Character> map = new HashMap<>();
        for (int unicode = Character.MIN_VALUE; unicode <= Character.MAX_VALUE; unicode++) {
            char ch = (char) unicode;
            char formattedCh = characterFormat.format(ch);
            if (ch != formattedCh) {
                map.put(ch, formattedCh);
            }
        }
        return map;
    }

    /**
     * 引数で指定された{@link CharacterFormat}の内部処理を最適化し、最適化された{@link CharacterFormat}を生成します。
     * 最適化された{@link CharacterFormat#format(char)}メソッドの計算量は現時点でO(1)ですが、今後も保証されるものではありません。
     * 
     * @param characterFormat
     *            最適化対象の{@link CharacterFormat}
     * @return 最適化された{@link CharacterFormat}
     */
    public static CharacterFormat optimize(CharacterFormat characterFormat) {
        Objects.requireNonNull(characterFormat);
        Map<Character, Character> map = extractLogic(characterFormat);
        CharacterFormat optimizedCharacterFormat = newCharacterFormat(map);
        assert CharacterFormatTestTool.formatEquals(characterFormat, optimizedCharacterFormat);
        return optimizedCharacterFormat;
    }

    /**
     * 複数の{@link CharacterFormat}をつなぎ合わせて1つにした{@link CharacterFormat}を生成します。
     * 引数で指定された{@link CharacterFormat}がフォーマットする文字が重複していた場合、
     * 引数で一番先に指定した{@link CharacterFormat}でフォーマットされます。
     * 例えば、引数で「全角のアルファベットを半角にする{@link CharacterFormat}」と「全角の数字を半角にする{@link CharacterFormat}」
     * が指定されると「全角のアルファベットと数字をを半角にする{@link CharacterFormat}」が生成されます。
     * また、引数で「"A"を"あ"に、"B"を"い"にする{@link CharacterFormat}」と「"B"を"1"に、"C"を"2"にする{@link CharacterFormat}」
     * がこの順番で指定されると「"A"を"あ"に、"B"を"い"に、"C"を"2"にする{@link CharacterFormat}」が生成されます。
     * 
     * @param characterFormats
     *            つなぎ合わせる{@link CharacterFormat}
     * @return つなぎ合わせた{@link CharacterFormat}
     */
    public static CharacterFormat connect(CharacterFormat... characterFormats) {
        Objects.requireNonNull(characterFormats);
        if (characterFormats.length == 0) {
            throw new IllegalArgumentException();
        }
        for (CharacterFormat characterFormat : characterFormats) {
            Objects.requireNonNull(characterFormat);
        }
        CharacterFormat characterFormat = new CharacterFormatAggregation(characterFormats);
        return optimize(characterFormat);
    }

    /**
     * 指定された{@link CharacterFormat}の文字列表現を返します。
     * 
     * @param characterFormat
     *            文字列表現の元となる{@link CharacterFormat}
     * @return {@link CharacterFormat}の文字列表現
     */
    public static String toString(CharacterFormat characterFormat) {
        Objects.requireNonNull(characterFormat);
        return characterFormat.getClass().getName() + new TreeMap<>(extractLogic(characterFormat));
    }

    private CharacterFormats() {
    }
}
