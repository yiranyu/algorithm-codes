/* 152. Maximum Product Subarray
Find the contiguous subarray within an array (containing at least one number) which has the largest product.
For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6. 
*/
/**求解毗邻子数组最大的乘积:最核心的步骤就是要写出其状态转移方程
 *要考虑到一种特殊情况，即负数和负数相乘：如果前面得到一个较小的负数，
 和后面一个较大的负数相乘，得到的反而是一个较大的数
 * Array Dynamic Programming
 * @param {number[]} nums
 * @return {number}
 */
var maxProduct = function(nums) {
	if(nums===null||!nums.length){
		return 0;
	}
	if(nums.length===1){
		return nums[0];
	}
	
	var max=nums[0],min=nums[0],temp,result=nums[0],i;
	
	for(i=1;i<nums.length;i++){
		temp=max;
		//如果之前的最大和最小累乘值同当前元素相乘之后没有当前元素大（或小）那么当前元素就可作为新的起点
		max=Math.max(Math.max(nums[i]*max,nums[i]),nums[i]*min);
		min=Math.min(Math.min(nums[i]*temp,nums[i]),nums[i]*min); //保留最小值（为负数时可用）
		result=Math.max(result,max);
	}
    
	return result;
};

//test
var nums=[2,3,-2,4];
console.log(maxProduct(nums));