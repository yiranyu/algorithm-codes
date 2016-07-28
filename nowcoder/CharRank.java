package nowcoder;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 字符串的排列 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。 结果请按字母顺序输出。
 * 输入描述:输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * 
 * @author lab2015
 * 
 */
public class CharRank {
	public static void main(String[] args) {
		String str="abc";
		ArrayList<String> list=permutation(str);
		System.out.println(list.size());
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
	public static ArrayList<String> permutation(String str) {
		ArrayList<String> list = new ArrayList<String>();
		int length = str.length();
		char[] array = str.toCharArray();
		if (str == null || str.length() == 0) {
			return list;
		}

		permutation(list, array, 0, length);
		Collections.sort(list); // 按字母顺序输出
		return list;
	}
	/**
	 * 把字符串分为两个部分，一部分是字符串的第一个字符，另一个部分是第一个字符以后的所有字符；
	 * 求第二部分字符串的排列；
	 * 拿第一个字符和它后边的字符逐个交换后求。
	 */
	public static void permutation(ArrayList<String> list, char[] array,
			int begin, int end) {
		//如果只剩下最后一个字符
		if (begin == end - 1) {
			String result = new String(array);
			if (!list.contains(result)) {
				list.add(result);
				System.out.println(result);
			}
		} else {
			//第一个字符和它后边的字符逐个交换
			char temp = array[begin];
			for (int i = begin; i < end; i++) {
				// begin <-> i
				array[begin] = array[i];
				array[i] = temp;
				//交换后排列
				permutation(list, array, begin + 1, end);
				//复位
				temp = array[i];
				array[i] = array[begin];
				array[begin] = temp;
			}
		}
	}
}
