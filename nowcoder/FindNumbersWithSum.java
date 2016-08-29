package nowcoder;

import java.util.ArrayList;

public class FindNumbersWithSum {

	public static void main(String[] args) {
		int array[]={1,2,4,7,8,11,15};
		ArrayList<Integer> result=findNumbersWithSum(array,15);
		System.out.println(result.get(0)+" "+result.get(1));
	}
	/**
	 * ��ΪS����������
	 * ����һ����������������һ������S���������в�����������ʹ�����ǵĺ�������S������ж�����ֵĺ͵���S������������ĳ˻���С�ġ� 
	 * ��Ӧÿ�����԰����������������С���������
	 * ˼·����������ָ�룬�ֱ�ָ���һ�������һ�����֣�ÿһ���жϵ�ǰָ��ָ������ֵĺ��Ƿ���S��ȣ�
	 * ������ˣ���һ��ָ��++��С�˵ڶ���ָ��--�����ʱ�����˻���С�ģ��ڶ���ָ��--Ѱ����һ�����֡�
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
	    		if(result.size()>0){//�Ѿ�����һ������
	    			if(array[i]*array[j]<result.get(0)*result.get(1)){//��ǰ���ֳ˻���С
		    			//����������
	    				result.clear(); 
		    			result.add(array[i]);
		    			result.add(array[j]);
		    		}
	    		}else{ //û����ֱ�����
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
