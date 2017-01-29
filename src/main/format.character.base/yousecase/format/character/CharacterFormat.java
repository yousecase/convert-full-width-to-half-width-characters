package yousecase.format.character;

/**
 * 文字をフォーマットするオブジェクトです。
 * {@link #format(char)}メソッドで全角文字を半角文字に、大文字を小文字に等のフォーマットを行います。
 */
public interface CharacterFormat {
    /**
     * 引数で指定された文字をフォーマットし、フォーマットされた文字を返します。
     * 
     * @param ch
     *            フォーマットするchar
     * @return フォーマットされたchar
     */
    char format(char ch);

    // factory
    /**
     * 全角のアルファベット、数字、記号、スペースを半角にフォーマットする{@link CharacterFormat}を返します。フォーマット対象の記号は
     * 「’, ”, ！, ＃, ＄, ％, ＆, （, ）, ＊, ＋, ，, －, ．, ／, ：, ；, ＜, ＝, ＞, ？, ＠, ［, ＼,
     * ］, ＾, ＿, ｀, ｛, ｜, ｝, ～」です。
     * フォーマット対象のスペースのUnicodeは「{@literal \}u3000」で、フォーマット後のスペースのUnicodeは「{@literal \}u0020」です。
     * 
     * @return 全角のアルファベット、数字、記号、スペースを半角にフォーマットする{@link CharacterFormat}
     */
    public static CharacterFormat getAlphabetNumberSymbolSpaceFullToHalfCharacterFormat() {
        return AlphabetNumberSymbolSpaceFullToHalf.getInstance();
    }

    /**
     * 半角のアルファベット、数字、記号、スペースを全角にフォーマットする{@link CharacterFormat}を返します。フォーマット対象の記号は
     * 「{@literal !, ", #, $, %, &, ', (, ), *, +, ,, -, ., /, :, ;, <, =, >,
     * ?, @, [, \, ], ^, _, `, {, |, }, ~}」です。
     * フォーマット対象のスペースのUnicodeは「{@literal \}u0020」で、フォーマット後のスペースのUnicodeは「{@literal \}u3000」です。
     * 
     * @return 半角のアルファベット、数字、記号、スペースを全角にフォーマットする{@link CharacterFormat}
     */
    public static CharacterFormat getAlphabetNumberSymbolSpaceHalfToFullCharacterFormat() {
        return AlphabetNumberSymbolSpaceHalfToFull.getInstance();
    }
}
