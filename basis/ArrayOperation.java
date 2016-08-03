package com.edu.array;

/**
 * �������
 *
 */
public class ArrayOperation {
	public static void main(String[] args) {
		int[] array={9,12,0,10,3,18};
		//Ѱ�ҵڶ�����
		System.out.println(findSecMax(array));
		
		//���������С��
		findMaxAndMin(array);
	}
	/**������ĵڶ���������������������һ�������洢��������������ʼΪ�������Ԫ�أ���һ��������ʼΪ��С��������Ȼ���������Ԫ�أ�����
	 * ����������ֵ���������Ԫ�ص�ֵ���������������򽫵ڶ�������ֵ����Ϊ�����������ֵ����������ֵ����Ϊ����Ԫ�ص�ֵ���������
	 * Ԫ�ر����������С�����жϸ�����Ԫ���Ƿ�ȵڶ�����������ǣ�����µڶ������Ϊ�� ����Ԫ�ص�ֵ��
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
	/**Ѱ�����������С����ȡ˫Ԫ�ط���ÿ�αȽ�����������ĺ�max�Ƚϣ�С�ĺ�min�Ƚϣ�ͨ���Ƚ��ҳ����ֵ����Сֵ�����ַ�����Ҫ�Ƚ�1.5N�Ρ�
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
