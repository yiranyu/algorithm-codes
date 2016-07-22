/*350. Intersection of Two Arrays II
Given two arrays, write a function to compute their intersection.
Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
Note:
  ● Each element in the result should appear as many times as it shows in both arrays.
  ● The result can be in any order.
Follow up:
  ● What if the given array is already sorted? How would you optimize your algorithm?
  ● What if nums1's size is small compared to num2's size? Which algorithm is better?
  ● What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
*/

/**求两个数组的交集
1. indexOf 或者 lastIndexOf
2. 数组有序，考虑数组大小
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
 var intersect2 = function(nums1, nums2) {
    var i,
		index,
		nums=[],
		len1=nums1.length;
	for(i=0;i<len1;i++){
		//indexOf：从数组开头往后找元素，如果找到返回index，否则返回-1
		index=nums2.indexOf(nums1[i])
		if(index!==-1){ 
			nums.push(nums1[i]);
			nums2.splice(index,1);
		}
	}
	return nums;
};
var intersection = function(nums1, nums2) {
    var i,
		nums=[],
		shorter=[];
		larger=[];
		len1=nums1.length,
		len2=nums2.length;
	if(len1>len2){
		nums2.sort(compare);
		shorter=nums2;
		larger=nums1;
	}else{
		nums1.sort(compare);
		shorter=nums1;
		larger=nums2;
	}
	len1=larger.length;
	for(i=0;i<len1;i++){
		if(binarySearch(shorter,larger[i])){
			nums.push(larger[i]);
			shorter.splice(shorter.indexOf(larger[i]),1);
		}
	}
	return nums;
	//二分查找
	function binarySearch(nums,target){
		if(nums.length===0){
			return false;
		}
		var left=0,
			right=nums.length-1,
			mid=0;
		while(left<=right){
			mid=left+Math.ceil((right-left)/2);
			if(nums[mid]===target){
				return true;
			}
			if(nums[mid]>target){
				right=mid-1;
			}else{
				left=mid+1;
			}
		}
		return false;
	}
	//比较函数，数值升序排序
	function compare(a,b){
		return a-b;
	}
	
};

//test
var nums1=[61,24,20,58,95,53,17,32,45,85,70,20,83,62,35,89,5,95,12,86,58,77,30,64,46,13,5,92,67,40,20,38,31,18,89,85,7,30,67,34,62,35,47,98,3,41,53,26,66,40,54,44,57,46,70,60,4,63,82,42,65,59,17,98,29,72,1,96,82,66,98,6,92,31,43,81,88,60,10,55,66,82,0,79,11,81],
	nums2=[5,25,4,39,57,49,93,79,7,8,49,89,2,7,73,88,45,15,34,92,84,38,85,34,16,6,99,0,2,36,68,52,73,50,77,44,61,48];
var a=[1,4,2,3];
var nums=intersection(nums1,nums2);
console.log(nums);

