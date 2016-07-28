package nowcoder;

import java.util.Stack;

/**
 * 二叉搜索树与双向链表 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 
 * @author lab2015
 * 
 */
public class TreeConvertToLinked {
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);

		node3.left = node2;
		node3.right = node5;
		node2.left = node1;
		node5.left = node4;
		node5.right = node6;

		printTree(node3);

		TreeNode head = convert2(node3);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.right;
		}
	}

	/**
	 * 对二叉搜索树进行中序遍历可以得到一个排序递增的序列
	 * 原先指向左子结点的指针调整为链表中指向前一个结点的指针，原先指向右子结点的指针调整为链表中指向后一个结点指针。 递归
	 * 
	 * @param root
	 * @return
	 */
	public static TreeNode convert(TreeNode root) {
		if (root == null) {
			return null;
		}
		if (root.left == null && root.right == null) {
			return root;
		}

		// 将左子树构造成双链表，并返回链表头结点
		TreeNode left = convert(root.left);
		// 定位到左子树双链表的最后一个节点
		TreeNode last = left;
		while (last != null && last.right != null) {
			last = last.right;
		}
		// 如果左子树链表不为空，则将当前的root追加到左子树链表
		if (left != null) {
			last.right = root;
			root.left = last;
		}

		// 将右子树构造成双链表，并返回链表头结点
		TreeNode right = convert(root.right);
		// 如果右子树链表不为空，则将该链表追加到root结点
		if (right != null) {
			right.left = root;
			root.right = right;
		}
		return left != null ? left : root;
	}

	/**
	 * 中序非递归
	 * 
	 * @param pRootOfTree
	 * @return
	 */
	public static TreeNode convert2(TreeNode root) {
		if (root == null) {
			return null;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		TreeNode pre = null; // 保存中序遍历序列中的上一个节点
		boolean isFirst = true;

		while (cur != null || !stack.isEmpty()) {
			// 左子树入栈
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			if (isFirst) {
				root = cur; // 将中序遍历中的第一个结点记录为链表头结点
				pre = root;
				isFirst = false;
			} else {
				pre.right = cur;
				cur.left = pre;
				pre = cur;
			}
			cur = cur.right;
		}
		return root;
	}

	/**
	 * 二叉树的非递归中序遍历
	 * 
	 * @param root
	 */
	public static void printTree(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode cur = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			System.out.print(cur.val + " ");
			cur = cur.right;
		}
		System.out.println();
	}
}
/**
 * public class TreeNode { int val = 0; TreeNode left = null; TreeNode right =
 * null;
 * 
 * public TreeNode(int val) { this.val = val;
 * 
 * }
 * 
 * }
 */
