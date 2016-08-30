package nowcoder;

public class LastRemaining {
	public static void main(String[] args) {
		System.out.println(lastRemaining(5, 3));
	}

	/**
	 * ԲȦ�����ʣ�µ�����Լɪ�����⣩
	 * 0��������n-1��n�������ų�һ��ԲȦ��������0��ʼÿ�δ����ԲȦ��ɾ����m�����֣�������ԲȦ��ʣ�µ����һ�����֡�
	 * ˼·��1.�û�������ģ��ԲȦ 2.����ÿ�α�ɾ�������ֵĹ��ɲ�ֱ����������
	 */
	// �û�������ģ��ԲȦ��ʱ��Ч��O(nm)���ռ临�Ӷ�(n)
	public static int lastRemaining(int n, int m) {
		if (n <= 0 || m <= 0) {
			return -1;
		}
		int[] list = new int[n];
		int count = n; // ʣ�µ�Ԫ�ظ���
		int step = 0, i = -1;
		while (count > 0) {
			i++; // ��ǰָ�����
			if (i >= n) { // ��ͷ��ʼ
				i = 0;
			}
			if (list[i] != -1) {
				step++; // ���Ӳ���
				if (step == m) { // �ҵ�Ҫɾ������
					list[i] = -1; // ɾ��
					step = 0;
					count--; // ����ʣ�µ�Ԫ�ظ���
				}
			}
		}
		return i;
	}
}
