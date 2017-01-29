package yousecase.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * {@link Map}のユーティリティクラスです。
 */
public class Maps {

    /**
     * 引数で指定された{@link Map}のキーと値を入れ替えた{@link Map}を返します。
     * 引数で指定された{@link Map}の値に重複がある場合、例外が発生します。
     * 
     * @param <K>
     *            マップで保持されているキーの型
     * @param <V>
     *            マップされている値の型
     * @param map
     *            キーと値を入れ替える{@link Map}
     * @return 引数で指定された{@link Map}のキーと値を入れ替えた{@link Map}
     * @throws IllegalArgumentException
     *             引数で指定された{@link Map}の値に重複がある場合
     */
    public static <K, V> Map<V, K> swapKeyValue(Map<K, V> map) {
        Map<V, K> swappedMap = new HashMap<>(map.size());
        for (Entry<K, V> entry : map.entrySet()) {
            swappedMap.put(entry.getValue(), entry.getKey());
        }
        if (map.size() != swappedMap.size()) {
            throw new IllegalArgumentException("引数のMapの値に重複があります。");
        }
        return swappedMap;
    }

    private Maps() {
    }
}
