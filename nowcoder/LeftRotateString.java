package nowcoder;

public class LeftRotateString {
	public static void main(String[] args) {
		String str = "abcABC123";
		System.out.println(leftRotateString(str, 3));
	}

	/**
	 * ����ת�ַ��� ����һ���������ַ�����S���������ѭ������Kλ������������
	 * ���磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc����
	 * ˼·���ȷ�ת�ַ�����ǰ��n���ַ���Ȼ��ת�ַ������沿�֣����ת�����ַ�����
	 */
	public static String leftRotateString(String str, int n) {
		if (str == null || str.length() < 2 || n < 1) {
			return str;
		}
		char[] s = str.toCharArray();
		int len = s.length;
		// ��תǰ��n���ַ�
		reverse(s, 0, n - 1);
		// ��ת�ַ����沿��
		reverse(s, n, len - 1);
		// ��ת�����ַ���
		reverse(s, 0, len - 1);
		return new String(s);
	}

	// ��ת����
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
