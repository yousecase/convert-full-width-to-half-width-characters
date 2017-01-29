package yousecase.format.character;

import static yousecase.format.character.CharacterFormatConstants.*;

class AlphabetFullToHalf {
    private static enum AlphabetFullToHalfImpl implements CharacterFormat {
        INSTANCE;

        @Override
        public char format(char ch) {
            if (('Ａ' <= ch && ch <= 'Ｚ') || ('ａ' <= ch && ch <= 'ｚ')) {
                return (char) (ch - UNICODE_DISTANCE);
            }
            return ch;
        }

        @Override
        public String toString() {
            return CharacterFormats.toString(this);
        }
    }

    static CharacterFormat getInstance() {
        return AlphabetFullToHalfImpl.INSTANCE;
    }

    private AlphabetFullToHalf() {
    }
}
