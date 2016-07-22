
/**
 Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

 According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
 For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself 
 */

/**
 * Definition for a binary tree node.
 
 */
function TreeNode(val) {
	this.val = val;
    this.left = this.right = null;
}

/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor = function(root, p, q) {
    var cur=root;
	while(root!==null){ //使用
		if(cur.val>p.val&&cur.val>q.val){
			cur=cur.left;
		}else if(cur.val<p.val&&cur.val<q.val){
			cur=cur.right;
		}else{
			return cur;
		}
	}
	return cur;
};
var tree=[5,3,6,2,4,null,null,1];
var i=0;
for(i=0;i<tree.length;i++){
	tree[i]=new TreeNode(tree[i]);
}
tree[0].left=tree[1];
tree[0].right=tree[2];
tree[1].left=tree[3];
tree[1].right=tree[4];
tree[2].left=tree[5];
tree[2].right=tree[6];
tree[3].left=tree[7];
for(i=0;i<tree.length;i++){
	console.log(tree[i].val);
}

console.log(lowestCommonAncestor(tree[0],tree[7],tree[4]).val);
