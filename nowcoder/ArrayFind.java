package nowcoder;
/**
 * 数组有序，思路：
（1）两层遍历，遇大换行。O(n^2)。
（2）从右上角开始，遇大左移，遇小下移。O(m+n)。
（3）从左下角开始，遇大上移，遇小右移。O(m+n)。
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
