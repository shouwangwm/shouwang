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
		System.out.println(map.hashCode());
		map.get(1);
		
		Map map2 = new LinkedHashMap();
		map2.put(22, "bbb");
		
		
		Map map3 = new TreeMap();
		map3.put(33, "ccc");
		
		Map map4 = new ConcurrentHashMap();
	}
}
