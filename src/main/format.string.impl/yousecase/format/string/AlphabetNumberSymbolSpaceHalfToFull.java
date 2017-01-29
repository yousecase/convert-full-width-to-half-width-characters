package yousecase.format.string;

import yousecase.format.character.CharacterFormat;

/**
 * 半角のアルファベット、数字、記号、スペースを全角にフォーマットする{@link StringFormat}を保持しているクラスです。フォーマット対象の記号は
 * 「{@literal !, ", #, $, %, &, ', (, ), *, +, ,, -, ., /, :, ;, <, =, >, ?, @,
 * [, \, ], ^, _, `, {, |, }, ~}」です。
 * フォーマット対象のスペースのUnicodeは「{@literal \}u0020」で、フォーマット後のスペースのUnicodeは「{@literal \}u3000」です。
 */
class AlphabetNumberSymbolSpaceHalfToFull {
    private static final StringFormat instance = new StringFormatTemplate(
            CharacterFormat.getAlphabetNumberSymbolSpaceHalfToFullCharacterFormat());

    static StringFormat getInstance() {
        return instance;
    }

    private AlphabetNumberSymbolSpaceHalfToFull() {
    }
}
