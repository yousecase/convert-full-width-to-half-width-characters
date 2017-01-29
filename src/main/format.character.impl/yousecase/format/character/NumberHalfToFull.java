package yousecase.format.character;

class NumberHalfToFull {
    private static final CharacterFormat instance = CharacterFormats
            .newReversedCharacterFormat(NumberFullToHalf.getInstance());

    static CharacterFormat getInstance() {
        return instance;
    }

    private NumberHalfToFull() {
    }
}
