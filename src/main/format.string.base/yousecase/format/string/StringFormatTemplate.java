package yousecase.format.string;

import java.util.Objects;

import yousecase.format.character.CharacterFormat;
import yousecase.format.character.CharacterFormats;

// コンストラクタの引数で指定されたCharacterFormatのformatメソッドで文字列中のすべての文字をフォーマットするクラス
class StringFormatTemplate implements StringFormat {
    private CharacterFormat characterFormat;

    public StringFormatTemplate(CharacterFormat characterFormat) {
        Objects.requireNonNull(characterFormat);
        // deep copy
        this.characterFormat = CharacterFormats.optimize(characterFormat);
    }

    @Override
    public String format(String string) {
        Objects.requireNonNull(string);
        StringBuilder formatted = new StringBuilder(string.length());
        for (int i = 0; i < string.length(); i++) {
            formatted.append(characterFormat.format(string.charAt(i)));
        }
        return formatted.toString();
    }

    @Override
    public String toString() {
        return getClass().getName() + "{" + CharacterFormats.toString(characterFormat) + "}";
    }
}
