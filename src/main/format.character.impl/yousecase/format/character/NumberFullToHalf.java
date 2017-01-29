package yousecase.format.character;

import static yousecase.format.character.CharacterFormatConstants.*;

class NumberFullToHalf {
    private static enum NumberFullToHalfImpl implements CharacterFormat {
        INSTANCE;

        @Override
        public char format(char ch) {
            if ('０' <= ch && ch <= '９') {
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
        return NumberFullToHalfImpl.INSTANCE;
    }

    private NumberFullToHalf() {
    }
}
