package nowcoder;
/**
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
����һ����������������һ����ת�������ת�������СԪ�ء�
��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
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
//	    //ð�������˼��
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
