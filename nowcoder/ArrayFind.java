package nowcoder;
/**
 * ��������˼·��
��1����������������С�O(n^2)��
��2�������Ͻǿ�ʼ���������ƣ���С���ơ�O(m+n)��
��3�������½ǿ�ʼ���������ƣ���С���ơ�O(m+n)��
 * @author lab2015
 *
 */
public class ArrayFind {
	public static void main(String[] args) {
		int array[][]={
				{1,3,4},
				{2,4,7},
				{5,6,9}
		};
		System.out.println(Find(array,5));
	}
	public static boolean Find(int [][] array,int target) {
        int lenx=array.length;
        int leny=array[0].length;
		for(int i=0;i<lenx;i++){
            for(int j=0;j<leny;j++){
                 if(array[i][j]==target){
                    return true;
                }else if(array[i][j]>target){
                    break;
                }
            }
           
        }
		return false;
    }
	public static boolean Find2(int [][] array,int target) {
        int lenx=array.length;
        int leny=array[0].length;
        int i=0,j=lenx-1;
		while(i<leny&&j>=0){
			if(array[i][j]==target){
				return true;
			}else if(array[i][j]>target){
				j--;
			}else{
				i++;
			}
		}
		return false;
    }
}
