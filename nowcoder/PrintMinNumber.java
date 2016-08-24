package nowcoder;

import java.util.Arrays;
import java.util.Comparator;

public class PrintMinNumber {
	public static void main(String[] args) {
		int array[]={123,3,4,12};
		System.out.println(printMinNumber(array));
	}
	/**
	 * 把数组排成最小的数
	 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
	 * 打印能拼接出的所有数字中最小的一个。
	 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
	 * 考查：新的比较规则，大数问题（用int可能导致溢出）
	 * 思路：把数字转换成字符串再比较拼接。
	 * 排序规则如下：
	 * 若ab > ba 则 a > b，
	 * 若ab < ba 则 a < b，
	 * 若ab = ba 则 a = b；
	 */
	 public static String printMinNumber(int [] numbers) {
		 if(numbers==null||numbers.length<1){
			 return "";
		 }
		 int len=numbers.length;
		 String nums[]=new String[len];
		 
		 for(int i=0;i<len;i++){
			 nums[i]=String.valueOf(numbers[i]);
		 }
		 //按编码比较字符串数组
		 Arrays.sort(nums, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return (s1+s1).compareTo(s2+s1); //比较函数，注意连接字符串后再比较
			}
		});
		 String result=nums[0];
		 for(int i=1;i<len;i++){
			 result+=nums[i];
		 }
		 return result;
	 }
}
