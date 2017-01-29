package yousecase.format.character;

class AlphabetHalfToFull {
    private static final CharacterFormat instance = CharacterFormats
            .newReversedCharacterFormat(AlphabetFullToHalf.getInstance());

    static CharacterFormat getInstance() {
        return instance;
    }

    private AlphabetHalfToFull() {
    }
}
