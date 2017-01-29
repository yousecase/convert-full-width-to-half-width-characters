package yousecase.util;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class MapsTest {
    public static class SwapKeyValueTest {
        @Test
        public void testSwapKeyValue() {
            Map<Integer, String> map = new HashMap<>();
            map.put(1, "first");
            map.put(2, "second");
            map.put(3, "third");

            Map<String, Integer> expected = new HashMap<>();
            expected.put("first", 1);
            expected.put("second", 2);
            expected.put("third", 3);

            assertEquals(expected, Maps.swapKeyValue(map));
        }

        // Mapの値に重複がある
        @Test(expected = IllegalArgumentException.class)
        public void testSwapKeyValueException() {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(1, 1);
            map.put(2, 2);
            map.put(3, 3);// 3が重複
            map.put(4, 3);// 3が重複
            map.put(5, 5);
            Maps.swapKeyValue(map);
        }
    }
}
