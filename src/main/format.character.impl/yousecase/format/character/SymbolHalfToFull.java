package yousecase.format.character;

/**
 * 半角の記号を全角にフォーマットする{@link CharacterFormat}を保持しているクラスです。 フォーマット対象の記号は
 * 「{@literal !, ", #, $, %, &, ', (, ), *, +, ,, -, ., /, :, ;, <, =, >, ?, @,
 * [, \, ], ^, _, `, {, |, }, ~}」です。
 */
class SymbolHalfToFull {
    private static final CharacterFormat instance = CharacterFormats
            .newReversedCharacterFormat(SymbolFullToHalf.getInstance());

    static CharacterFormat getInstance() {
        return instance;
    }

    private SymbolHalfToFull() {
    }
}
