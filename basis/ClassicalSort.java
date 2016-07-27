package basis;

/**
 * ����������㷨��
 * 1.ѡ������:  nСʱ�Ϻ�                   ���ȶ�        ʱ�临�Ӷ�O(n*n),�ռ临�Ӷ�O(1)
 * 2.��������:  �󲿷�������ʱ�Ϻ�   �ȶ�           ʱ�临�Ӷ�O(n*n),�ռ临�Ӷ�O(1)
 * 3.ð������:  nСʱ�Ϻ�                    �ȶ�            ʱ�临�Ӷ�O(n*n),�ռ临�Ӷ�O(1)
 * 4.�鲢����:  n��ʱ�Ϻ�                    �ȶ�            ʱ�临�Ӷ�O(nlogn)���ΪO(n*n),�ռ临�Ӷ�O(logn)
 * 5.��������:  n��ʱ�Ϻ�                    ���ȶ�        ʱ�临�Ӷ�O(nlogn),�ռ临�Ӷ�O(logn)
 * 6.ϣ������:  n��ʱ�Ϻ�                    ���ȶ�        ʱ�临�Ӷ�O(nlogn),�ռ临�Ӷ�O(1)
 * 7.������:   n��ʱ�Ϻ�                    ���ȶ�        ʱ�临�Ӷ�O(nlogn),�ռ临�Ӷ�O(1)
 * ���������Ǵ�С����
 * @author lab2015
 *
 */
