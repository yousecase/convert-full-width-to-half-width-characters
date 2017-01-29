package yousecase.format.string;

import yousecase.format.character.CharacterFormat;

/**
 * 全角のアルファベット、数字、記号、スペースを半角にフォーマットする{@link StringFormat}を保持しているクラスです。フォーマット対象の記号は
 * 「’, ”, ！, ＃, ＄, ％, ＆, （, ）, ＊, ＋, ，, －, ．, ／, ：, ；, ＜, ＝, ＞, ？, ＠, ［, ＼, ］,
 * ＾, ＿, ｀, ｛, ｜, ｝, ～」です。
 * フォーマット対象のスペースのUnicodeは「{@literal \}u3000」で、フォーマット後のスペースのUnicodeは「{@literal \}u0020」です。
 */
class AlphabetNumberSymbolSpaceFullToHalf {
    private static final StringFormat instance = new StringFormatTemplate(
            CharacterFormat.getAlphabetNumberSymbolSpaceFullToHalfCharacterFormat());

    static StringFormat getInstance() {
        return instance;
    }

    private AlphabetNumberSymbolSpaceFullToHalf() {
    }
}
