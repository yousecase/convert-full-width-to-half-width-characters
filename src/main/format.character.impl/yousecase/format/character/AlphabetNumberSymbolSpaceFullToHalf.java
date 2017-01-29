package yousecase.format.character;

import static yousecase.format.character.CharacterFormatConstants.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 全角のアルファベット、数字、記号、スペースを半角にフォーマットする{@link CharacterFormat}を保持しているクラスです。
 * フォーマット対象の記号は「’, ”, ！, ＃, ＄, ％, ＆, （, ）, ＊, ＋, ，, －, ．, ／, ：, ；, ＜, ＝, ＞, ？,
 * ＠, ［, ＼, ］, ＾, ＿, ｀, ｛, ｜, ｝, ～」です。
 * フォーマット対象のスペースのUnicodeは「{@literal \}u3000」で、フォーマット後のスペースのUnicodeは「{@literal \}u0020」です。
 */
class AlphabetNumberSymbolSpaceFullToHalf {
    private static final CharacterFormat instance = newInstance();

    private static CharacterFormat newInstance() {
        Map<Character, Character> map = new HashMap<>();

        // 英数字記号
        for (int unicode = '！'; unicode <= '～'; unicode++) {
            map.put((char) unicode, (char) (unicode - UNICODE_DISTANCE));
        }

        // スペース
        map.put('　', ' ');

        // ダブルクォーテーション
        map.remove('＂');
        map.put('”', '"');

        // シングルクォーテーション
        map.remove('＇');
        map.put('’', '\'');

        return CharacterFormats.newCharacterFormat(map);
    }

    static CharacterFormat getInstance() {
        return instance;
    }

    private AlphabetNumberSymbolSpaceFullToHalf() {
    }
}
