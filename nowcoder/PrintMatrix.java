package nowcoder;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例
 * 如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @author lab2015
 *
 */
public class PrintMatrix {
	public static void main(String[] args) {
		int matrix[][]={{1,2},{3,4},{5,6},{7,8},{9,10}};
		printMatrix(matrix);
	}
	/**
	 * 每一次打印矩阵中的一个圈，循环结束条件为开始的列号或行号的两倍要小于总的列号或行号
	 * @param matrix
	 * @return
	 */
	public static ArrayList<Integer> printMatrix(int [][] matrix) {
	    ArrayList<Integer> result=new ArrayList<Integer>();
	    if(matrix==null){
	    	return result;
	    }
	    int rows=matrix.length;
	    int columns=matrix[0].length;
	    //空矩阵
	    if(columns==0&&rows==0){
	    	return result;
	    }
	    int start=0; //第一圈
	    while(columns>start*2&&rows>start*2){
	    	 printMaxtrixInCircle(result,matrix,columns,rows,start);
	    	 start++;
	    }
		return result;
    }
	/**
	 * 打印一圈的方法：我们可以把打印一圈分为四步
	 * 1.从左到右打印一行。
	 * 2.从上到下打印一行。
	 * 3.从右到左打印一行。
	 * 4.从下到上打印一行。
	 * 每一轮不一定都有四步，有时少于四步，三步、两步或一步。所以要注意边界条件：
	 * 第一步总是需要的；
	 * 第二步的条件是终止行号大于起始行号；
	 * 第三步的条件是终止行号大于起始行号并且终止列号大于起始列号；
	 * 第四步的条件是终止行号比起始行号至少大2，并且终止列号大于起始列号。
	 * @param matrix
	 * @param columns
	 * @param rows
	 */
	public static void printMaxtrixInCircle(ArrayList<Integer> result, int[][] matrix, int columns, int rows, int start) {
		int endX=columns-1-start;//终止列号
		int endY=rows-1-start;//终止行号
		//1.从左到右打印一行
		for(int i=start;i<=endX;i++){
			result.add(matrix[start][i]);
			System.out.print(matrix[start][i]+" ");
		}
		//2.从上到下打印一行:终止行号大于起始行号
		if(start<endY){
			for(int i=start+1;i<=endY;i++){
				result.add(matrix[i][endX]);
				System.out.print(matrix[i][endX]+" ");
			}
		}
		//3.从右到左打印一行:终止行号大于起始行号并且终止列号大于起始列号
		if(start<endY&&start<endX){
			for(int i=endX-1;i>=start;i--){
				result.add(matrix[endY][i]);
				System.out.print(matrix[endY][i]+" ");
			}
		}
		//4.从下到上打印一行：终止行号比起始行号至少大2，并且终止列号大于起始列号
		if((endY-start)>1&&endX>start){
			for(int i=endY-1;i>start;i--){
				result.add(matrix[i][start]);
				System.out.print(matrix[i][start]+" ");
			}
		}
		
	}
}
