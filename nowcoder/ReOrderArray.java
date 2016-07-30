package nowcoder;
/**
 * 问题：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
要点：代码的完整性。数组
 * @author Administrator
 *
 */
public class ReOrderArray {
	public static void main(String[] args) {
		int[] array={1,2,3,4,5,6,7,8,9,10};
		reOrderArray(array);
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}
	/**
	 * 1.要想保证原有次序，则只能顺次移动或相邻交换。
	 * 2.even从左向右遍历，找到第一个偶数。
	 * 3.odd从even+1开始向后找，直到找到第一个奇数。
	 * 4.将[even,...,odd-1]的元素整体后移一位，最后将找到的奇数放入even位置，然后even++。
	 * 5.终止条件：odd向后遍历查找失败。
	 */
	public static void reOrderArray(int [] array) {
	    if(array==null||array.length==0)
	        return;
	    int even = 0,odd;
	    int len=array.length;
	    while(even<len){
	        while(even<len&&array[even]%2==1){//向右遍历，找到第一个偶数
	        	even++;
	        }
	            
	        odd = even+1;//从右遍历找到第一个偶数后的第一个奇数
	        while(odd<len&&array[odd]%2==0){
	        	odd++;
	        }
	            
	        if(odd<len){
	            int temp = array[odd];
	            for (int i = odd; i >even; i--) {
	            	array[i] = array[i-1];
	            }
	            array[even++] = temp;
	        }else{
	            return;
	        }
	    }
	}

}
