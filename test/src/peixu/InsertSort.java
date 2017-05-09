package peixu;

public class InsertSort {

	public static void main(String[] args) {
		int[] a = { 11, 3, 4, 22, 52, 55, 3, 8, 7, 9 };
		
		insertSort(a);
		insertSort2(a);
	}

	/**
	 * ��������
	 * 
	 * �ӵ�һ��Ԫ�ؿ�ʼ����Ԫ�ؿ�����Ϊ�Ѿ������� ȡ����һ��Ԫ�أ����Ѿ������Ԫ�������дӺ���ǰɨ��
	 * �����Ԫ�أ������򣩴�����Ԫ�أ�����Ԫ���Ƶ���һλ�� �ظ�����3��ֱ���ҵ��������Ԫ��С�ڻ��ߵ�����Ԫ�ص�λ�� ����Ԫ�ز��뵽��λ���� �ظ�����2
	 * 
	 * @param numbers
	 *            ����������
	 */
	public static void insertSort(int[] numbers) {
		int size = numbers.length;
		int temp = 0;
		int j = 0;

		for (int i = 0; i < size; i++) {
			temp = numbers[i];
			// ����temp��ǰ���ֵС����ǰ���ֵ����
			for (j = i; j > 0 && temp < numbers[j - 1]; j--) {
				numbers[j] = numbers[j - 1];
			}
			
			numbers[j] = temp;
		}
		
		System.out.println("insertSort��");
		for(int i : numbers){
			System.out.print(i + " ");
		}
		
		System.out.println("");
	}
	
	/**
	 * @author weiming
	 * @date   2017��2��15��
	 * @param arr
	 */
	public static void insertSort2(int[] arr){
		int temp = 0;
		int j = 0;
		int size = arr.length;
		for(int i=0;i < size;i++){
			temp = arr[i];
			for(j = i;j > 0 && temp < arr[j - 1];j--){
				arr[j] = arr[j - 1];
			}
			arr[j] = temp;
		}
		
		System.out.println("insertSort2��");
		for(int i : arr){
			System.out.print(i + " ");
		}
	}
}
