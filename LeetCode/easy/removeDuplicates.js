/* Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. 
It doesn't matter what you leave beyond the new length.
*/

/**Two point
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
	if(nums.length===1){
		return 0;
	}
    var i,cur=nums[0],pos=1;
	for(i=1;i<nums.length;i++){
		if(nums[i]!==cur){
			nums[pos]=nums[i];
			cur=nums[i];
			pos++;
		}
	}
	return pos;
};

var removeDuplicates2 = function(nums) {
	if(nums.length===0){
		return 0;
	}
    var i,pos=0;
	for(i=1;i<nums.length;i++){
		if(nums[i]!==nums[pos]){
			pos++;
			nums[pos]=nums[i];
		}
	}
	return pos++;
};

//test
var nums=[1,1,2];
var i=0,str='';
for(i=0;i<nums.length;i++){
	str=str+nums[i]+' ';
}
console.log(str);
console.log(removeDuplicates(nums));

str='';
for(i=0;i<nums.length;i++){
	str=str+nums[i]+' ';
}
console.log(str);