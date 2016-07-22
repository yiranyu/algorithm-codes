/* Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25. 
*/

/**
 * Definition for a binary tree node.
 */
 
function TreeNode(val) {
	this.val = val;
	this.left = this.right = null;
}

/**Tree, Depth-first Search
深度遍历:积累路径和，当遇到叶子节点时，表示一条路径结束
 * @param {TreeNode} root
 * @return {number}
 */
var sumNumbers = function(root) {
	var sum=0;
	getSum(root,0);
	return sum;
	
	function getSum(root,s){
		if(root===null){
			return;
		}
		if(root.left===null&&root.right===null){
			sum=sum+s*10+root.val;
			return;
		}
		getSum(root.left,s*10+root.val);
		getSum(root.right,s*10+root.val);
	}
};


//test
var nums=[1,2,3,4,5,6];
for(var i=0;i<nums.length;i++){
	nums[i]=new TreeNode(nums[i]);
}

nums[0].left=nums[1];
nums[0].right=nums[2];
nums[1].left=nums[3];
nums[1].right=nums[4];
nums[2].left=nums[5];

var sum=sumNumbers(nums[0]);
console.log(sum);//385