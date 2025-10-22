package Collections;

import java.util.LinkedHashMap;
import java.util.Map;

class LruCache<K, V> extends LinkedHashMap<K, V> {
    int size;

    LruCache(int initialSize, float ff, int size) {
        super(initialSize, ff, true);
        this.size = size;
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return this.size() > size;
    }

}

public class LruRunner {
    public static void main(String[] args) {
        LruCache<String, Integer> lru = new LruCache<String, Integer>(16, 0.75f, 3);
        lru.put("Subham", 1);
        lru.put("m", 3);

        lru.put("r", 4);
        System.out.println(lru);
        lru.get("Subham");
        System.out.println(lru);
        lru.put("t", 41);
        System.out.println(lru);

    }

}
