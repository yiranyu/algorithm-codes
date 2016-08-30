package nowcoder;

public class LastRemaining {
	public static void main(String[] args) {
		System.out.println(lastRemaining2(5, 3));
	}

	/**
	 * 圆圈中最后剩下的数（约瑟夫环问题）
	 * 0，……，n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里删除第m个数字，求出这个圆圈里剩下的最后一个数字。
	 * 思路：1.用环形链表模拟圆圈 2.分析每次被删除的数字的规律并直接算出结果。
	 */
	// 用环形链表模拟圆圈，时间效率O(nm)，空间复杂度(n)
	public static int lastRemaining(int n, int m) {
		if (n <= 0 || m <= 0) {
			return -1;
		}
		int[] list = new int[n];
		int count = n; // 剩下的元素个数
		int step = 0, i = -1;
		while (count > 0) {
			i++; // 当前指向的数
			if (i >= n) { // 从头开始
				i = 0;
			}
			if (list[i] != -1) {
				step++; // 增加步数
				if (step == m) { // 找到要删除的数
					list[i] = -1; // 删除
					step = 0;
					count--; // 更新剩下的元素个数
				}
			}
		}
		return i;
	}

	// 分析每次被删除的数字的规律并直接算出结果，时间效率O(n)，空间复杂度(1)
	// 递推公式n=1时，f(n,m)=0;n>1时，f(n,m)=[f(n-1,m)+m]%n;
	public static int lastRemaining2(int n, int m) {
		if (n <= 0 || m <= 0) {
			return -1;
		}
		if (n == 1) { // 序列中只有一个数字
			return 0;
		}
		int last = 0;
		for (int i = 2; i <= n; i++) {
			last = (last + m) % i;
		}
		return last;
	}
}
