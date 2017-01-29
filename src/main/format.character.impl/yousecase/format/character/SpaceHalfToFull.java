package yousecase.format.character;

/**
 * 半角のスペースを全角にフォーマットする{@link CharacterFormat}を保持しているクラスです。
 * フォーマット対象のスペースのUnicodeは「{@literal \}u0020」で、フォーマット後のスペースのUnicodeは「{@literal \}u3000」です。
 */
class SpaceHalfToFull {
    private static final CharacterFormat instance = CharacterFormats
            .newReversedCharacterFormat(SpaceFullToHalf.getInstance());

    static CharacterFormat getInstance() {
        return instance;
    }

    private SpaceHalfToFull() {
    }
}
