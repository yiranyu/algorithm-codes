/* Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2. */

/**Two Pointers
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
var removeElement = function(nums, val) {
    var i,count=0;
	for(i=0;i<nums.length;i++){
		if(nums[i]===val){
			count++;
		}else{
			if(i>0&&count>0){
				nums[i-count]=nums[i];
				nums[i]=val;
			}
		}
	}
	return nums.length-count;
};
var removeElement2 = function(nums, val) {
	var i=0,j;
	for(j=0;j<nums.length;j++){
		if(nums[j]!==val){
			nums[i]=nums[j];
			i++;
		}
	}
	return i;
}
//test
var nums=[3,3,2,2];
var i=0,str='';
for(i=0;i<nums.length;i++){
	str=str+nums[i]+' ';
}
console.log(str);
console.log(removeElement2(nums, 3));

str='';
for(i=0;i<nums.length;i++){
	str=str+nums[i]+' ';
}
console.log(str);
