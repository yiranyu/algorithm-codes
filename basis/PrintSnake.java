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
				System.out.println("输入错误");
			}
		}
		sc.close();
	}

	/**
	 * 蛇形打印矩阵
	 * 一共打印n/2圈 
	 * 1.从左到右打印一行。 
	 * 2.从上到下打印一行。 
	 * 3.从右到左打印一行。 
	 * 4.从下到上打印一行。
	 * 每一轮不一定都有四步，最后一圈只有一步。 第一步总是需要的。
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
		while (n > 2 * start) { // 每一圈，一共有n/2圈
			int endX = n - start - 1;
			int endY = n - start - 1;
			//从左到右打印一行
			for (int i = start; i <= endX; i++) {
				num++;
				System.out.print(num + " ");
			}
			//最后一圈没有下面的打印任务
			if (endY > start) {
				//从上到下打印一行
				for (int i = start + 1; i <= endY; i++) {
					num += n;
					System.out.print(num + " ");
				}
				//从右到左打印一行
				for (int i = endX - 1; i >= start; i--) {
					num--;
					System.out.print(num + " ");
				}
				//从下到上打印一行
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
