package nowcoder;

/**
 * 连续子数组的最大和
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,
 * 他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。你会不会被他忽悠住？
 * 
 * @author lab2015
 * 
 */
public class FindGreatestSumOfSubArray {
	public static void main(String[] args) {
		int array[] = { 1, -2, 3, 10, -4, 7, 2, -5 };
		System.out.println(gindGreatestSumOfSubArray2(array));
	}

	/**
	 * （1）直观算法：枚举数组的所有子数组并求出它们的和，大小为n的数组共有n(n+1)/2个子数组，时间复杂度为哦（n^2）
	 * （2）分析数组的规律：从头到尾累加数组中的每个数字，遍历到某一个元素时，如果当前的累加和小于零，也就是说之前的累加和比当前元素的值小，
	 * 那么我们就没有必要保留前面的子数组了。
	 * 本算法实现解法（2）
	 * @param array
	 * @return
	 */
	public static int gindGreatestSumOfSubArray(int[] array) {
		if (array == null || array.length <= 0) {
			return 0; // 如果输出0，如何区分是无效输入还是累加和为0？
		}
		int sum = 0, greatestSum = 0x80000000; // 累加和，最大累加和
		int len = array.length;
	
		for (int i = 0; i < len; i++) {
			if (sum <= 0) { // 当前和小于零时抛弃前面的子数组
				sum = array[i];
			} else { // 累加
				sum += array[i];
			}
			// 更新最大累加和
			if (sum > greatestSum) {
				greatestSum = sum;
			}
		}
		return greatestSum;
	}
	
	/**
	 * 动态规划法：f(i)表示以第i个数字结尾的子数组的最大和
	 *  f(i)=array[i] i=0或者f(i-1)<=0 
	 *       f(i-1)+array[i]
	 * i不等于0并且f(i-1)>0 和上一个算法一样的思路。
	 * 
	 * @param array
	 * @return
	 */
	public static int gindGreatestSumOfSubArray2(int[] array) {
		if (array == null || array.length <= 0) {
			return 0; // 如果输出0，如何区分是无效输入还是累加和为0？
		}
		int fi = 0, maxFi = 0x80000000; // 累加和，最大累加和
		int len = array.length;
		int i = 0;
		while (i < len) {
			if (fi <= 0) { // 当前和小于零时抛弃前面的子数组
				fi = array[i];
			} else { // 累加
				fi += array[i];
			}
			// 更新最大累加和
			if (fi > maxFi) {
				maxFi = fi;
			}
			i++;
		}
		return maxFi;
	}
}
