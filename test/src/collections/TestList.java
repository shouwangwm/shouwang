package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestList {

	public static void main(String[] args) {

		List list = new ArrayList();
		list.add(null);
		
		List<Integer> list2 = new LinkedList<Integer>();
		list2.add(1);
		list2.add(13);
		list2.add(33);
		list2.add(43);
		list2.add(53);
		System.out.println("linkedlist size :" + list2.size());
		System.out.println(list2.get(list2.size() - 3));
		
		for (int i : list2) {
			System.out.print(i + "-");
		}
		System.out.println("");

	}
}
