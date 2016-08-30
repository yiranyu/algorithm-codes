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
	 * �˿��Ƶ�˳�� ���˿����������5���ƣ��ж��ǲ���һ��˳�ӡ�2-10Ϊ���ֱ���AΪ1��JΪ11��QΪ12��KΪ13������С�����Կ����������֡�
	 * ˼·�����Ȱ�����������ͳ��������0�ĸ��������ͳ����������������������֮��Ŀ�ȱ����
	 */
	public static boolean isContinuous(int[] numbers) {
		if (numbers == null || numbers.length < 1) {
			return false;
		}
		// ����
		for (int i = 1; i < numbers.length; i++) {
			int j = i - 1;
			int cur = numbers[i];
			while (j >= 0 && numbers[j] > cur) {
				numbers[j + 1] = numbers[j];
				j--;
			}
			numbers[j + 1] = cur;
		}
		// ͳ��0�ĸ���
		int zero = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 0) {
				zero++;
			}
		}
		// ͳ����������������������֮��Ŀ�ȱ��
		int i = zero, j = i + 1, gap = 0;
		while (j < numbers.length) {
			if (numbers[i] == numbers[j]) { // ����������ͬ��������������˳��
				return false;
			}
			gap += numbers[j] - numbers[i] - 1;
			i = j;
			j++;
		}
		return gap > zero ? false : true;
	}
}
