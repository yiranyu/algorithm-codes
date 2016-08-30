package nowcoder;

public class IsContinuous {
	public static void main(String[] args) {
		int[] a = { 1, 0, 4, 8, 2 };
		System.out.println(isContinuous(a));
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	/**
	 * 扑克牌的顺子 从扑克牌中随机抽5张牌，判断是不是一个顺子。2-10为数字本身，A为1，J为11，Q为12，K为13，而大小王可以看成任意数字。
	 * 思路：首先把数组排序，再统计数组中0的个数，最后统计排序后的数组中相邻数字之间的空缺数。
	 */
	public static boolean isContinuous(int[] numbers) {
		if (numbers == null || numbers.length < 1) {
			return false;
		}
		// 排序
		for (int i = 1; i < numbers.length; i++) {
			int j = i - 1;
			int cur = numbers[i];
			while (j >= 0 && numbers[j] > cur) {
				numbers[j + 1] = numbers[j];
				j--;
			}
			numbers[j + 1] = cur;
		}
		// 统计0的个数
		int zero = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 0) {
				zero++;
			}
		}
		// 统计排序后的数组中相邻数字之间的空缺数
		int i = zero, j = i + 1, gap = 0;
		while (j < numbers.length) {
			if (numbers[i] == numbers[j]) { // 出现两个相同的数，不可能是顺子
				return false;
			}
			gap += numbers[j] - numbers[i] - 1;
			i = j;
			j++;
		}
		return gap > zero ? false : true;
	}
}
