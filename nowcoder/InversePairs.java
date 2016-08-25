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
	 * 数组中的逆序对
	 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
	 * 并将P对1000000007取模的结果输出。 即输出P%1000000007 
	 * 输入描述:
	 * 题目保证输入的数组中没有的相同的数字
	 * 数据范围：
	 * 	对于%50的数据,size<=10^4
	 * 	对于%75的数据,size<=10^5
	 * 	对于%100的数据,size<=2*10^5
	 * 输入例子:
	 * 	1,2,3,4,5,6,7,0
	 * 输出例子:
	 * 	7
	 * 
	 * 思路：先把数组分隔成子数组，先统计出子数组内部的逆序对的数目，然后再统计出两个相邻子数组之间的逆序对的数目。
	 * 在统计的过程中，还需要对数组进行排序，防止在重复统计。
	 * 实际上就是归并排序的思想。
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
		//划分半子集
		int q=(p+r)/2;//向下取整
		mergeSort(a,p,q,count);
		mergeSort(a,q+1,r,count);
		int i,j,k,n1,n2;
		//两个半子表的长度
		n1=q-p+1;
		n2=r-q;
		int[] L=new int[n1];
		int[] R=new int[n2];
		//存储原数组数据
		for(i=0,k=p;i<n1;i++,k++){
			L[i]=a[k];
		}
		for(i=0,k=q+1;i<n2;i++,k++){
			R[i]=a[k];
		}
		//有序放入原数组
		for(k=p,i=0,j=0;i<n1&&j<n2;k++){
			if(L[i]>R[j]){
				a[k]=R[j++];
				if(count[0]>1000000007){ //当count超出范围求模操作
                    count[0]%=1000000007;
                }
				count[0]+=n1-i;
			}else{
				a[k]=L[i++];
			}
		}
		//处理剩下的元素
		while(i<n1){
			a[k++]=L[i++];
		}
		while(j<n2){
			a[k++]=R[j++];
		}
	}
	/**
	 * 第二种归并排序求解
	 * @param array
	 * @return
	 */
	public static int inversePairs2(int[] array) {
	    if(array==null||array.length<=1){
	    	return 0;
	    }
	    int len=array.length;
	    int[] copy=new int[len];
	    //复制一份数组
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
		int len=(end-start)/2; //长度
		int left=inversePairsCore(a,copy,start,start+len);
		int right=inversePairsCore(a,copy,start+len+1,end);
		
		int count=0;
		int i=start+len; //前半段的最后一个数字下标
		int j=end; //后半段的最后一个数字下标
		int copyIndex=end;
		while(i>=start&&j>=start+len+1){
			if(a[i]>a[j]){ //前半段的数字大于后半段的数字
				copy[copyIndex--]=a[i--];
				count+=j-start-len; //j之前的都小于i之后
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
		//排序
        for(i=start; i<=end; i++) {
            a[i] = copy[i];
        }
		return left+right+count;
	}
}
