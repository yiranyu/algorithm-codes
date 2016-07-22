/* 349. Intersection of Two Arrays My Submissions QuestionEditorial Solution
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order. 
*/

/**求两个数组的交集
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var intersection = function(nums1, nums2) {
    var i,
		nums=[],
		len1=nums1.length;
	for(i=0;i<len1;i++){
		//indexOf：从数组开头往后找元素，如果找到返回index，否则返回-1
		if(nums2.indexOf(nums1[i])!==-1&&nums.indexOf(nums1[i])===-1){ 
			nums.push(nums1[i]);
		}
	}
	return nums;
};

//test
var nums1=[1,2,3,3,3.4],
	nums2=[2,3,3,4,5];
var nums=intersection(nums1,nums2);
console.log(nums);