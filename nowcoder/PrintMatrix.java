package nowcoder;

import java.util.ArrayList;

/**
 * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣���
 * �磬����������¾��� 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 * �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @author lab2015
 *
 */
public class PrintMatrix {
	public static void main(String[] args) {
		int matrix[][]={{1,2},{3,4},{5,6},{7,8},{9,10}};
		printMatrix(matrix);
	}
	/**
	 * ÿһ�δ�ӡ�����е�һ��Ȧ��ѭ����������Ϊ��ʼ���кŻ��кŵ�����ҪС���ܵ��кŻ��к�
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
	    //�վ���
	    if(columns==0&&rows==0){
	    	return result;
	    }
	    int start=0; //��һȦ
	    while(columns>start*2&&rows>start*2){
	    	 printMaxtrixInCircle(result,matrix,columns,rows,start);
	    	 start++;
	    }
		return result;
    }
	/**
	 * ��ӡһȦ�ķ��������ǿ��԰Ѵ�ӡһȦ��Ϊ�Ĳ�
	 * 1.�����Ҵ�ӡһ�С�
	 * 2.���ϵ��´�ӡһ�С�
	 * 3.���ҵ����ӡһ�С�
	 * 4.���µ��ϴ�ӡһ�С�
	 * ÿһ�ֲ�һ�������Ĳ�����ʱ�����Ĳ���������������һ��������Ҫע��߽�������
	 * ��һ��������Ҫ�ģ�
	 * �ڶ�������������ֹ�кŴ�����ʼ�кţ�
	 * ����������������ֹ�кŴ�����ʼ�кŲ�����ֹ�кŴ�����ʼ�кţ�
	 * ���Ĳ�����������ֹ�кű���ʼ�к����ٴ�2��������ֹ�кŴ�����ʼ�кš�
	 * @param matrix
	 * @param columns
	 * @param rows
	 */
	public static void printMaxtrixInCircle(ArrayList<Integer> result, int[][] matrix, int columns, int rows, int start) {
		int endX=columns-1-start;//��ֹ�к�
		int endY=rows-1-start;//��ֹ�к�
		//1.�����Ҵ�ӡһ��
		for(int i=start;i<=endX;i++){
			result.add(matrix[start][i]);
			System.out.print(matrix[start][i]+" ");
		}
		//2.���ϵ��´�ӡһ��:��ֹ�кŴ�����ʼ�к�
		if(start<endY){
			for(int i=start+1;i<=endY;i++){
				result.add(matrix[i][endX]);
				System.out.print(matrix[i][endX]+" ");
			}
		}
		//3.���ҵ����ӡһ��:��ֹ�кŴ�����ʼ�кŲ�����ֹ�кŴ�����ʼ�к�
		if(start<endY&&start<endX){
			for(int i=endX-1;i>=start;i--){
				result.add(matrix[endY][i]);
				System.out.print(matrix[endY][i]+" ");
			}
		}
		//4.���µ��ϴ�ӡһ�У���ֹ�кű���ʼ�к����ٴ�2��������ֹ�кŴ�����ʼ�к�
		if((endY-start)>1&&endX>start){
			for(int i=endY-1;i>start;i--){
				result.add(matrix[i][start]);
				System.out.print(matrix[i][start]+" ");
			}
		}
		
	}
}
