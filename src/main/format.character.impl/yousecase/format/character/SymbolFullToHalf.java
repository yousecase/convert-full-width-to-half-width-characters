package yousecase.format.character;

import java.util.Map;

/**
 * 全角の記号を半角にフォーマットする{@link CharacterFormat}を保持しているクラスです。 フォーマット対象の記号は「’, ”, ！,
 * ＃, ＄, ％, ＆, （, ）, ＊, ＋, ，, －, ．, ／, ：, ；, ＜, ＝, ＞, ？, ＠, ［, ＼, ］, ＾, ＿, ｀, ｛,
 * ｜, ｝, ～」です。
 */
class SymbolFullToHalf {
    private static final CharacterFormat instance = newInstance();

    private static CharacterFormat newInstance() {
        StringBuilder keys = new StringBuilder();
        StringBuilder values = new StringBuilder();

        // Unicodeの「！」から「～」に含まれる記号
        keys.append('！');
        values.append('!');
        keys.append("”");
        values.append("\"");
        keys.append("＃＄％＆");
        values.append("#$%&");
        keys.append("’");
        values.append("'");
        keys.append("（）＊＋，－．／");
        values.append("()*+,-./");
        keys.append("：；＜＝＞？＠");
        values.append(":;<=>?@");
        keys.append("［＼］＾＿｀");
        values.append("[\\]^_`");
        keys.append("｛｜｝～");
        values.append("{|}~");

        Map<Character, Character> map = CharacterFormatTestTool.associateSameOrderCharacter(keys.toString(),
                values.toString());
        return CharacterFormats.newCharacterFormat(map);
    }

    static CharacterFormat getInstance() {
        return instance;
    }

    private SymbolFullToHalf() {
    }
}
