/* 
 Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
*/

/**Level order:定义两个计数器分别指记录当前lever和下一lever的节点数，队列存储未访问的节点
与levelOrder1的区别在于放入nums数组中的方向不一样，push是添加是数组尾部，unshift是添加是数组头部
 * Definition for a binary tree node.
 */
 function TreeNode(val) {
	this.val = val;
	this.left = this.right = null;
}
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
    if(root===null){
		return [];
	}
	//sets two count to record the number of nodes in current lever and next lever.
	var nums=[],queue=[root],counts;
	var cur,curLever=1,nextLever=0;
	counts=[];
	while(queue.length>0){
		//gets a node
		cur=queue.shift();
		
		//updates the counts and other parameters when current lever is ordered in the end
		if(curLever===0){
			curLever=nextLever;
			nextLever=0;
			
			nums.unshift(counts); //different with 1
			counts=[];
		}
		curLever--;
		//adds it's children to the queue
		if(cur.left!==null){
			queue.push(cur.left);
			nextLever++;
		}
		if(cur.right!==null){
			queue.push(cur.right);
			nextLever++;
		}
		//adds the value to the array
		counts.push(cur.val);
	}
	nums.unshift(counts);
	return nums;
};
//减少了count，利用queue的大小判断
var levelOrder2 = function(root) {
    if(root===null){
		return [];
	}
	var nums=[],queue=[root],counts=[];
	var cur,size;
	while(queue.length>0){
		size=queue.length;
		while(size>0){
			cur=queue.shift();
			if(cur.left!==null){
				queue.push(cur.left);
			}
			if(cur.right!==null){
				queue.push(cur.right);
			}
			counts.push(cur.val);
			size--;
		}
		nums.unshift(counts);
		counts=[];
	}
	return nums;
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

var array=levelOrder2(nums[0]);
console.log(array);