package nowcoder;

public class GetNumberOfK {
	public static void main(String[] args) {
		int array[]={1,2,3,4,4,4,5,6};
		System.out.println(getNumberOfK(array,6));
	}
	/**
	 * ���������������г��ֵĴ���:ͳ��һ�����������������г��ֵĴ���
	 * ���ֲ��ң��ؼ��������ֱ���ҵ���һ��k�����һ��k
	 * ʱ�临�Ӷȣ�O(logn)
	 */
	public static int getNumberOfK(int [] array , int k) {
		if(array==null||array.length==0){
			return 0;
		}
		int first=getFirstK(array,k,0,array.length-1);//�ҵ���һ��k
		int last=getLastK(array,k,0,array.length-1);//�ҵ����һ��k
		if(first>-1&&last>-1){
			return last-first+1;
		}
		return 0;
    }
	/**
	 * �ݹ�������������еĵ�һ��k
	 */
	public static int getFirstK(int[] array,int k,int start,int end){
		if(start>end){
			return -1;
		}
		int midIndex=(start+end)/2;
		int midData=array[midIndex];
		if(midData==k){
			//�м�����ֵ���k,�����м����ֵ�ǰһ�����ֲ�����k����midIndex����0ʱ�ҵ���һ��k
			if(midIndex>0&&array[midIndex-1]!=k||midIndex==0){
				return midIndex;
			}else{
				end=midIndex-1; //��һ��k��midIndex��ǰ��
			}
		}else if(midData>k){ //��һ��k�����
			end=midIndex-1;
		}else{ //��һ��k���ұ�
			start=midIndex+1;
		}
		return getFirstK(array,k,start,end);
	}
	//��ͬ����˼·�ҵ����һ��k
	public static int getLastK(int[] array,int k,int start,int end){
		if(start>end||end>array.length-1){
			return -1;
		}
		int midIndex=(start+end)/2;
		int midData=array[midIndex];
		if(midData==k){
			//�м�����ֵ���k,�����м����ֵĺ�һ�����ֲ�����k����midIndex�������һ��Ԫ��ʱ�ҵ����һ��k
			if(midIndex<array.length-1&&array[midIndex+1]!=k||midIndex==array.length-1){
				return midIndex;
			}else{
				start=midIndex+1; //���һ��k��midIndex�ĺ���
			}
		}else if(midData>k){ //���һ��k�����
			end=midIndex-1;
		}else{ //���һ��k���ұ�
			start=midIndex+1;
		}
		return getLastK(array,k,start,end);
	}
}
