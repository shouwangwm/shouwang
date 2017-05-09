package collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class TestMap {

	public static void main(String[] args) {
		Map map = new HashMap();
		map.put(1, "aaa");
		
		System.out.println("hash:" + hash(1));
//		System.out.println(map.hashCode());
//		map.get(1);
//
//		Map map2 = new LinkedHashMap();
//		map2.put(22, "bbb");
//
//		Map map3 = new TreeMap();
//		map3.put(33, "ccc");
//
//		Map map4 = new ConcurrentHashMap();
	}

	private static int hash(Object k) {
		int h = 0;
		if (0 != h && k instanceof String) {
			return sun.misc.Hashing.stringHash32((String) k);
		}

		h ^= k.hashCode();

		// This function ensures that hashCodes that differ only by
		// constant multiples at each bit position have a bounded
		// number of collisions (approximately 8 at default load factor).
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ (h >>> 4);
	}
}
