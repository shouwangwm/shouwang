package switch_;

public class SwitchTest {
	
	public static void main(String[] args) {
		test("a");
		test(1);
		test(SEnum.ONE);
		test('A');
		
		test("客户");
	}
	
	public static void test(String flag){
		switch(flag){
		case "a": 
			System.out.println("a");
			break;
		case "客户": 
			System.out.println("客户");
			break;	
		default:
			System.out.println("null");
		}
		
	}
	
	public static void test(int flag){
		switch(flag){
		case 1: 
			System.out.println("1");
			break;
		default:
			System.out.println("null");
		}
		
	}
	
	public static void test(SEnum flag){
		switch(flag){
		case ONE: 
			System.out.println("ONE");
			break;
		default:
			System.out.println("null");
		}
		
	}
	
	public static void test(char flag){
		switch(flag){
		case 'A': 
			System.out.println("A");
			break;
		default:
			System.out.println("null");
		}
		
	}
}
