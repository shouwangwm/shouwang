package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestList {

	public static void main(String[] args) {

		List list = new ArrayList();
		list.add(null);
		
		List<Integer> list2 = new LinkedList<Integer>();
		list2.add(1);
		list2.add(13);
		list2.add(33);
		list2.add(53);
		list2.add(43);
		System.out.println("linkedlist size :" + list2.size());
		System.out.println(list2.get(list2.size() - 3));
		
		for (int i : list2) {
			System.out.print(i + "-");
		}
		System.out.println("");
		
		
		List<String> collection1 = Collections.EMPTY_LIST;  // Noncompliant
		Map<String, String> collection2 = Collections.EMPTY_MAP;  // Noncompliant
		Set<String> collection3 = Collections.EMPTY_SET;  // Noncompliant
		
		List<String> _collection1 = Collections.emptyList();
		Map<String, String> _collection2 = Collections.emptyMap();
		Set<String> _collection3 = Collections.emptySet();

	}
}
