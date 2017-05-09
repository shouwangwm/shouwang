package Callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Worker implements Callable<Integer> {

	/**
	 * Äê¼¶
	 */
	private int classLevel;
	public Worker(int classLevel) {
		this.classLevel = classLevel;
	}
	@Override
	public Integer call() throws Exception {
		int score = 0;
		for (Student s : StudentsManager.all) {
			if (s.getClassLevel() == classLevel) {
				score += s.getScore();
			}
		}
		return score;
	}

}
