package nowcoder;

public class LastRemaining {
	public static void main(String[] args) {
		System.out.println(lastRemaining2(5, 3));
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

	// ����ÿ�α�ɾ�������ֵĹ��ɲ�ֱ����������ʱ��Ч��O(n)���ռ临�Ӷ�(1)
	// ���ƹ�ʽn=1ʱ��f(n,m)=0;n>1ʱ��f(n,m)=[f(n-1,m)+m]%n;
	public static int lastRemaining2(int n, int m) {
		if (n <= 0 || m <= 0) {
			return -1;
		}
		if (n == 1) { // ������ֻ��һ������
			return 0;
		}
		int last = 0;
		for (int i = 2; i <= n; i++) {
			last = (last + m) % i;
		}
		return last;
	}
}
