/* Given a binary tree, find its maximum depth.
 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node. 
*/

/**
 * Definition for a binary tree node.
 */
function TreeNode(val) {
	this.val = val;
	this.left = this.right = null;
}

/**recursion
 * @param {TreeNode} root
 * @return {number}
 */
var maxDepth = function(root) {
	
	function getDepth(root){
		if(root===null){
			return 0;
		}
		var left,right;
		left=getDepth(root.left);
		right=getDepth(root.right);
		return left>right?left+1:right+1;
	}
	return getDepth(root);
};

//test
var nums=[1,2,3,4,5];
for(var i=0;i<nums.length;i++){
	nums[i]=new TreeNode(nums[i]);
}
nums[0].left=nums[1];
nums[0].right=nums[2];
nums[1].left=nums[3];
nums[1].right=nums[4];

console.log(maxDepth(nums[0]));