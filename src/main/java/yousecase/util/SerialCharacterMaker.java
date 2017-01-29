package yousecase.util;

import java.util.Arrays;
import java.util.Objects;

public class SerialCharacterMaker {
    private static final String ALL_CHARACTER_STRING = new String(newAllCharacterArray());
    // char[]は可変なのでキャッシュは不要

    /**
     * Unicodeの{@literal \}u0000から{@literal \}uffffまでの文字を順番に格納した配列を返します。
     * 
     * @return Unicodeの{@literal \}u0000から{@literal \}uffffまでの文字を順番に格納した配列
     */
    public static char[] newAllCharacterArray() {
        return newCharacterArray(Character.MIN_VALUE, Character.MAX_VALUE);
    }

    /**
     * Unicodeのbeginからendまでの文字を順番に格納した配列を返します。
     * 
     * @param begin
     *            格納される最初の文字
     * @param end
     *            格納される最後の文字
     * @return Unicodeのbeginからendまでの文字を順番に格納した配列
     * @throws IllegalArgumentException
     *             {@literal (end < begin)}の場合
     */
    public static char[] newCharacterArray(char begin, char end) {
        if (end < begin) {
            throw new IllegalArgumentException();
        }
        char[] arr = new char[end - begin + 1];
        int index = 0;
        for (int ch = begin; ch <= end; ch++) {
            arr[index++] = (char) ch;
        }
        return arr;
    }

    /**
     * 引数で指定されたchar[]の最後にUnicodeのbeginからendまでの文字を順番に追加した新しい配列を返します。
     * 
     * @param base
     *            文字列を追加するchar[]
     * @param begin
     *            追加される最初の文字
     * @param end
     *            追加される最後の文字
     * @return 引数で指定されたchar[]の最後にUnicodeのbeginからendまでの文字を順番に追加した新しい配列
     * @throws IllegalArgumentException
     *             {@literal (end < begin)}の場合
     */
    public static char[] append(char[] base, char begin, char end) {
        Objects.requireNonNull(base);
        if (end < begin) {
            throw new IllegalArgumentException();
        }
        int additionalLength = end - begin + 1;
        char[] arr = Arrays.copyOf(base, base.length + additionalLength);
        int index = base.length;
        for (int ch = begin; ch <= end; ch++) {
            arr[index++] = (char) ch;
        }
        return arr;
    }

    /**
     * Unicodeの{@literal \}u0000から{@literal \}uffffまでの文字が順番に連結された文字列を返します。
     * 
     * @return {@literal \}u0000から{@literal \}uffffまでの文字が順番に連結された文字列
     */
    public static String getAllCharacterString() {
        return ALL_CHARACTER_STRING;
    }

    /**
     * Unicodeのbeginからendまでの文字が順番に連結された文字列を返します。
     * 
     * @param begin
     *            連結される最初の文字
     * @param end
     *            連結される最後の文字
     * @return Unicodeのbeginからendまでの文字が順番に連結された文字列を返します。
     * @throws IllegalArgumentException
     *             {@literal (end < begin)}の場合
     */
    public static String newString(char begin, char end) {
        if (end < begin) {
            throw new IllegalArgumentException();
        }
        return new String(newCharacterArray(begin, end));
    }

    /**
     * 引数で指定された{@link StringBuilder}にUnicodeのbeginからendまでの文字を順番に追加します。
     * 
     * @param base
     *            文字列を追加する{@link StringBuilder}
     * @param begin
     *            追加される最初の文字
     * @param end
     *            追加される最後の文字
     * @return 引数で指定された範囲の文字が追加された{@link StringBuilder}
     * @throws IllegalArgumentException
     *             {@literal (end < begin)}の場合
     */
    public static StringBuilder append(StringBuilder base, char begin, char end) {
        Objects.requireNonNull(base);
        if (end < begin) {
            throw new IllegalArgumentException();
        }

        for (int ch = begin; ch <= end; ch++) {
            base.append((char) ch);
        }
        return base;
    }

    private SerialCharacterMaker() {
    }
}
