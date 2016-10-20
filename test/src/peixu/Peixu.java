package peixu;

public class Peixu {

	public static void main(String[] args) {
		int num[] = new int[20];
		{
			System.out.println("生成的随机数组是：");
			for (int i = 0; i < 20; i++) {
				num[i] = (int) (Math.random() * 100);
				System.out.print(num[i] + " ");
			}
			System.out.println();
		}
		
		bubbleSort(num);
	}
	
	/**
	 * 冒泡排序，
	 * @param num
	 */
	public static void bubbleSort(int[] num){
		int temp;
		for(int i=0;i<num.length - 1 ;i++){
			for(int j= i+1;j<num.length;j++){
				if(num[i] > num[j]){
					temp = num[j];
					num[j] = num[i];
					num[i] = temp;
				}
			}
		}
		System.out.println("冒泡排序后：");
		for(int i : num){
			System.out.print(i + " ");
		}
	}
}
