package yousecase.format.character;

/**
 * 半角のアルファベット、数字、記号、スペースを全角にフォーマットする{@link CharacterFormat}を保持しているクラスです。フォーマット対象の記号は
 * 「{@literal !, ", #, $, %, &, ', (, ), *, +, ,, -, ., /, :, ;, <, =, >, ?, @,
 * [, \, ], ^, _, `, {, |, }, ~}」です。
 * フォーマット対象のスペースのUnicodeは「{@literal \}u0020」で、フォーマット後のスペースのUnicodeは「{@literal \}u3000」です。
 */
class AlphabetNumberSymbolSpaceHalfToFull {
    private static final CharacterFormat instance = CharacterFormats
            .newReversedCharacterFormat(AlphabetNumberSymbolSpaceFullToHalf.getInstance());

    static CharacterFormat getInstance() {
        return instance;
    }

    private AlphabetNumberSymbolSpaceHalfToFull() {
    }
}
