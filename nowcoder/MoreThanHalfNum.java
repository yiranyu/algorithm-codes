package nowcoder;
/**
 * 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * @author lab2015
 *
 */
public class MoreThanHalfNum {
	public static void main(String[] args) {
		int array[]={1,3,3,1,3,3,1,1};
		System.out.println(moreThanHalfNum(array));
	}
	/**
	 * 1.先排序，排序的时间复杂度最好为O(nlogn)
	 * 2.中位数：如果数组中有一个数字出现的次数超过了数组长度的一半，如果这个数组是排序好的，
	 * 那么中间的数字一定就是那个出现次数超过数组长度的数字。
	 * 3.利用数组的特点：遍历数组的时候保存两个值，一个是数组中的一个数，一个是次数：遍历到相同的数+1，不同-1，计数器未0时重新设置值。
	 * 最终找到的数字肯定是最后一次把次数设为1时对应的数字。得到这个数字后检测这个数字的个数是否超过数组长度的一半
	 * 
	 * 下面实现第三种算法
	 * @param array
	 * @return
	 */
	public static int moreThanHalfNum(int [] array) {
		
	    if(array==null||array.length==0){
	    	return 0;
	    }
	    int len=array.length;
	    int result=array[0];
	    int count=1;
	    for(int i=1;i<len;i++){
	    	if(count==0){ //计数器为0，重新设置值
	    		result=array[i];
	    		count=1;
	    	}else if(array[i]==result){
	    		count++;
	    	}else{
	    		count--; 
	    	}
	    }
	    count=0;
	    for(int i=0;i<len;i++){
	    	if(array[i]==result){
	    		count++;
	    	}
	    }
	    if(count*2<=len){
	    	return 0;
	    }
		return result;    
	}
}
