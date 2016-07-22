/* 347. Top K Frequent Elements
 Given a non-empty array of integers, return the k most frequent elements.
For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].
Note: 
  ● You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
  ● Your algorithm's time complexity must be better than O(n log n), where n is the array's size. */
  
 /**Hash Table Heap
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var topKFrequent = function(nums, k) {
    var results=new Array(10),
		i,
		topk=[],
		len=nums.length;
	for(i=0;i<len;i++){
		if(typeof results[nums[i]] ==='undefined'){
			results[nums[i]]=0;
		}
		results[nums[i]]++;
	}
	
	len=results.length;
	console.log(results);
	for(i=0;i<k;i++){
		var bigger=0;
		for(var j in results){
			if(typeof results[j]!=='undefined'){
				if(typeof results[bigger]==='undefined'){
					bigger=j;
				}
				bigger=(results[j]-results[bigger]>0)?j:bigger;
			}
		}
		results[bigger]=0;
		topk.push(Number(bigger));
	}
	return topk;
};

//test
var nums=[1,2,9,7,7,98,98,98,98];
console.log(topKFrequent(nums,4));