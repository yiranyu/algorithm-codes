/**
 Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST. 
*/

/**
 * Definition for singly-linked list.
 */
function ListNode(val) {
	this.val = val;
	this.next = null;
}
/**
 * Definition for a binary tree node.
 */
function TreeNode(val) {
	this.val = val;
	this.left = this.right = null;
}
/**balanced BST,Depth-first Search Linked List
二叉排序树保证平衡的基本思想是：每当在二叉排序树种插入一个结点时，首先要检查其插入路径上的结点是否因为此次操作而导致了不平衡。
如果导致了不平衡，则先找到插入路径上离插入结点最近的平衡因子绝对值大于1的结点A,再对以A为根的子树，在保证二叉排序树特性的 前提
下，调整各结点的位置关系，使之重新达到平衡。
此题因为链表有序，关键是能找出当前链表的中间节点，然后再递归创建左右子树
 * @param {ListNode} head
 * @return {TreeNode}
 */
var sortedListToBST = function(head) {
    if (!head) {
        return null;
    }

    if (!head.next) {
        return new TreeNode(head.val);
    }
	//two point,a slow and a fast
    var prev=head,slow=head,fast=head;

    // head, prev, slow,fast-> ... -> null. Find the slow node
    while (fast && fast.next) {
        fast = fast.next.next;
        prev = slow;
        slow = slow.next;
    }
   /*  create a node with slow, 
	left subtree(head -> ... -> prev) 
	right subtree(slow.next -> ... -> null) 
   */
    prev.next = null;

    var node = new TreeNode(slow.val);
    node.left = sortedListToBST(head);
    node.right = sortedListToBST(slow.next);
    return node;
};

//test
var nums=[1,2,3,4];
var i;
for(i=0;i<nums.length;i++){
	nums[i]=new ListNode(nums[i]);
}
nums[0].next=nums[1];
nums[1].next=nums[2];
nums[2].next=nums[3];

console.log(sortedListToBST(nums[0]));
