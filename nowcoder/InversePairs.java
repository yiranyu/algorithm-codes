package nowcoder;

public class InversePairs {
	public static void main(String[] args) {
		int[] a={364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,
				650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,
				233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,
				256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,
				870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,
				45,848,38,811,267,575}; 
		System.out.println(inversePairs(a)); //2519
	}
	/**
	 * �����е������
	 * �������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�����һ������,�����������е�����Ե�����P��
	 * ����P��1000000007ȡģ�Ľ������� �����P%1000000007 
	 * ��������:
	 * ��Ŀ��֤�����������û�е���ͬ������
	 * ���ݷ�Χ��
	 * 	����%50������,size<=10^4
	 * 	����%75������,size<=10^5
	 * 	����%100������,size<=2*10^5
	 * ��������:
	 * 	1,2,3,4,5,6,7,0
	 * �������:
	 * 	7
	 * 
	 * ˼·���Ȱ�����ָ��������飬��ͳ�Ƴ��������ڲ�������Ե���Ŀ��Ȼ����ͳ�Ƴ���������������֮�������Ե���Ŀ��
	 * ��ͳ�ƵĹ����У�����Ҫ������������򣬷�ֹ���ظ�ͳ�ơ�
	 * ʵ���Ͼ��ǹ鲢�����˼�롣
	 */
	
	public static int inversePairs(int a[]){
		if(a==null||a.length<2){
			return 0;
		}
		int[] count={0};
		mergeSort(a,0,a.length-1,count);
		return count[0];
	}
	public static void mergeSort(int a[],int p,int r,int[] count){
		if(p>=r){
			return;
		}
		//���ְ��Ӽ�
		int q=(p+r)/2;//����ȡ��
		mergeSort(a,p,q,count);
		mergeSort(a,q+1,r,count);
		int i,j,k,n1,n2;
		//�������ӱ�ĳ���
		n1=q-p+1;
		n2=r-q;
		int[] L=new int[n1];
		int[] R=new int[n2];
		//�洢ԭ��������
		for(i=0,k=p;i<n1;i++,k++){
			L[i]=a[k];
		}
		for(i=0,k=q+1;i<n2;i++,k++){
			R[i]=a[k];
		}
		//�������ԭ����
		for(k=p,i=0,j=0;i<n1&&j<n2;k++){
			if(L[i]>R[j]){
				a[k]=R[j++];
				if(count[0]>1000000007){ //��count������Χ��ģ����
                    count[0]%=1000000007;
                }
				count[0]+=n1-i;
			}else{
				a[k]=L[i++];
			}
		}
		//����ʣ�µ�Ԫ��
		while(i<n1){
			a[k++]=L[i++];
		}
		while(j<n2){
			a[k++]=R[j++];
		}
	}
	/**
	 * �ڶ��ֹ鲢�������
	 * @param array
	 * @return
	 */
	public static int inversePairs2(int[] array) {
	    if(array==null||array.length<=1){
	    	return 0;
	    }
	    int len=array.length;
	    int[] copy=new int[len];
	    //����һ������
	    for(int i=0;i<len;i++){
	    	copy[i]=array[i];
	    }
	    int count=inversePairsCore(array,copy,0,len-1);
		return count;
	}
	public static int inversePairsCore(int[] a,int[] copy,int start,int end){
		if(start==end){
			copy[start]=a[start];
			return 0;
		}
		int len=(end-start)/2; //����
		int left=inversePairsCore(a,copy,start,start+len);
		int right=inversePairsCore(a,copy,start+len+1,end);
		
		int count=0;
		int i=start+len; //ǰ��ε����һ�������±�
		int j=end; //���ε����һ�������±�
		int copyIndex=end;
		while(i>=start&&j>=start+len+1){
			if(a[i]>a[j]){ //ǰ��ε����ִ��ں��ε�����
				copy[copyIndex--]=a[i--];
				count+=j-start-len; //j֮ǰ�Ķ�С��i֮��
			}else{
				copy[copyIndex--]=a[j--];
			}
		}
		for(;i>=start;i--){
			copy[copyIndex--]=a[i];
		}
		for(;j>=start+len+1;j--){
			copy[copyIndex--]=a[j];
		}
		//����
        for(i=start; i<=end; i++) {
            a[i] = copy[i];
        }
		return left+right+count;
	}
}
