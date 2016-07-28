package nowcoder;

import java.util.Stack;

/**
 * ������������˫������ ����һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
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
	 * �Զ�����������������������Եõ�һ���������������
	 * ԭ��ָ�����ӽ���ָ�����Ϊ������ָ��ǰһ������ָ�룬ԭ��ָ�����ӽ���ָ�����Ϊ������ָ���һ�����ָ�롣 �ݹ�
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

		// �������������˫��������������ͷ���
		TreeNode left = convert(root.left);
		// ��λ��������˫��������һ���ڵ�
		TreeNode last = left;
		while (last != null && last.right != null) {
			last = last.right;
		}
		// �������������Ϊ�գ��򽫵�ǰ��root׷�ӵ�����������
		if (left != null) {
			last.right = root;
			root.left = last;
		}

		// �������������˫��������������ͷ���
		TreeNode right = convert(root.right);
		// �������������Ϊ�գ��򽫸�����׷�ӵ�root���
		if (right != null) {
			right.left = root;
			root.right = right;
		}
		return left != null ? left : root;
	}

	/**
	 * ����ǵݹ�
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
		TreeNode pre = null; // ����������������е���һ���ڵ�
		boolean isFirst = true;

		while (cur != null || !stack.isEmpty()) {
			// ��������ջ
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			if (isFirst) {
				root = cur; // ����������еĵ�һ������¼Ϊ����ͷ���
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
	 * �������ķǵݹ��������
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
