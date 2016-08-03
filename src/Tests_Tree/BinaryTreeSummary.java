package Tests_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Utils.U;

public class BinaryTreeSummary {

	public BinaryTreeSummary() {

	}

	/**
	 * 求二叉树中的节点个数递归解法： O(n) （1）如果二叉树为空，节点个数为0 （2）如果二叉树不为空，二叉树节点个数 = 左子树节点个数 +
	 * 右子树节点个数 + 1
	 */
	public int getNodeNumRec(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + getNodeNumRec(root.right) + getNodeNumRec(root.left);
	}

	/**
	 * 求二叉树中的节点个数迭代解法O(n)：基本思想同LevelOrderTraversal，
	 * 即用一个Queue，在Java里面可以用LinkedList来模拟
	 */
	public int getNodeNum(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode cur;
		int nodeNum = 1;
		queue.add(root);
		while (!queue.isEmpty()) {
			cur = queue.poll();
			if (cur.left != null) {
				queue.add(cur.left);
				nodeNum++;
			}
			if (cur.right != null) {
				queue.add(cur.right);
				nodeNum++;
			}
		}

		return nodeNum;
	}

	/**
	 * 求二叉树的深度（高度） 递归解法： O(n) （1）如果二叉树为空，二叉树的深度为0 （2）如果二叉树不为空，二叉树的深度 =
	 * max(左子树深度， 右子树深度) + 1
	 */

	public int getDepthRec(TreeNode root) {
		if (root == null)
			return 0;
		else
			return 1 + Math.max(getDepthRec(root.left), getDepthRec(root.right));

	}

	/**
	 * 求二叉树的深度（高度） 迭代解法： O(n)
	 */
	public int getDepth(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		TreeNode cur = root;
		int depth = 0;
		int levelSize;// 当前层node数量
		while (!queue.isEmpty()) {
			levelSize = queue.size();
			while (levelSize > 0) {
				cur = queue.poll();
				if (cur.left != null) {
					queue.add(cur.left);
				}
				if (cur.right != null) {
					queue.add(cur.right);
				}
				levelSize--;
			}
			depth++;
		}
		return depth;
	}

	/**
	 * 中序遍历递归解法 （1）如果二叉树为空，空操作。 （2）如果二叉树不为空，中序遍历左子树，访问根节点，中序遍历右子树
	 */
	public void LDRRec(TreeNode root) {
		if (root == null)
			return;
		LDRRec(root.left);
		U.print(root.val);
		LDRRec(root.right);
	}

	/**
	 * 中序遍历迭代解法 ，用栈先把根节点的所有左孩子都添加到栈内， 然后输出栈顶元素，再处理栈顶元素的右子树
	 * http://www.youtube.com/watch?v=50v1sJkjxoc
	 * 
	 * 还有一种方法能不用递归和栈，基于线索二叉树的方法，较麻烦以后补上
	 * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and
	 * -without-stack/
	 */
	public void LDR(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while (true) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			if (stack.isEmpty()) {
				break;
			}
			// no left node now
			cur = stack.pop();
			U.print(cur.val);
			cur = cur.right;
		}
	}

	/**
	 * 前序遍历递归解法
	 */
	public void DLRRec(TreeNode root) {
		if (root == null)
			return;
		U.print(root.val);
		DLRRec(root.left);
		DLRRec(root.right);
	}

	/**
	 * 前序遍历迭代解法
	 */

	public void DLR(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		// while (true) {
		// while (cur != null) {
		// U.p(cur.val);
		// stack.push(cur);
		// cur = cur.left;
		// }
		// if (stack.isEmpty())
		// break;
		// cur = stack.pop().right;
		// }

		// Method2: 用一个辅助stack，总是把右孩子放进栈
		// http://www.youtube.com/watch?v=uPTCbdHSFg4
		stack.push(cur);
		while (!stack.isEmpty()) {
			cur = stack.pop();
			U.print(cur.val);
			if (cur.right != null)
				stack.push(cur.right);
			if (cur.left != null)
				stack.push(cur.left);
		}
	}

	public void LRDRec(TreeNode root) {
		if (root == null)
			return;
		LRDRec(root.left);
		LRDRec(root.right);
		U.print(root.val);
	}

	// 我没想到的方法。。。
	/**
	 * 后序遍历迭代解法 http://www.youtube.com/watch?v=hv-mJUs5mvU
	 * 用两个stack，一个用来pop出栈顶放入第二个stack（用于翻转输出），再依次存入左右节点，
	 * 
	 * 第一个stack倒空了即为结束
	 */
	public void LRD(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		Stack<TreeNode> output = new Stack<>();
		TreeNode cur = root;
		stack.push(cur);

		while (!stack.isEmpty()) {// 确保所有元素都被翻转转移到第二个stack
			// pop出栈顶
			cur = stack.pop();
			output.push(cur);

			// 把栈顶元素的左右子节点分别添加入第一个stack
			if (cur.left != null) {
				stack.push(cur.left);
			}
			if (cur.right != null) {
				stack.push(cur.right);
			}
		}
		// 遍历输出第二个stack，即为后序遍历
		while (!output.isEmpty()) {
			cur = output.pop();
			U.print(cur.val);
		}
	}

	/**
	 * 分层遍历二叉树（按层次从上往下，从左往右）迭代
	 * 相当于广度优先搜索，使用队列实现。队列初始化，将根节点压入队列。当队列不为空，进行如下操作：弹出一个节点
	 * ，访问，若左子节点或右子节点不为空，将其压入队列
	 */

	public void levelTraversal(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<>();
		int levelSize;
		TreeNode cur = root;
		queue.add(cur);
		while (!queue.isEmpty()) {
			levelSize = queue.size();
			while (levelSize > 0) {
				cur = queue.poll();
				System.out.print(cur.val + " ");
				levelSize--;
				if (cur.left != null) {
					queue.add(cur.left);
				}
				if (cur.right != null) {
					queue.add(cur.right);
				}
			}
			System.out.println();
		}
	}

	/***
	 * 分层遍历二叉树（递归） 很少有人会用递归去做level traversal
	 * 基本思想是用一个大的ArrayList，里面包含了每一层的ArrayList。 大的ArrayList的size和level有关系
	 * 
	 * 这是我目前见到的最好的递归解法！ *
	 */
	public void levelTraversalRec(TreeNode root) {

		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		dfs(root, 0, arr);
		System.out.println(arr);
	}

	public void dfs(TreeNode root, int level, ArrayList<ArrayList<Integer>> arr) {
		if (root == null)
			return;
		if (level >= arr.size())
			arr.add(level, new ArrayList<Integer>());
		arr.get(level).add(root.val);
		dfs(root.left, level + 1, arr);
		dfs(root.right, level + 1, arr);
	}

	/**
	 * converting a binary search tree to doubly linked list
	 */

	public static void main(String args[]) {
		BinaryTreeSummary bts = new BinaryTreeSummary();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.right = t6;
		bts.levelTraversalRec(t1);
	}

}
