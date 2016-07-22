/**Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

 Note:
 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.

 */

/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums){
	var zeroCount=0,i;
	for(i=0;i<nums.length;i++){
		if(nums[i]===0){
			zeroCount++;
		}else{
			 /* Keep first one on it's position.
			   If there is any zero we found, 
			   we should move current index values to unused position, 
			   and let current index value be 0.
			*/
			if(i>0&&zeroCount>0){
				var emptyPos;
				emptyPos=i-zeroCount;
				
				nums[emptyPos]=nums[i];
				nums[i]=0;
			}
		}
	}
};

//test
var nums=[0,1,0,3,12];
var i=0,str='';
for(i=0;i<nums.length;i++){
	str=str+nums[i]+' ';
}
console.log(str);
moveZeroes(nums);

str='';
for(i=0;i<nums.length;i++){
	str=str+nums[i]+' ';
}
console.log(str);