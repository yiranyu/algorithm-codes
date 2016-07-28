package nowcoder;
/**
 * �����г��ִ�������һ�������
 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
 * ��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��
 * ��������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2����������������0��
 * @author lab2015
 *
 */
public class MoreThanHalfNum {
	public static void main(String[] args) {
		int array[]={1,3,3,1,3,3,1,1};
		System.out.println(moreThanHalfNum(array));
	}
	/**
	 * 1.�����������ʱ�临�Ӷ����ΪO(nlogn)
	 * 2.��λ���������������һ�����ֳ��ֵĴ������������鳤�ȵ�һ�룬����������������õģ�
	 * ��ô�м������һ�������Ǹ����ִ����������鳤�ȵ����֡�
	 * 3.����������ص㣺���������ʱ�򱣴�����ֵ��һ���������е�һ������һ���Ǵ�������������ͬ����+1����ͬ-1��������δ0ʱ��������ֵ��
	 * �����ҵ������ֿ϶������һ�ΰѴ�����Ϊ1ʱ��Ӧ�����֡��õ�������ֺ���������ֵĸ����Ƿ񳬹����鳤�ȵ�һ��
	 * 
	 * ����ʵ�ֵ������㷨
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
	    	if(count==0){ //������Ϊ0����������ֵ
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
