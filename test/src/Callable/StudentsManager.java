package Callable;

import java.util.ArrayList;
import java.util.List;

public class StudentsManager {

	public static List<Student> all = new ArrayList<Student>();

	static{
		Student temp;
		for(int i = 0; i < 10; i++){
			temp = new Student();
			temp.setName("name-" + i);
			temp.setScore(i);
			temp.setClassLevel(1);
			all.add(temp);
		}
		
		for(int i = 10; i < 20; i++){
			temp = new Student();
			temp.setName("name-" + i);
			temp.setScore(i);
			temp.setClassLevel(2);
			all.add(temp);
		}
	}
}
