package yousecase.util;

import static org.junit.Assert.*;
import static yousecase.util.SerialCharacterMaker.*;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class SerialCharacterMakerTest {
    private static final int ALPHABET_COUNT = 26;

    // 配列を返すメソッド
    @RunWith(Enclosed.class)
    public static class ArrayMethodTest {
        public static class NewAllCharacterArrayTest {
            @Test
            public void testNewAllCharacterArray() {
                char[] arr = newAllCharacterArray();
                for (int ch = Character.MIN_VALUE; ch <= Character.MAX_VALUE; ch++) {
                    assertEquals(ch, arr[ch]);
                }
                assertEquals(arr.length, Character.MAX_VALUE + 1);
            }
        }

        public static class NewCharacterArrayTest {
            @Test
            public void testNewCharacterArray() {
                char[] arr = newCharacterArray('a', 'z');
                int index = 0;
                for (int ch = 'a'; ch <= 'z'; ch++) {
                    assertEquals(ch, arr[index++]);
                }
                assertEquals(arr.length, ALPHABET_COUNT);
            }

            // beginとendが同じ場合はbeginで指定した文字が追加される
            @Test
            public void testNewCharacterArraySameValue() {
                char[] arr = newCharacterArray('a', 'a');
                assertArrayEquals(new char[] { 'a' }, arr);
            }

            // 不正な引数のテスト end < begin
            @Test(expected = IllegalArgumentException.class)
            public void testNewCharacterArrayIllegalArgumentException() {
                newCharacterArray('b', 'a');
            }
        }

        public static class AppendTest {
            @Test
            public void testAppend() {
                char[] base = newCharacterArray('a', 'e');
                char[] arr = append(base, 'f', 'z');
                int index = 0;
                for (int ch = 'a'; ch <= 'z'; ch++) {
                    assertEquals(ch, arr[index++]);
                }
                assertEquals(arr.length, ALPHABET_COUNT);
            }

            // beginとendが同じ場合はbeginで指定した文字が追加される
            @Test
            public void testAppendSameValue() {
                {
                    char[] arr = append(new char[0], 'a', 'a');
                    assertArrayEquals(new char[] { 'a' }, arr);
                }
                {
                    char[] base = { 'a', 'b' };
                    char[] arr = append(base, 'c', 'c');
                    assertArrayEquals(new char[] { 'a', 'b', 'c' }, arr);
                }
            }

            // 不正な引数のテスト end < begin
            @Test(expected = IllegalArgumentException.class)
            public void testAppendIllegalArgumentException() {
                append(new char[0], 'b', 'a');
            }
        }
    }

    // String(Builder)を返すメソッド
    @RunWith(Enclosed.class)
    public static class StringMethodTest {
        public static class GetAllCharacterStringTest {
            @Test
            public void testGetAllCharacterString() {
                String string = getAllCharacterString();
                for (int ch = Character.MIN_VALUE; ch <= Character.MAX_VALUE; ch++) {
                    assertEquals(ch, string.charAt(ch));
                }
                assertEquals(string.length(), Character.MAX_VALUE + 1);
            }
        }

        public static class NewStringTest {
            @Test
            public void testNewString() {
                String string = newString('a', 'z');
                int index = 0;
                for (int ch = 'a'; ch <= 'z'; ch++) {
                    assertEquals(ch, string.charAt(index++));
                }
                assertEquals(string.length(), ALPHABET_COUNT);
            }

            // beginとendが同じ場合はbeginで指定した文字が追加される
            @Test
            public void testNewStringSameValue() {
                String result = newString('a', 'a');
                assertEquals("a", result);
            }

            // 不正な引数のテスト end < begin
            @Test(expected = IllegalArgumentException.class)
            public void testNewStringIllegalArgumentException() {
                newString('z', 'a');
            }
        }

        public static class AppendTest {
            @Test
            public void testAppend() {
                StringBuilder builder = new StringBuilder("abcde");
                append(builder, 'f', 'z');
                String string = builder.toString();
                int index = 0;
                for (int ch = 'a'; ch <= 'z'; ch++) {
                    assertEquals(ch, string.charAt(index++));
                }
                assertEquals(string.length(), ALPHABET_COUNT);
            }

            // beginとendが同じ場合はbeginで指定した文字が追加される
            @Test
            public void testAppendSameValue() {
                StringBuilder builder = new StringBuilder();
                append(builder, 'a', 'a');
                assertEquals("a", builder.toString());
            }

            // 不正な引数のテスト end < begin
            @Test(expected = IllegalArgumentException.class)
            public void testAppendIllegalArgumentException() {
                append(new StringBuilder(), 'z', 'a');
            }
        }
    }
}
