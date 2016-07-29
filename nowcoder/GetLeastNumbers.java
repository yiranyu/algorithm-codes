package nowcoder;

import java.util.ArrayList;

/**
 * 最小的K个数 ： 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
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
	 * 用冒泡排序找到前k个小的数，这种解法会修改输入的数组
	 * 
	 * @param input
	 * @param k
	 * @return
	 */
	public static ArrayList<Integer> getLeastNumbers(int[] input, int k) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int len = input.length;
		// 条件判断
		if (input == null || input.length <= 0) {
			return result;
		}
		if (len < k || k <= 0) {
			return result;
		}

		int item, index;
		for (int i = 0; i < k; i++) {// 只找前k个
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
	 * 基于快速排序：如果基于数组的第k个数字来调整，使得比第k个数字小的所有数字都位于数组的左边， 比第k个数字大的所有数字都位于数组的右边。
	 * 这种调整得到的数不一定是排序的，而且这种方式也会修改原数组
	 * 
	 * @param input
	 * @param k
	 * @return
	 */
	public static ArrayList<Integer> getLeastNumbers2(int[] input, int k) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int len = input.length;
		// 条件判断
		if (input == null || input.length <= 0 || len < k || k <= 0) {
			return result;
		}

		int index = partition(input, 0, len - 1); // 拆分一次
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
	 * 快速排序的拆分数组函数，返回基数所在的下标
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
		int index = data[i]; // 选择基数

		while (i < j) {
			// 在右边找到一个比基数小的
			while (i < j && data[j] >= index) {
				j--;
			}
			// 找到放到左边
			if (i < j) {
				data[i++] = data[j];
			}
			// 在左边找到一个比基数大的
			while (i < j && data[i] < index) {
				i++;
			}
			// 找到放右边
			if (i < j) {
				data[j--] = data[i];
			}
		}
		data[i] = index;
		return i;
	}

	/**
	 * 冒泡排序
	 * 
	 * @param array
	 */
	public static void bubbleSort(int[] array) {
		if (array == null || array.length <= 0) {
			return;
		}
		int len = array.length;
		int item, index;
		for (int i = 0; i < len - 1; i++) { // 最后一次不需要
			item = array[len - 1];
			index = len - 1;
			for (int j = len - 2; j >= i; j--) { // 从后边往前面找最小的一个数
				if (array[j] < item) {
					item = array[j];
					index = j;
				}
			}
			// 交换
			array[index] = array[i];
			array[i] = item;
		}
	}
}