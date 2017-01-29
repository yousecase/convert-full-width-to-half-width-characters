package yousecase.format.character;

/**
 * 全角のスペースを半角にフォーマットする{@link CharacterFormat}を保持しているクラスです。
 * フォーマット対象のスペースのUnicodeは「{@literal \}u3000」で、フォーマット後のスペースのUnicodeは「{@literal \}u0020」です。
 */
class SpaceFullToHalf {
    private static enum SpaceFullToHalfImpl implements CharacterFormat {
        INSTANCE;

        @Override
        public char format(char ch) {
            if (ch == '　') {
                return ' ';
            }
            return ch;
        }

        @Override
        public String toString() {
            return CharacterFormats.toString(this);
        }
    }

    static CharacterFormat getInstance() {
        return SpaceFullToHalfImpl.INSTANCE;
    }

    private SpaceFullToHalf() {
    }
}
