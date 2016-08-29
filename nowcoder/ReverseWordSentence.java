package nowcoder;

public class ReverseWordSentence {
	public static void main(String[] args) {
		String str = "This is a test.";
		System.out.println(reverseSentence(str));
	}

	/**
	 * ��ת����˳���� ����һ��Ӣ�ľ��ӣ���ת�����е��ʵ�˳�򣬵��������ַ���˳�򲻱䣬�����ź���ͨ��ĸһ������ ˼·��1.ֱ�ӷ�ת���ʡ� 2.
	 * ��ת���������е��ַ����ٷ�ת�����е�ÿ�����ʡ�
	 */

	public static String reverseSentence(String str) {
		if (str == null || str.length() < 2) {
			return str;
		}
		String[] s = str.split(" ");// ֱ�ӷָ�����
		int len = s.length;
		if (len < 1) {
			return str;
		}
		int start = 0, end = len - 1;
		// ��ת
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