public class ClassicalSort {
	public static void main(String[] args) {
		int a[]={5,0,6,2,1,8,4};
		
//		selectSort(a);

//		insertSort(a);

//		bubbleSort2(a);

//		mergeSort(a,0,a.length-1);

//		quickSort(a);
		
//		shellSort1(a);
//		print(a);
		
		heapSort(a);
		print(a);

	}
	public static void print(int a[]){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	/**1.ѡ�����򣺵�һ�αȽ��ҵ���С�ļ�¼�����һ����¼����λ�ã����ŶԲ�������һ����¼����ļ�¼���еڶ��ֱȽϡ�����
	 * ѭ��ֱ��ֻ��һ����¼
	 * �ؼ�˼·��ÿ��ѡ�����¼�¼����С��һ����
	 * @param a
	 */
	public static void selectSort(int a[]){
		int temp=0;
		int index=0;
		for(int i=0;i<a.length;i++){
			temp=a[i];
			index=i;
			for(int j=i+1;j<a.length;j++){
				if(temp>a[j]){
					temp=a[j];
					index=j;
				}
			}
			//��������ʱ����
			if(index!=i){
				a[index]=a[i];
				a[i]=temp;
			}
		}//end for
	}
	/**
	 * 2.�������򣺳�ʼʱ�����һ����¼�Գ�һ���������У������¼Ϊ�������С����Ŵӵڶ�����¼��ʼ�����ռ�¼�Ĵ�С���ν�
	 * ��ǰ����ļ�¼����֮ǰ�����������У�ֱ�����һ����¼���롣
	 * �ؼ�˼·�������¼���������������.
	 * @param a
	 */
	public static void insertSort(int a[]){	
		for(int i=1;i<a.length;i++){
			int temp=a[i],j=i;
			if(a[j-1]>temp){//��ǰλ��i����a[i]��λ��ʱ
				while(j>=1&&a[j-1]>temp){//ֻҪ�ҵ�a[i]��λ�þͽ���
					a[j]=a[j-1];
					j--;
				}	
			}
			a[j]=temp;
		}
	}
	/**
	 * 3.ð�����򣺸���n����¼���ӵ�һ����¼��ʼ���ζ����ڵ�������¼���бȽϣ���ǰ����ں���ʱ������λ�ã�����һ�ֱȽϺͽ�����
	 * n����¼������¼��λ�ڵ�nλ���ظ���һ������
	 * �ؼ�˼�룺����������ð��һ��������ð����
	 * @param a
	 * ����С��ʼ�Ƚϣ��Ѵ��ð�����
	 */
	public static void bubbleSort(int a[]){
		int temp=0;
		for(int i=0;i<a.length-1;i++){//���һ�ֲ���Ҫ�Ƚ�
			for(int j=0;j<a.length-i-1;j++){
				if(a[j]>a[j+1]){//ע�������±�
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}//end for
	}
	
	/**
	 * @param a
	 * ��С��ð��ǰ��
	 */
	public static void bubbleSort2(int a[]){
		int temp=0;
		for(int i=0;i<a.length-1;i++){//���һ�ֲ���Ҫ�Ƚ�
			for(int j=a.length-1;j>i;j--){
				if(a[j]<a[j-1]){//ע�������±�
					temp=a[j];
					a[j]=a[j-1];
					a[j-1]=temp;
				}
			}
		}//end for
	}
	/**
	 * 4.�鲢���򣺶��ڸ�������n����¼��һ�����ݣ����Ƚ�ÿ�������ڵĳ���Ϊ1�������н��кϲ����õ�n/2������ȡ����
	 * ������Ϊ2��1���������У�Ȼ���ٽ��������鲢���ظ��˲�����ֱ���õ�һ���������С�
	 * �ؼ�˼·�����õݹ�����μ������������л��ֳ�ΪԽ��ԽС�İ��ӱ��ٶ԰��ӱ�����������õݹ鷽��������õİ��ӱ�
	 * �ϲ���ΪԽ��Խ��������б�
	 * ��1�����ְ��ӱ���2���ϲ����ӱ�
	 * @param a,p,r
	 * a��Ҫ��������飬p��Ҫ��������������±꣬r���յ��±�
	 */
	public static void mergeSort(int a[],int p,int r){
		 if(p<r){
			 int q=(p+r)/2;//����ȡ��
			 mergeSort(a,p,q);
			 mergeSort(a,q+1,r);
			 merge(a,p,q,r);
		 }
	}
	public static void merge(int a[],int p,int q,int r){
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
				a[k]=R[j];
				j++;
			}else{
				a[k]=L[i];
				i++;
			}
		}
		//����ʣ�µ�Ԫ��
		if(i<n1){
			for(j=i;j<n1;j++,k++){
				a[k]=L[j];
			}
		}
		if(j<n2){
			for(i=j;i<n2;i++,k++){
				a[k]=R[i];
			}
		}
	}
	/**
	 * 5.�������򣺶���һ������ļ�¼��ͨ��һ������󣬽�ԭ���з�Ϊ�����֣�����ǰһ���ֵ����м�¼���Ⱥ�һ���ֵ�����
	 * ��¼С��Ȼ�������ζ�ǰ�������ֵļ�¼���п������򣬵ݹ�ù��̣�ֱ�����м�¼��Ϊ����
	 * �ؼ�˼�룺�ֶ���֮���Ѵ�Ĳ��ΪС�ģ�С�Ĳ��Ϊ��С�ġ�
	 * @param a
	 */
	public static void quickSort(int a[]){
		sort(a,0,a.length-1);
	}
	private static void sort(int[] a, int low, int high) {
		int index,i,j;
		if(low>=high){
			return;
		}
		i=low;
		j=high;
		index=a[i];//ѡ���׼��
		while(i<j){
			while(i<j&&a[j]>=index){//���ұ��ҵ�һ���Ȼ���С��
				j--;
			}
			if(i<j){
				a[i++]=a[j];
			}
			while(i<j&&a[i]<index){//������ҵ�һ���Ȼ������
				i++;
			}
			if(i<j){
				a[j--]=a[i];
			}
			a[i]=index;
			sort(a,low,i-1);
			sort(a,i+1,high);
		}
	}
	/**
	 * 6.ϣ��������С��������
	 * (1)�Ƚ������������Ԫ�طֳɶ�������У�ʹ��ÿ�������е�Ԫ�ظ�����Խ���
	 * (2)Ȼ��Ը��������зֱ����ֱ�Ӳ������򣬴��������������л������������ٶ�����Ԫ�ؽ���һ��ֱ������
	 * @param a
	 */
	public static void shellSort1(int a[]){
		int len=a.length;
		int i,j;
		int h;
		int temp;
		for(h=len/2;h>0;h=h/2){
			for(i=0;i<h;i++){
				//��������
				for(j=i+h;j<len;j+=h){
					temp=a[j];
					int k=j;
					if(temp<a[k-h]){
						while(k>0&&temp<a[k-h]){
							a[k]=a[k-h];
							k-=h;
						}	
					}
					a[k]=temp;
				}//end for insertSort
				
			}
		}
	}
	public static void shellSort(int a[]){
		int len=a.length;
		int i,j;
		int h;
		int temp;
		for(h=len/2;h>0;h=h/2){
			for(i=h;i<len;i++){
				temp=a[i];
				for(j=i-h;j>=0;j-=h){
					if(temp<a[j]){
						a[j+h]=a[j];
					}else{
						break;//������ǰѭ��
					}
				}
				a[j+h]=temp;
			}
		}
	}
	
	/**
	 * 7.������һ������ѡ����������������У���R[1...n]����һ����ȫ�������ṹ��������ȫ������
	 * �и������ӽ��֮������ڹ�ϵ��ѡ����С��Ԫ�ء�
	 * ���ڸ�����n����¼����ʼʱ����Щ��¼����һ��˳��洢�Ķ�������Ȼ�������Ϊһ����ѣ����н������
	 * �ѵ����һ��Ԫ�ؼ�Ϊ����¼�����Ž�ǰn-1��Ԫ���ؽ���������ֱ��ֻʣ��һ��Ԫ��Ϊֹ��
	 * �ؼ�˼�룺������
	 * ��1�������ѣ���2�������Ѷ�Ԫ�������һ��Ԫ�ص�λ�á�
	 * @param a
	 */
	public static void heapSort(int a[]){
		int i;
		int len=a.length;
		for(i=len/2-1;i>=0;i--){//�����һ����Ҷ�ӽڵ㿪ʼ����ÿ�����ڵ㶼����Ϊ����
			adjustHeap(a,i,len-1);
		}
		for(i=len-1;i>=0;i--){//�����Ѷ�Ԫ�������һ��Ԫ�ص�λ��
			int temp=a[0];
			a[0]=a[i];
			a[i]=temp;
			adjustHeap(a,0,i-1);
		}
		
	}
	//�����ѣ�posΪ�Ѷ�Ԫ�أ�lenΪ���һ��child
	public static void adjustHeap(int a[],int pos,int len){
		int temp;
		int child;
		for(temp=a[pos];2*pos+1<=len;pos=child){//pos�����ӽ��Ϊ2*pos+1�����ӽ��Ϊ2*pos+2
			child=2*pos+1;//���ӽ��
			if(child<len&&a[child]<a[child+1]){//���ҳ����ҽ���нϴ���Ǹ����
				child++;
			}
			if(a[child]>temp){//�������϶�
				a[pos]=a[child];
			}else{
				break;//ԭ�����Ƕѣ�����ڵ�һ��û���ҵ��������û�и�����ˣ�����
			}
		}
		a[pos]=temp;
	}
	
	
}
