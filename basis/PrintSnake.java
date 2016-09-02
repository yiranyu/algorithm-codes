package testing;

import java.util.Scanner;

public class PrintSnake {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		while (sc.hasNext()) {
			n = sc.nextInt();
			if (n > 0) {
				printNums(n);
			} else {
				System.out.println("�������");
			}
		}
		sc.close();
	}

	/**
	 * ���δ�ӡ����
	 * һ����ӡn/2Ȧ 
	 * 1.�����Ҵ�ӡһ�С� 
	 * 2.���ϵ��´�ӡһ�С� 
	 * 3.���ҵ����ӡһ�С� 
	 * 4.���µ��ϴ�ӡһ�С�
	 * ÿһ�ֲ�һ�������Ĳ������һȦֻ��һ���� ��һ��������Ҫ�ġ�
	 */
	public static void printNums(int n) {
		if (n < 1) {
			return;
		}
		if (n == 1) {
			System.out.println(1);
			return;
		}

		int start = 0, num = 0;
		while (n > 2 * start) { // ÿһȦ��һ����n/2Ȧ
			int endX = n - start - 1;
			int endY = n - start - 1;
			//�����Ҵ�ӡһ��
			for (int i = start; i <= endX; i++) {
				num++;
				System.out.print(num + " ");
			}
			//���һȦû������Ĵ�ӡ����
			if (endY > start) {
				//���ϵ��´�ӡһ��
				for (int i = start + 1; i <= endY; i++) {
					num += n;
					System.out.print(num + " ");
				}
				//���ҵ����ӡһ��
				for (int i = endX - 1; i >= start; i--) {
					num--;
					System.out.print(num + " ");
				}
				//���µ��ϴ�ӡһ��
				for (int i = endY - 1; i > start; i--) {
					num -= n;
					System.out.print(num + " ");
				}
			}
			start++;
		}
		System.out.println();
	}
}
