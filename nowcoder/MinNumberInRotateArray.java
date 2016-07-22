package nowcoder;
/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @author lab2015
 *
 */
public class MinNumberInRotateArray {
	public static void main(String[] args) {
		int array[]={3,4,5,1,2};
		System.out.println(minNumberInRotateArray(array));
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}
//	public static int minNumberInRotateArray(int [] array) {
//		int len=array.length;
//	    if(len==0){
//	    	return 0;
//	    }else if(len==1){
//	    	return array[0];
//	    }
//	    int i,j,temp;
//	    //冒泡排序的思想
//	    for(i=0;i<len-1;i++){
//	    	for(j=len-1;j>i;j--){
//	    		if(array[j]<array[j-1]){
//	    			temp=array[j];
//	    			array[j]=array[j-1];
//	    			array[j-1]=temp;
//	    		}
//	    	}
//	    }
//		return array[0];
//    }
	public static int minNumberInRotateArray(int [] array) {
		int len=array.length;
	    if(len==0){
	    	return 0;
	    }else if(len==1){
	    	return array[0];
	    }
	    int i=1;
	    while(array[i-1]<=array[i]&&i<len){
	    	i++;
	    }
		return i==len-1?array[0]:array[i];
    }
}
