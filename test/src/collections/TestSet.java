package collections;

import java.util.HashSet;
import java.util.Set;

public class TestSet {
	
	public static void main(String[] args) {
		
		//HashSet�ڲ�����HashMapʵ�ֵ�
		Set set = new HashSet();
//		set.add(null);
		
		set.add(new Person("aaa"));
		set.add(new Person("bbb"));
		set.add(new Person("ccc"));
		set.add(new Person("aaa"));
		set.add(new Person("bbb"));
		
		System.out.println(set.size());
		
		
	}
}
