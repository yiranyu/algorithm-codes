/* Two elements of a binary search tree (BST) are swapped by mistake.

 Recover the tree without changing its structure.

 Note:
 A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
*/

/**Tree, Depth-first Search
 * Definition for a binary tree node.
 */

function TreeNode(val) {
	this.val = val;
    this.left = this.right = null;
}

/**用结点的值代替结点.
如果把这棵二叉搜索树各结点的值用中序遍历的方式打印出来，那么就有一个位置上的数大于它后面相邻的数，
之后又有一个位置上的数小于它前面相邻的数:
	(1)先找出那个大于它后一个数的first
	(2)再找出那个小于它前一个数的数second，之后再交换两者的值就行了。
要实现这一点，需要保存前一个结点pre，然后找到pre>cur这种反常的情况（共两次）。
此时，若first已经被找到了，则我们让 sesond = cur；否则，我们让 first = pre。

考虑两个数相邻的情况:由于两个数相邻，我们只能找到一次 pre>cur的情况，无法对second进行赋值。但我们
注意到，此时cur刚好就是我们要找的second。再回到一般情况，就算此时的cur不是我们要找的second，在后面
第二次出现pre>cur的情况时，依旧会对second赋值。所以，我们在第一次遇到pre>cur的情况时，分别将pre和cur
赋值给first和second，在后面如果再次遇到pre>cur的情况，我们再将second修改为正确的值，并保持first的值不变。
这样，我们总能找到正确的first和second。

 * @param {TreeNode} root
 * @return {void} Do not return anything, modify root in-place instead.
 */
var recoverTree = function(root) {
	var first=null,second=null,pre=null;
    if(root===null){
		return;
	}
	//depth-first search
	function dfs(root){
		if(root.left!==null){
			dfs(root.left);
		}
		if(pre!==null&&pre.val>root.val){
			if(first===null){
				first=pre;
			}
			second=root;
		}
		pre=root;
		if(root.right!==null){
			dfs(root.right);
		}
	}
	dfs(root);
	if(first!==null&&second!==null){
		var temp=first.val;
		first.val=second.val;
		second.val=temp;
	}
};

//test
var tree=[1,2,3];
var i,str='';
for(i=0;i<tree.length;i++){
	tree[i]=new TreeNode(tree[i]);
}
tree[0].left=tree[1];
tree[0].right=tree[2];
for(i=0;i<tree.length;i++){
	str=str+tree[i].val+' ';
}
console.log(str);
recoverTree(tree[0]);
str='';
for(i=0;i<tree.length;i++){
	str=str+tree[i].val+' ';
}
console.log(str);