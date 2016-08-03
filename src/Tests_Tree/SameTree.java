package Tests_Tree;

import java.util.ArrayDeque;
import java.util.Deque;

import Utils.U;

public class SameTree {

	public SameTree() {
		// TreeNode t1 = new TreeNode(0);
		// TreeNode t2 = new TreeNode(1);
		// TreeNode t3 = new TreeNode(3);
		// TreeNode t4 = new TreeNode(3);
		// t1.left = t2;
		// t1.right = t3;
		// t2.left = t4;
		// TreeNode tt1 = new TreeNode(0);
		// TreeNode tt2 = new TreeNode(1);
		// TreeNode tt3 = new TreeNode(2);
		// TreeNode tt4 = new TreeNode(3);
		// tt1.left = tt2;
		// tt1.right = tt3;
		// tt2.left = tt4;
		TreeNode t1 = null;
		TreeNode tt1 = null;

		U.print(isSameTree(t1, tt1));
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {

		return (checkSame(p, q) && checkSame(q, p));

	}

	public boolean checkSame(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null && q != null || p != null && q == null)
			return false;
		Deque<TreeNode> queueP = new ArrayDeque<>();
		Deque<TreeNode> queueQ = new ArrayDeque<>();
		queueP.offer(p);
		queueQ.offer(q);
		while (!queueP.isEmpty()) {
			if (queueQ.isEmpty())
				return false;
			TreeNode curP = queueP.poll();
			TreeNode curQ = queueQ.poll();
			if (curP.val != curQ.val)
				return false;
			if (curP.left != null) {
				if (curQ.left == null)
					return false;
				queueP.offer(curP.left);
				queueQ.offer(curQ.left);
			}
			if (curP.right != null) {
				if (curQ.right == null)
					return false;
				queueP.offer(curP.right);
				queueQ.offer(curQ.right);
			}

		}
		return true;
	}

}
