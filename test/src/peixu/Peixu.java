package peixu;

public class Peixu {

	public static void main(String[] args) {
		int num[] = new int[20];
		{
			System.out.println("���ɵ���������ǣ�");
			for (int i = 0; i < 20; i++) {
				num[i] = (int) (Math.random() * 100);
				System.out.print(num[i] + " ");
			}
			System.out.println();
		}
		
//		bubbleSort(num);
		bubbleSort2(num);
	}
	
	/**
	 * ð������
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
		System.out.println("ð�������");
		for(int i : num){
			System.out.print(i + " ");
		}
	}
	
	
	/**
	 * @author weiming
	 * @date   2017��2��15��
	 * @param arr
	 */
	public static void bubbleSort2(int[] arr){
		int temp;
		for(int i=0;i<arr.length - 1;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[j] < arr[i]){
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		System.out.println("ð�������");
		for(int i : arr){
			System.out.print(i + " ");
		}
	}
}
