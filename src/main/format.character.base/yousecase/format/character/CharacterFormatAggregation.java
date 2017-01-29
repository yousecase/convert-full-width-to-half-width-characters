package yousecase.format.character;

import java.util.Objects;

// 複数のCharacterFormatをつなぎ合わせて1つのCharacterFormatにするクラス
// 各CharacterFormatがフォーマットする文字が重複していた場合、
// コンストラクタで一番先に指定したCharacterFormatでフォーマットされる
// CharacterFormats#connectで利用されoptimizeされるので引数の防御的コピーはしない
class CharacterFormatAggregation implements CharacterFormat {
    private CharacterFormat[] characterFormats;

    CharacterFormatAggregation(CharacterFormat... characterFormats) {
        Objects.requireNonNull(characterFormats);
        if (characterFormats.length == 0) {
            throw new IllegalArgumentException();
        }
        for (CharacterFormat characterFormat : characterFormats) {
            Objects.requireNonNull(characterFormat);
        }
        this.characterFormats = characterFormats;
    }

    @Override
    public char format(char ch) {
        for (CharacterFormat characterFormat : characterFormats) {
            char formattedCh = characterFormat.format(ch);
            if (formattedCh != ch) {// フォーマットされた
                return formattedCh;
            }
        }
        return ch;
    }

    @Override
    public String toString() {
        return CharacterFormats.toString(this);
    }
}
