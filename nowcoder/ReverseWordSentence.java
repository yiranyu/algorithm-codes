package nowcoder;

public class ReverseWordSentence {
	public static void main(String[] args) {
		String str = "This is a test.";
		System.out.println(reverseSentence(str));
	}

	/**
	 * 翻转单词顺序列 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变，标点符号和普通字母一样处理。 思路：1.直接翻转单词。 2.
	 * 翻转句子中所有的字符，再翻转句子中的每个单词。
	 */

	public static String reverseSentence(String str) {
		if (str == null || str.length() < 2) {
			return str;
		}
		String[] s = str.split(" ");// 直接分隔单词
		int len = s.length;
		if (len < 1) {
			return str;
		}
		int start = 0, end = len - 1;
		// 翻转
		while (start < end) {
			String temp = s[start];
			s[start] = s[end];
			s[end] = temp;
			start++;
			end--;
		}
		String result = s[0];
		for (int i = 1; i < len; i++) {
			result += " " + s[i];
		}
		return result;
	}

}
