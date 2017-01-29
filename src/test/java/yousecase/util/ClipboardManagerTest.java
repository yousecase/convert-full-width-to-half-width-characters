package yousecase.util;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class ClipboardManagerTest {
    @Test
    public void testSetStringGetString() throws IOException {
        for (int unicode = Character.MIN_VALUE; unicode <= Character.MAX_VALUE; unicode++) {
            String set = String.valueOf((char) unicode);
            ClipboardManager.setString(set);
            String get = ClipboardManager.getString();
            assertEquals(set, get);
        }
    }
}
