package com.edu.array;

/**
 * 数组操作
 *
 */
public class ArrayOperation {
	public static void main(String[] args) {
		int[] array={9,12,0,10,3,18};
		//寻找第二大数
		System.out.println(findSecMax(array));
		
		//最大数和最小数
		findMaxAndMin(array);
	}
	/**找数组的第二大数：定义两个变量，一个变量存储数组的最大数，初始为数组的首元素，另一个变量初始为最小负整数，然后遍历数组元素，更新
	 * 两个变量的值：如果数组元素的值比数组的最大数大，则将第二变量的值更新为最大数变量的值，最大变量的值更新为数组元素的值；如果数组
	 * 元素比最大数变量小，则判断该数组元素是否比第二大变量大，如是，则更新第二大变量为该 数组元素的值。
	 * @param data
	 * @return
	 */
	public static int findSecMax(int[] data){
		int max=data[0]; 
		int secMax=Integer.MIN_VALUE;
		for(int i=1;i<data.length;i++){
			if(data[i]>max){
				secMax=max;
				max=data[i];
			}else{
				if(data[i]>secMax){
					secMax=data[i];
				}
			}
		}
		return secMax;
	}
	/**寻找最大数和最小数：取双元素法。每次比较两个数，大的和max比较，小的和min比较，通过比较找出最大值和最小值。此种方法需要比较1.5N次。
	 * @param data
	 */
	public static void findMaxAndMin(int[] data){
		int max=data[0];
		int min=data[0];
		int len=data.length;
		for(int i=1;i<len-1;i+=2){
			if(i+1>=len){
				if(data[i]>max){
					max=data[i];
				}
				if(data[i]<min){
					min=data[i];
				}
			}
			if(data[i]>data[i+1]){
				if(data[i]>max){
					max=data[i];
				}
				if(data[i+1]<min){
					min=data[i+1];
				}
			}
			if(data[i]<data[i+1]){
				if(data[i+1]>max){
					max=data[i+1];
				}
				if(data[i]<min){
					min=data[i];
				}
			}
		}
		System.out.println(max+" "+min);
	}
}
