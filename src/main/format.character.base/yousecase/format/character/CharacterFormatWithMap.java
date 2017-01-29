package yousecase.format.character;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * コンストラクタの引数で指定された{@link Map}を用いてフォーマットを行う{@link CharacterFormat}です。
 * {@link CharacterFormat#format(char)}メソッドで指定された文字が{@link Map}のキーに含まれていた場合、
 * キーに関連付けられている値を返し、含まれていない場合は引数で指定された文字を返します。
 */
class CharacterFormatWithMap implements CharacterFormat {
    private Map<Character, Character> map;

    public CharacterFormatWithMap(Map<Character, Character> map) {
        this.map = new HashMap<>(map);
    }

    @Override
    public char format(char ch) {
        if (map.containsKey(ch)) {
            return map.get(ch);
        }
        return ch;
    }

    @Override
    public String toString() {
        return getClass().getName() + new TreeMap<>(map);
    }
}
