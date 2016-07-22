/**
 Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined 
 as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
*/

/**
 * Definition for a binary tree node.
*/

function TreeNode(val) {
	this.val = val;
	this.left = this.right = null;
}
 
/**Tree Depth-first Search
 * @param {TreeNode} root
 * @return {boolean}
 */
var isBalanced = function(root) {
    if(root===null){
		return true;
	}
	if(checkHeight(root)===-1){
		return false;
	}
	return true;
	//check height
	function checkHeight(root){
		if(root===null){
			return 0;
		}
		var left,right;
		left=checkHeight(root.left);
		right=checkHeight(root.right);
		
		if(left===-1||right===-1){//只要有一颗子树不平衡则不平衡
			return -1;
		}
		if(left-right>1||right-left>1){
			return -1;
		}
		return left>right?left+1:right+1;
	}
};

//test
var tree=[1,2,3];
var i;
for(i=0;i<tree.length;i++){
	tree[i]=new TreeNode(tree[i]);
}
tree[0].left=tree[1];
tree[0].right=tree[2];

console.log(isBalanced(tree[0]));
