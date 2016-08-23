package nowcoder;

public class GetNumberOfK {
	public static void main(String[] args) {
		int array[]={1,2,3,4,4,4,5,6};
		System.out.println(getNumberOfK(array,6));
	}
	/**
	 * 数字在排序数组中出现的次数:统计一个数字在有序数组中出现的次数
	 * 二分查找：关键点是如何直接找到第一个k和最后一个k
	 * 时间复杂度：O(logn)
	 */
	public static int getNumberOfK(int [] array , int k) {
		if(array==null||array.length==0){
			return 0;
		}
		int first=getFirstK(array,k,0,array.length-1);//找到第一个k
		int last=getLastK(array,k,0,array.length-1);//找到最后一个k
		if(first>-1&&last>-1){
			return last-first+1;
		}
		return 0;
    }
	/**
	 * 递归查找排序数组中的第一个k
	 */
	public static int getFirstK(int[] array,int k,int start,int end){
		if(start>end){
			return -1;
		}
		int midIndex=(start+end)/2;
		int midData=array[midIndex];
		if(midData==k){
			//中间的数字等于k,并且中间数字的前一个数字不等于k或者midIndex等于0时找到第一个k
			if(midIndex>0&&array[midIndex-1]!=k||midIndex==0){
				return midIndex;
			}else{
				end=midIndex-1; //第一个k在midIndex的前面
			}
		}else if(midData>k){ //第一个k在左边
			end=midIndex-1;
		}else{ //第一个k在右边
			start=midIndex+1;
		}
		return getFirstK(array,k,start,end);
	}
	//以同样的思路找到最后一个k
	public static int getLastK(int[] array,int k,int start,int end){
		if(start>end||end>array.length-1){
			return -1;
		}
		int midIndex=(start+end)/2;
		int midData=array[midIndex];
		if(midData==k){
			//中间的数字等于k,并且中间数字的后一个数字不等于k或者midIndex等于最后一个元素时找到最后一个k
			if(midIndex<array.length-1&&array[midIndex+1]!=k||midIndex==array.length-1){
				return midIndex;
			}else{
				start=midIndex+1; //最后一个k在midIndex的后面
			}
		}else if(midData>k){ //最后一个k在左边
			end=midIndex-1;
		}else{ //最后一个k在右边
			start=midIndex+1;
		}
		return getLastK(array,k,start,end);
	}
}
