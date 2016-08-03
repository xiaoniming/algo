package Tests_Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

import Utils.U;

public class MaxDepthofTree {

	public MaxDepthofTree() {
		TreeNode t1 = new TreeNode(0);
		TreeNode t2 = new TreeNode(0);
		TreeNode t3 = new TreeNode(0);
		TreeNode t4 = new TreeNode(0);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		U.print(maxDepth(t1));
	}

	// recursion
	public int maxD(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + Math.max(maxD(root.left), maxD(root.right));

	}

	// my own low method
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int depth = 0;

		Deque<TreeNode> tree = new LinkedList<>();
		tree.addLast(root);

		// BFS search, level by level
		while (!tree.isEmpty()) {
			int size = tree.size();
			while (size > 0) { // Every level
				TreeNode cur = tree.pop();
				if (cur.left != null)
					tree.addLast(cur.left);
				if (cur.right != null)
					tree.addLast(cur.right);
				size--;
			}
			depth++;
		}
		return depth;

	}

	// used for creating test case
	public static void createNum(int n, long range) {
		// N = n;
		// data = new long[N];
		Random r = new Random();
		U.print(n);
		for (int i = 0; i < n; i++) {
			System.out.println("" + Math.abs(r.nextLong() % range));
			// data[i] = Math.abs(r.nextLong() % range);
		}
		// U.p(data);
	}

}
