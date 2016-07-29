package nowcoder;

import java.util.ArrayList;

/**
 * ��С��K���� �� ����n���������ҳ�������С��K��������������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4,��
 * 
 * @author lab2015
 * 
 */
public class GetLeastNumbers {
	public static void main(String[] args) {
		int array[] = { 5, 3, 4, 2, 2, 6, 3, 8 };

		ArrayList<Integer> list = getLeastNumbers(array, 4);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}

	/**
	 * ��ð�������ҵ�ǰk��С���������ֽⷨ���޸����������
	 * 
	 * @param input
	 * @param k
	 * @return
	 */
	public static ArrayList<Integer> getLeastNumbers(int[] input, int k) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int len = input.length;
		// �����ж�
		if (input == null || input.length <= 0) {
			return result;
		}
		if (len < k || k <= 0) {
			return result;
		}

		int item, index;
		for (int i = 0; i < k; i++) {// ֻ��ǰk��
			item = input[len - 1];
			index = len - 1;
			for (int j = len - 2; j >= i; j--) {
				if (input[j] < item) {
					item = input[j];
					index = j;
				}
			}
			input[index] = input[i];
			input[i] = item;
			result.add(item);
		}
		return result;
	}

	/**
	 * ���ڿ������������������ĵ�k��������������ʹ�ñȵ�k������С���������ֶ�λ���������ߣ� �ȵ�k�����ִ���������ֶ�λ��������ұߡ�
	 * ���ֵ����õ�������һ��������ģ��������ַ�ʽҲ���޸�ԭ����
	 * 
	 * @param input
	 * @param k
	 * @return
	 */
	public static ArrayList<Integer> getLeastNumbers2(int[] input, int k) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int len = input.length;
		// �����ж�
		if (input == null || input.length <= 0 || len < k || k <= 0) {
			return result;
		}

		int index = partition(input, 0, len - 1); // ���һ��
		while (index != k - 1) {
			if (index > k - 1) {
				index = partition(input, 0, index - 1);
			} else {
				index = partition(input, index + 1, len - 1);
			}
		}
		for (int i = 0; i < k; i++) {
			result.add(input[i]);
		}

		return result;
	}

	/**
	 * ��������Ĳ�����麯�������ػ������ڵ��±�
	 * 
	 * @param data
	 * @param start
	 * @param end
	 * @return
	 */
	public static int partition(int[] data, int start, int end) {
		int len = data.length;
		if (data == null || len <= 0 || start < 0 || end >= len) {
			return -1;
		}
		int i = start, j = end;
		int index = data[i]; // ѡ�����

		while (i < j) {
			// ���ұ��ҵ�һ���Ȼ���С��
			while (i < j && data[j] >= index) {
				j--;
			}
			// �ҵ��ŵ����
			if (i < j) {
				data[i++] = data[j];
			}
			// ������ҵ�һ���Ȼ������
			while (i < j && data[i] < index) {
				i++;
			}
			// �ҵ����ұ�
			if (i < j) {
				data[j--] = data[i];
			}
		}
		data[i] = index;
		return i;
	}

	/**
	 * ð������
	 * 
	 * @param array
	 */
	public static void bubbleSort(int[] array) {
		if (array == null || array.length <= 0) {
			return;
		}
		int len = array.length;
		int item, index;
		for (int i = 0; i < len - 1; i++) { // ���һ�β���Ҫ
			item = array[len - 1];
			index = len - 1;
			for (int j = len - 2; j >= i; j--) { // �Ӻ����ǰ������С��һ����
				if (array[j] < item) {
					item = array[j];
					index = j;
				}
			}
			// ����
			array[index] = array[i];
			array[i] = item;
		}
	}
}