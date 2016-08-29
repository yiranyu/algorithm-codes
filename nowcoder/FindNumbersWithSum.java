package nowcoder;

import java.util.ArrayList;

public class FindNumbersWithSum {

	public static void main(String[] args) {
		int array[]={1,2,4,7,8,11,15};
		ArrayList<Integer> result=findNumbersWithSum(array,15);
		System.out.println(result.get(0)+" "+result.get(1));
	}
	/**
	 * 和为S的两个数字
	 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。 
	 * 对应每个测试案例，输出两个数，小的先输出。
	 * 思路：设置两个指针，分别指向第一个和最后一个数字，每一步判断当前指针指向的数字的和是否与S相等，
	 * 如果大了，第一个指针++，小了第二个指针--。相等时保留乘积较小的，第二个指针--寻找下一对数字。
	 */
	public static ArrayList<Integer> findNumbersWithSum(int [] array,int sum) {
	    ArrayList<Integer> result=new ArrayList<Integer>();
	    if(array==null||array.length<2){
	    	return result;
	    }
	    int len=array.length;
	    int i=0,j=len-1;
	    while(i<j){
	    	int s=array[i]+array[j];
	    	if(s==sum){
	    		System.out.println(array[i]+" "+array[j]);
	    		if(result.size()>0){//已经存在一对数字
	    			if(array[i]*array[j]<result.get(0)*result.get(1)){//当前数字乘积较小
		    			//先清除后添加
	    				result.clear(); 
		    			result.add(array[i]);
		    			result.add(array[j]);
		    		}
	    		}else{ //没有则直接添加
	    			result.add(array[i]);
	    			result.add(array[j]);
	    		}
	    		j--;	
	    	}else if(s>sum){
	    		j--;
	    	}else{
	    		i++;
	    	}
	    }
		return result;
	}
}
