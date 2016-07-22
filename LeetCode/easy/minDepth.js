/* Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
*/

/**
 * Definition for a binary tree node.
 */
function TreeNode(val) {
	this.val = val;
	this.left = this.right = null;
}

/**递归求解: DFS，我们只要叶子节点，和之前的Maximum Depth有点不一样
 * @param {TreeNode} root
 * @return {number}
 */
var minDepth = function(root) {
	return getDepth(root);
	
	function getDepth(root){
		if(root===null){
			return 0;
		}
		//选择叶子节点
		if(root.left===null){
		return getDepth(root.right)+1;
    	}
    	if(root.right===null){
    		return getDepth(root.left)+1;
    	}
		var left,right;
		left=getDepth(root.left);
		right=getDepth(root.right);
		
		return left<right?left+1:right+1;
	}
};

//test
var nums=[1,2];
for(var i=0;i<nums.length;i++){
	nums[i]=new TreeNode(nums[i]);
}
nums[0].left=nums[1];
console.log(minDepth(nums[0]));