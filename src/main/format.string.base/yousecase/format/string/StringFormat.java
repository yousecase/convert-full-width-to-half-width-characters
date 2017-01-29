package yousecase.format.string;

/**
 * 文字列をフォーマットするオブジェクトです。
 * {@link #format(String)}メソッドで全角文字を半角文字に、大文字を小文字に等のフォーマットを行います。
 */
public interface StringFormat {

    /**
     * 引数で指定された文字列をフォーマットし、フォーマットされた文字列を返します。
     * 
     * @param string
     *            フォーマットするString
     * @return フォーマットされたString
     */
    public String format(String string);

    // factory
    /**
     * 全角のアルファベット、数字、記号、スペースを半角にフォーマットする{@link StringFormat}を返します。フォーマット対象の記号は
     * 「’, ”, ！, ＃, ＄, ％, ＆, （, ）, ＊, ＋, ，, －, ．, ／, ：, ；, ＜, ＝, ＞, ？, ＠, ［, ＼,
     * ］, ＾, ＿, ｀, ｛, ｜, ｝, ～」です。
     * フォーマット対象のスペースのUnicodeは「{@literal \}u3000」で、フォーマット後のスペースのUnicodeは「{@literal \}u0020」です。
     * 
     * @return 全角のアルファベット、数字、記号、スペースを半角にフォーマットする{@link StringFormat}
     */
    public static StringFormat getAlphabetNumberSymbolSpaceFullToHalfStringFormat() {
        return AlphabetNumberSymbolSpaceFullToHalf.getInstance();
    }

    /**
     * 半角のアルファベット、数字、記号、スペースを全角にフォーマットする{@link StringFormat}を返します。フォーマット対象の記号は
     * 「{@literal !, ", #, $, %, &, ', (, ), *, +, ,, -, ., /, :, ;, <, =, >,
     * ?, @, [, \, ], ^, _, `, {, |, }, ~}」です。
     * フォーマット対象のスペースのUnicodeは「{@literal \}u0020」で、フォーマット後のスペースのUnicodeは「{@literal \}u3000」です。
     * 
     * @return 半角のアルファベット、数字、記号、スペースを全角にフォーマットする{@link StringFormat}
     */
    public static StringFormat getAlphabetNumberSymbolSpaceHalfToFullStringFormat() {
        return AlphabetNumberSymbolSpaceHalfToFull.getInstance();
    }
}
