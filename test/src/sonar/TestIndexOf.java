package sonar;

public class TestIndexOf {

	static String name = "ismael";

	public static void main(String[] args) {
		if (name.indexOf("ae") > 2) { // Noncompliant
			// ...
			System.out.println(name.indexOf("ae"));
		}
		
		System.out.println(name.indexOf("ae", 2));
	}

}
