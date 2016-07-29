package basis;

/**
 * 经典的排序算法：
 * 1.选择排序:  n小时较好                   不稳定        时间复杂度O(n*n),空间复杂度O(1)
 * 2.插入排序:  大部分已有序时较好   稳定           时间复杂度O(n*n),空间复杂度O(1)
 * 3.冒泡排序:  n小时较好                    稳定            时间复杂度O(n*n),空间复杂度O(1)
 * 4.归并排序:  n大时较好                    稳定            时间复杂度O(nlogn)，最坏为O(n*n),空间复杂度O(logn)
 * 5.快速排序:  n大时较好                    不稳定        时间复杂度O(nlogn),空间复杂度O(logn)
 * 6.希尔排序:  n大时较好                    不稳定        时间复杂度O(nlogn),空间复杂度O(1)
 * 7.堆排序:   n大时较好                    不稳定        时间复杂度O(nlogn),空间复杂度O(1)
 * 所有排序都是从小到大
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
	/**1.选择排序：第一次比较找到最小的记录，与第一个记录交换位置，接着对不包含第一个记录以外的记录进行第二轮比较。。。
	 * 循环直至只有一个记录
	 * 关键思路：每次选择余下记录中最小的一个。
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
			//不是自身时交换
			if(index!=i){
				a[index]=a[i];
				a[i]=temp;
			}
		}//end for
	}
	/**
	 * 2.插入排序：初始时假设第一个记录自成一个有序序列，其余记录为无序序列。接着从第二个记录开始，按照记录的大小依次将
	 * 当前处理的记录插入之前的有序序列中，直至最后一个记录插入。
	 * 关键思路：无序记录逐个插入有序序列.
	 * @param a
	 */
	public static void insertSort(int a[]){	
		for(int i=1;i<a.length;i++){
			int temp=a[i],j=i;
			if(a[j-1]>temp){//当前位置i不是a[i]的位置时
				while(j>=1&&a[j-1]>temp){//只要找到a[i]的位置就结束
					a[j]=a[j-1];
					j--;
				}	
			}
			a[j]=temp;
		}
	}
	/**
	 * 3.冒泡排序：给定n个记录，从第一个记录开始依次对相邻的两个记录进行比较，当前面大于后面时，交换位置，进行一轮比较和交换后
	 * n个记录的最大记录将位于第n位。重复这一操作。
	 * 关键思想：整个过程像冒泡一样，依次冒出。
	 * @param a
	 * 从最小开始比较，把大的冒到后边
	 */
	public static void bubbleSort(int a[]){
		int temp=0;
		for(int i=0;i<a.length-1;i++){//最后一轮不需要比较
			for(int j=0;j<a.length-i-1;j++){
				if(a[j]>a[j+1]){//注意数组下标
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}//end for
	}
	
	/**
	 * @param a
	 * 把小数冒到前边
	 */
	public static void bubbleSort2(int a[]){
		int temp=0;
		for(int i=0;i<a.length-1;i++){//最后一轮不需要比较
			for(int j=a.length-1;j>i;j--){
				if(a[j]<a[j-1]){//注意数组下标
					temp=a[j];
					a[j]=a[j-1];
					a[j-1]=temp;
				}
			}
		}//end for
	}
	/**
	 * 4.归并排序：对于给定的有n个记录的一组数据，首先将每两个相邻的长度为1的子序列进行合并，得到n/2（向上取整）
	 * 个长度为2或1的有序序列，然后再将其两两归并，重复此操作，直至得到一个有序序列。
	 * 关键思路：利用递归与分治技术将数据序列划分成为越来越小的半子表，再对半子表排序，最后再用递归方法将排序好的半子表
	 * 合并成为越来越大的有序列表。
	 * （1）划分半子表；（2）合并半子表。
	 * @param a,p,r
	 * a是要排序的数组，p是要排序的数组的起点下标，r是终点下标
	 */
	public static void mergeSort(int a[],int p,int r){
		 if(p<r){
			 int q=(p+r)/2;//向上取整
			 mergeSort(a,p,q);
			 mergeSort(a,q+1,r);
			 merge(a,p,q,r);
		 }
	}
	public static void merge(int a[],int p,int q,int r){
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
				a[k]=R[j];
				j++;
			}else{
				a[k]=L[i];
				i++;
			}
		}
		//处理剩下的元素
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
	 * 5.快速排序：对于一组给定的记录，通过一趟排序后，将原序列分为两部分，其中前一部分的所有记录均比后一部分的所有
	 * 记录小，然后再依次对前后两部分的记录进行快速排序，递归该过程，直到所有记录均为有序。
	 * 关键思想：分而治之，把大的拆分为小的，小的拆分为更小的。
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
		index=a[i];//选择基准数
		while(i<j){
			while(i<j&&a[j]>=index){//在右边找到一个比基数小的
				j--;
			}
			if(i<j){
				a[i++]=a[j];
			}
			while(i<j&&a[i]<index){//在左边找到一个比基数大的
				i++;
			}
			if(i<j){
				a[j--]=a[i];
			}
		}
		a[i]=index;
		sort(a,low,i-1);
		sort(a,i+1,high);
	}
	/**
	 * 6.希尔排序：缩小增量排序。
	 * (1)先将待排序的数组元素分成多个子序列，使得每个子序列的元素个数相对较少
	 * (2)然后对各个子序列分别进行直接插入排序，待整个待排序序列基本有序后，最后再对所有元素进行一次直接排序。
	 * @param a
	 */
	public static void shellSort1(int a[]){
		int len=a.length;
		int i,j;
		int h;
		int temp;
		for(h=len/2;h>0;h=h/2){
			for(i=0;i<h;i++){
				//插入排序
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
						break;//跳出当前循环
					}
				}
				a[j+h]=temp;
			}
		}
	}
	
	/**
	 * 7.堆排序：一种树形选择排序。在排序过程中，将R[1...n]看做一颗完全二叉树结构，利用完全二叉树
	 * 中父结点和子结点之间的内在关系来选择最小的元素。
	 * 对于给定的n个记录，初始时把这些记录当做一颗顺序存储的二叉树，然后将其调整为一个大堆，进行交换后后
	 * 堆得最后一个元素即为最大记录；接着将前n-1个元素重交换。。。直至只剩下一个元素为止。
	 * 关键思想：二叉树
	 * （1）构建堆；（2）交换堆顶元素与最后一个元素的位置。
	 * @param a
	 */
	public static void heapSort(int a[]){
		int i;
		int len=a.length;
		for(i=len/2-1;i>=0;i--){//从最后一个非叶子节点开始，将每个父节点都调整为最大堆
			adjustHeap(a,i,len-1);
		}
		for(i=len-1;i>=0;i--){//交换堆顶元素与最后一个元素的位置
			int temp=a[0];
			a[0]=a[i];
			a[i]=temp;
			adjustHeap(a,0,i-1);
		}
		
	}
	//构建堆，pos为堆顶元素，len为最后一个child
	public static void adjustHeap(int a[],int pos,int len){
		int temp;
		int child;
		for(temp=a[pos];2*pos+1<=len;pos=child){//pos的左子结点为2*pos+1，右子结点为2*pos+2
			child=2*pos+1;//左子结点
			if(child<len&&a[child]<a[child+1]){//先找出左右结点中较大的那个结点
				child++;
			}
			if(a[child]>temp){//大数往上堆
				a[pos]=a[child];
			}else{
				break;//原本已是堆，如果在第一层没有找到，则表明没有更大的了，结束
			}
		}
		a[pos]=temp;
	}
	
	
}
