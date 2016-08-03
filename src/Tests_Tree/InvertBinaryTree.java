package Tests_Tree;

import java.util.Deque;
import java.util.LinkedList;

import Utils.U;

public class InvertBinaryTree {

	public InvertBinaryTree() {
		TreeNode t1 = new TreeNode(0);
		TreeNode t2 = new TreeNode(0);
		TreeNode t3 = new TreeNode(0);
		TreeNode t4 = new TreeNode(0);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;

		invertTreeBFS(t1);
		U.print(t1.left == t2);
		U.print(t1.left == t3);
		U.print(t2.left == t4);
		U.print(t2.right == t4);
	}

	// recursive DFS -
	// it's easy to write and pretty much concise.
	public TreeNode invertTreeDFS(TreeNode root) {
		if (root == null)
			return null;
		TreeNode temp = root.right;
		root.right = invertTreeDFS(root.left);
		root.left = invertTreeDFS(temp);
		return root;
	}

	// The above solution is correct, but it is also bound to the application
	// stack, which means that it's no so much scalable - (you can find the
	// problem size that will overflow the stack and crash your application), so
	// more robust solution would be to use BFS - or so called level order
	// traversal
	public void invertTreeBFS(TreeNode root) {
		if (root == null)
			return;
		Deque<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode p = queue.poll();
			TreeNode temp = p.left;
			p.left = p.right;
			p.right = temp;
			if (p.left != null)
				queue.offer(p.left);
			if (p.right != null)
				queue.offer(p.right);
		}

	}

}
