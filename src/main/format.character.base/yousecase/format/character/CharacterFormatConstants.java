package yousecase.format.character;

class CharacterFormatConstants {

    // Unicodeの全角の「Ａ」と半角の「A」の差。
    // 全角英数字のUnicodeからこの値を引くと半角英数字のUnicodeになり、
    // 半角英数字のUnicodeにこの値を足すと全角英数字のUnicodeになる。
    public static final int UNICODE_DISTANCE = 'Ａ' - 'A';
}
