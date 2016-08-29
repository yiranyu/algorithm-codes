package nowcoder;

public class LeftRotateString {
	public static void main(String[] args) {
		String str = "abcABC123";
		System.out.println(leftRotateString(str, 3));
	}

	/**
	 * 左旋转字符串 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
	 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
	 * 思路：先翻转字符串的前面n个字符，然后翻转字符串后面部分，最后翻转整个字符串。
	 */
	public static String leftRotateString(String str, int n) {
		if (str == null || str.length() < 2 || n < 1) {
			return str;
		}
		char[] s = str.toCharArray();
		int len = s.length;
		// 翻转前面n个字符
		reverse(s, 0, n - 1);
		// 翻转字符后面部分
		reverse(s, n, len - 1);
		// 翻转整个字符串
		reverse(s, 0, len - 1);
		return new String(s);
	}

	// 翻转函数
	public static void reverse(char[] s, int start, int end) {
		if (s == null || s.length < 2) {
			return;
		}
		while (start < end) {
			char temp = s[end];
			s[end] = s[start];
			s[start] = temp;
			start++;
			end--;
		}
	}

}
